%-----------------------------------------------------------------------
% requirements = { SPM12 }
% author = { Yoshiharu Ikutani }
%-----------------------------------------------------------------------

function ret = multiple_regression(input_scans, explicit_mask, regs, reg_name, output_dir)

% Initialise SPM
clear matlabbatch;
spm('Defaults','fMRI');
spm_jobman('initcfg');

% set params
matlabbatch{1}.spm.stats.factorial_design.dir               = {output_dir};
matlabbatch{1}.spm.stats.factorial_design.des.mreg.scans    = input_scans;
matlabbatch{1}.spm.stats.factorial_design.des.mreg.mcov     = struct('c', {}, 'cname', {}, 'iCC', {});
matlabbatch{1}.spm.stats.factorial_design.des.mreg.incint   = 1;
matlabbatch{1}.spm.stats.factorial_design.cov.c             = regs;
matlabbatch{1}.spm.stats.factorial_design.cov.cname         = reg_name;
matlabbatch{1}.spm.stats.factorial_design.cov.iCFI          = 1;
matlabbatch{1}.spm.stats.factorial_design.cov.iCC           = 1;
matlabbatch{1}.spm.stats.factorial_design.multi_cov         = struct('files', {}, 'iCFI', {}, 'iCC', {});
matlabbatch{1}.spm.stats.factorial_design.masking.tm.tm_none = 1;
matlabbatch{1}.spm.stats.factorial_design.masking.im        = 0;
matlabbatch{1}.spm.stats.factorial_design.masking.em        = {explicit_mask};
matlabbatch{1}.spm.stats.factorial_design.globalc.g_omit    = 1;
matlabbatch{1}.spm.stats.factorial_design.globalm.gmsca.gmsca_no = 1;
matlabbatch{1}.spm.stats.factorial_design.globalm.glonorm   = 1;

% run spm batch
spm_jobman('run', matlabbatch);

end%function