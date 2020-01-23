%-----------------------------------------------------------------------
% requirements = { SPM12 }
% author = { Yoshiharu Ikutani }
%-----------------------------------------------------------------------

function ret = coregister(subj_preproc_dir)

% Initialise SPM
clear matlabbatch;
spm('Defaults','fMRI');
spm_jobman('initcfg');

% set params
subj_preproc_run_dir = grep_files(subj_preproc_dir, 'run-.*', 1);
refRun      = 4;
tmp         = grep_files(subj_preproc_run_dir{refRun}, '^mean.*.nii', 1);
mean_epi    = {strcat(tmp{1}, ',1')};
t1_img      = grep_files(fullfile(subj_preproc_dir, 'anat'), 'sub-.*_T1w.nii', 1);

matlabbatch{1}.spm.spatial.coreg.estimate.ref       = mean_epi;
matlabbatch{1}.spm.spatial.coreg.estimate.source    = t1_img;
matlabbatch{1}.spm.spatial.coreg.estimate.other     = {''};
matlabbatch{1}.spm.spatial.coreg.estimate.eoptions.cost_fun = 'nmi';
matlabbatch{1}.spm.spatial.coreg.estimate.eoptions.sep  = [4 2];
matlabbatch{1}.spm.spatial.coreg.estimate.eoptions.tol  = [0.02 0.02 0.02 0.001 0.001 0.001 0.01 0.01 0.01 0.001 0.001 0.001];
matlabbatch{1}.spm.spatial.coreg.estimate.eoptions.fwhm = [7 7];

% run spm batch
spm_jobman('run', matlabbatch);

% move spm_.*.ps file
ps_file = dir([pwd '/spm*.ps']);
if ~isempty(ps_file); movefile(fullfile(pwd, ps_file.name), fullfile(subj_preproc_dir, 'spm_coregiser.ps')); end

end