%-----------------------------------------------------------------------
% requirements = { SPM12 }
% author = { Yoshiharu Ikutani }
%-----------------------------------------------------------------------

function ret = glm_estimate(subj_preproc_dir)

% Initialise SPM
clear matlabbatch;
spm('Defaults','fMRI');
spm_jobman('initcfg');

% find SPM.mat
spm_mat = grepFile(subj_preproc_dir, 'SPM.mat', 1);

% set batch
matlabbatch{1}.spm.stats.fmri_est.spmmat = spm_mat;
matlabbatch{1}.spm.stats.fmri_est.write_residuals = 0;
matlabbatch{1}.spm.stats.fmri_est.method.Classical = 1;

% run spm batch
spm_jobman('run', matlabbatch);

end