%-----------------------------------------------------------------------
% requirements = { SPM12 }
% author = { Yoshiharu Ikutani }
%-----------------------------------------------------------------------

function ret = glm_analysis(subj_preproc_dir)

% Initialise SPM
clear matlabbatch;
spm('Defaults','fMRI');
spm_jobman('initcfg');

% create directory for output
subj_beta_dir = fullfile(subj_preproc_dir, 'beta');
mkdir_if_not_exist(subj_beta_dir);

% set batch
matlabbatch{1}.spm.stats.fmri_spec.dir = {subj_beta_dir};
matlabbatch{1}.spm.stats.fmri_spec.timing.units = 'scans';
matlabbatch{1}.spm.stats.fmri_spec.timing.RT = 2;
matlabbatch{1}.spm.stats.fmri_spec.timing.fmri_t = 16;
matlabbatch{1}.spm.stats.fmri_spec.timing.fmri_t0 = 8;

%% set batch for each run
subj_preproc_run_dir = grep_files(subj_preproc_dir, 'run-.*', 1);
event_files = grep_files(fullfile(subj_preproc_dir, 'events'), '^sub-.*_events.tsv', 1);

for run_index = 1:length(subj_preproc_run_dir)
    
    % set scans and parameters
    input_scans = strcat(grep_files(subj_preproc_run_dir{run_index}, '^war_.*.nii', 1), ',1');
    align_param = grepFile(subj_preproc_run_dir{run_index}, '^rp.*.txt', 1);
    matlabbatch{1}.spm.stats.fmri_spec.sess(run_index).scans = input_scans;
    matlabbatch{1}.spm.stats.fmri_spec.sess(run_index).multi_reg = align_param;

    % read event file
    events = struct2table(tdfread(event_files{run_index}));
    events = events(~strcmp(cellstr(events.event_type), 'dummy_trial'),:);
    events.onset = (events.onset - 16) / 2; % convert from 'sec' to 'scans'
    events.duration = events.duration  / 2; % convert from 'sec' to 'scans'
    
    % set regressors
    events_source_code = events(strcmp(cellstr(events.event_type), 'source_code'), :);
    for reg_index = 1:height(events_source_code)
        T = events_source_code(reg_index,:);
        reg_name = sprintf('%02d_%02d_%s_%s', run_index, T.trial_no, strtrim(T.category), strtrim(T.subcategory));
        matlabbatch{1}.spm.stats.fmri_spec.sess(run_index).cond(reg_index).name    = reg_name;
        matlabbatch{1}.spm.stats.fmri_spec.sess(run_index).cond(reg_index).onset   = T.onset;
        matlabbatch{1}.spm.stats.fmri_spec.sess(run_index).cond(reg_index).duration = T.duration;
        matlabbatch{1}.spm.stats.fmri_spec.sess(run_index).cond(reg_index).tmod    = 0;
        matlabbatch{1}.spm.stats.fmri_spec.sess(run_index).cond(reg_index).pmod    = struct('name', {}, 'param', {}, 'poly', {});
        matlabbatch{1}.spm.stats.fmri_spec.sess(run_index).cond(reg_index).orth    = 1;
    end

    % set other parameters
    matlabbatch{1}.spm.stats.fmri_spec.sess(run_index).multi = {''};
    matlabbatch{1}.spm.stats.fmri_spec.sess(run_index).regress = struct('name', {}, 'val', {});
    matlabbatch{1}.spm.stats.fmri_spec.sess(run_index).hpf = 128;

end

%%
matlabbatch{1}.spm.stats.fmri_spec.fact     = struct('name', {}, 'levels', {});
matlabbatch{1}.spm.stats.fmri_spec.bases.hrf.derivs = [0 0];
matlabbatch{1}.spm.stats.fmri_spec.volt     = 1;
matlabbatch{1}.spm.stats.fmri_spec.global   = 'None';
matlabbatch{1}.spm.stats.fmri_spec.mthresh  = 0.8;
matlabbatch{1}.spm.stats.fmri_spec.mask     = {''};
matlabbatch{1}.spm.stats.fmri_spec.cvi      = 'AR(1)';

%% run spm batch
spm_jobman('run', matlabbatch);

end