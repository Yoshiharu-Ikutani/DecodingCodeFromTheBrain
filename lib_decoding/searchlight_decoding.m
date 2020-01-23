%-----------------------------------------------------------------------
% requirements = { The Decoding Toolbox (https://sites.google.com/site/tdtdecodingtoolbox/) }
% author = { Yoshiharu Ikutani }
%-----------------------------------------------------------------------

function ret = searchlight_decoding(subj_single_dir, mask_output_dir, decoding_result_dir, radius)

% set params
[~, subj_name]          = fileparts(subj_single_dir);
enableScalling          = false; % set FALSE only for demo; TRUE was used for the original paper setting.
enableParameterSearch   = false; % set FALSE only for demo; TRUE was used for the original paper setting.
if ~exist('radius', 'var') radius = 4; end % use a four-voxel-radius as default

% create result output directory
subj_single_output_dir = fullfile(decoding_result_dir, ['searchlight_radius_', num2str(radius), '_category']);
mkdir_if_not_exist(subj_single_output_dir);

% set input paths
mask_file       = grep_files(mask_output_dir, 'average_GM_optthr.nii', 1);
subj_beta_dir   = fullfile(subj_single_dir, 'preproc/beta');

%% set cfg for decoding
cfg             = decoding_defaults();
reg_names       = design_from_spm(subj_beta_dir);
label_names     = {'regexp:.*_Math_.*', 'regexp:.*_Search_.*', ...
                   'regexp:.*_Sort_.*', 'regexp:.*_String_.*'};
labels          = 1:size(label_names, 2);
beta_img        = grep_files(subj_beta_dir, 'beta.*.nii', 1);
cfg             = decoding_describe_data(cfg, label_names, labels, ...
                                         reg_names, beta_img);
cfg.design      = make_design_cv(cfg);
cfg.plot_design = 0;
cfg.verbose     = 1; % default console output
cfg.design.unbalanced_data = 'ok';
cfg.analysis    = 'searchlight';
cfg.files.mask  = mask_file; % set gray matter mask
cfg.searchlight.radius      = radius; % default = 4 [voxels]
cfg.searchlight.spherical   = 1; % make the searchlight be spherical

%% set classification software
% -s 0 : C-SVC
% -t 0 : linear = u'*v
% -c 1 : set the parameter C of C-SVC to '1'
% -m 1000 : increase chached memory to 1GB (default = 40MB)
cfg.decoding.software   = 'libsvm';
cfg.decoding.method     = 'classification';
cfg.decoding.train.classification.model_parameters  = '-s 0 -t 0 -c 1 -m 1000 -q';
cfg.decoding.test.classification.model_parameters   = '-q';

% scalling
if enableScalling
    cfg.scale.estimation    = 'across';
    cfg.scale.method        = 'z';
    cfg.scale.cutoff        = [-3 3];
    fprintf("scaling enabled\n");
end

% for parameter selections
if enableParameterSearch
    % grid search (currently the only implemented method)
    cfg.parameter_selection.method      = 'grid';
    cfg.parameter_selection.parameters  = {'-c'};
    cfg.parameter_selection.parameter_range = [0.1 1 10];
    cfg.parameter_selection.results.output  = {'accuracy_minus_chance'};
    fprintf("parameter search enabled\n");
end

% specify output name and location
cfg.results.dir         = subj_single_output_dir;
cfg.results.output      = {'accuracy', 'accuracy_minus_chance', 'confusion_matrix'};
cfg.results.filestart   = subj_name;
cfg.results.write       = 1; % output in matfile and images

% run
ret = decoding(cfg);

end%function