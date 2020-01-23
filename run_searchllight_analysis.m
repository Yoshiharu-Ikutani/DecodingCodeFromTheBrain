%-----------------------------------------------------------------------
% requirements = { The Decoding Toolbox (https://sites.google.com/site/tdtdecodingtoolbox/) }
% requirements = { SPM Masking Toolbox (http://www0.cs.ucl.ac.uk/staff/g.ridgway/masking/) }
% author = { Yoshiharu Ikutani }
%-----------------------------------------------------------------------

% set the absolute path to the root directory of this repository
set_path_of_root_directory;

% specify the path to directory containing MRI data ('named like 'sub-01', 'sub-02', ...)
data_dir    = fullfile(root_dir, 'ds002411');
subj_dir    = grep_files(data_dir, 'sub-.*', 1);

% create an average gray-matter mask of all subjects
mask_output_dir = fullfile(data_dir, 'mask');
mkdir_if_not_exist(mask_output_dir);
if isempty(grep_files(mask_output_dir, 'average_GM.*.nii'))
    masking(subj_dir, mask_output_dir);
end

% create directory for decoding results
decoding_result_dir = fullfile(data_dir, 'results');
mkdir_if_not_exist(decoding_result_dir);

%% run searchlight decoding of 'category'
% WARNING: this computation may take several hours or few days !!!
radius = 4; % use a four-voxel-radius searchlight
subj_single_dir = subj_dir{1}; % use MRI data of 'sub-1' for demo
ret = searchlight_decoding(subj_single_dir, mask_output_dir, decoding_result_dir, radius);

%% run searchlight decoding of 'subcategory'
% WARNING: this computation may take several hours or a day !!!
radius = 4; % use a four-voxel-radius searchlight
subj_single_dir = subj_dir{1}; % use MRI data of 'sub-1' for demo
ret = searchlight_decoding_subcategory(subj_single_dir, mask_output_dir, decoding_result_dir, radius);