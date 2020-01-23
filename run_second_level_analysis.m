%-----------------------------------------------------------------------
% requirements = { SPM12 }
% author = { Yoshiharu Ikutani }
%-----------------------------------------------------------------------

% set params
set_path_of_root_directory;
DECODING_RESULT_IDENTITY = 'searchlight_radius_4_category';
ANALYSIS_OUTPUT_NAME     = 'sl_rad4_category';

% specify the path to directory containing decoding results
data_dir    = fullfile(root_dir, 'ds002411');
decoding_result_dir = fullfile(data_dir, 'results', DECODING_RESULT_IDENTITY);

% specify the mask to limit the target space
mask_output_dir = fullfile(data_dir, 'mask');
mask_file = grep_files(mask_output_dir, 'average_GM_optthr.nii', 1);

% create directory for outputs
analysis_output_dir = fullfile(data_dir, 'results', ANALYSIS_OUTPUT_NAME);
analysis_output_data_dir = fullfile(analysis_output_dir, 'data');
mkdir_if_not_exist(analysis_output_dir);
mkdir_if_not_exist(analysis_output_data_dir);

% copy all 'sub-.*_accuracy_minus_chance.nii' files to 'analysis_output_data_dir'
decoding_result_files = grep_files(decoding_result_dir, '^sub-.*_accuracy_minus_chance.nii$', 1);
for ii = 1:length(decoding_result_files)
    copyfile(decoding_result_files{ii}, analysis_output_data_dir);
end%ii

% apply smoothing for all accuracy maps in 'analysis_output_data_dir'
input_scans = strcat(grep_files(analysis_output_data_dir, '^sub-.*_accuracy_minus_chance.nii$', 1), ',1');
smoothing(input_scans);

%% RUN second-level analysis [1]
% t-test to examine 'where we could decode the functional categories of source code from brain activities'
input_scans     = strcat(grep_files(analysis_output_data_dir, '^s_sub-.*_accuracy_minus_chance.nii$', 1), ',1');
explicit_mask   = mask_file{1};
output_dir      = fullfile(analysis_output_dir, 'all_than_chance');
second_level_within(input_scans, explicit_mask, output_dir);
glm_estimate(output_dir);

%% RUN second-level analysis [2]
% t-test to investigate a linear correlation between behavioral performances
% and decoding accuracies for each searchlight location.
participants = struct2table(tdfread(fullfile(data_dir, 'participants.tsv')));
regressors   = participants.performance_MRI(1:length(input_scans)); % this may be changes for your analysis
reg_name     = 'behavioral performance';
output_dir   = fullfile(analysis_output_dir, 'corr_behavior');
multiple_regression(input_scans, explicit_mask, regressors, reg_name, output_dir);
glm_estimate(output_dir);