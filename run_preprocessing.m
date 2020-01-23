%-----------------------------------------------------------------------
% requirements = { SPM12 }
% author = { Yoshiharu Ikutani }
%-----------------------------------------------------------------------

% set the absolute path to the root directory of this repository
set_path_of_root_directory;

% specify the path to directory containing MRI data ('named like 'sub-01', 'sub-02', ...)
data_dir    = fullfile(root_dir, 'ds002411');

% get names of subject data directories (./dataset/sub-*)
subj_dir    = grep_files(data_dir, 'sub-.*', 1);

% set 'true' if you wanna delete all middle files after all preprocessing were done.
DELETE_MIDDLE_FILES_AFTER_PROCESSING = true;

% apply pre-processing to every subject data
for subj_index = 1
    
    % set paths
    subj_anat_dir  = grep_files(subj_dir{subj_index}, 'anat', 1);
    subj_func_dir  = grep_files(subj_dir{subj_index}, 'func', 1);
    
    % make directory for preprocessing
    subj_preproc_dir = fullfile(subj_dir{subj_index}, 'preproc');
    mkdir_if_not_exist(subj_preproc_dir);
    
    % unzip all .nii.gz files
    subj_anat_scan_gz = grep_files(subj_anat_dir{1}, '.*.nii.gz', 1);
    subj_bold_scan_gz = grep_files(subj_func_dir{1}, '.*.nii.gz', 1);
    if isempty(grep_files(subj_anat_dir{1}, '.*.nii$', 1)); gunzip(subj_anat_scan_gz); end
    if isempty(grep_files(subj_func_dir{1}, '.*.nii$', 1)); gunzip(subj_bold_scan_gz); end
    
    % 4D to 3D conversion and
    % remove first 8 scans from 'sub-*_task-ProgramCategorization_run-*_bold.nii'
    split_and_clean(subj_func_dir, subj_preproc_dir);
    
    % copy 'sub-*_T1w.nii' to subj_preproc_dir
    mkdir_if_not_exist(fullfile(subj_preproc_dir, 'anat'));
    t1_scan = grep_files(subj_anat_dir{1}, 'sub-.*_T1w.nii$', 1);
    [~, fn] = fileparts(t1_scan{1});
    copyfile(t1_scan{1}, fullfile(subj_preproc_dir, 'anat', [fn, '.nii']));
    
    % copy event files to subj_preproc_dir
    mkdir_if_not_exist(fullfile(subj_preproc_dir, 'events'));
    event_files = grep_files(subj_func_dir{1}, '^sub-.*_events.tsv$', 1);
    for fi = 1:length(event_files)
        [~, fn] = fileparts(event_files{fi});
        copyfile(event_files{fi}, fullfile(subj_preproc_dir, 'events', [fn, '.tsv']));
    end

    % run preprocessing
    realign_multi_section(subj_preproc_dir);
    slice_timing_correction(subj_preproc_dir);
    coregister(subj_preproc_dir);
    normalize(subj_preproc_dir);
    segmentation(subj_preproc_dir);
    
    % run GLM analysis to generate beta maps
    glm_analysis(subj_preproc_dir);
    glm_estimate(fullfile(subj_preproc_dir, 'beta'));
    
    % delete middle files if the user wants
    if (DELETE_MIDDLE_FILES_AFTER_PROCESSING)
        subj_preproc_run_dir = grep_files(subj_preproc_dir, 'run-.*', 1);
        for ii = 1:length(subj_preproc_run_dir)
            middle_files = [grep_files(subj_preproc_run_dir{ii}, '^sub-.*.nii', 1)
                            grep_files(subj_preproc_run_dir{ii}, '^r_sub-.*.nii', 1); ...
                            grep_files(subj_preproc_run_dir{ii}, '^ar_sub-.*.nii', 1)];
            for fi = 1:length(middle_files)
                delete(middle_files{fi});
            end%fi
        end%ii
    end

end%subj_index