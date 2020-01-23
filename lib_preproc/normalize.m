%-----------------------------------------------------------------------
% requirements = { SPM12 }
% author = { Yoshiharu Ikutani }
%-----------------------------------------------------------------------

function ret = normalize(subj_preproc_dir)

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

% store input nii file name
input_scans = {};
for ii = 1:length(subj_preproc_run_dir)
    input_scans = [input_scans; ...
                   strcat(grep_files(subj_preproc_run_dir{ii}, '^ar_sub.*.nii', 1), ',1')];
end

% set input image paths
align_input = t1_img;
write_input = [input_scans; mean_epi; t1_img];

% set batch
matlabbatch{1}.spm.spatial.normalise.estwrite.subj.vol      = align_input;
matlabbatch{1}.spm.spatial.normalise.estwrite.subj.resample = write_input;
matlabbatch{1}.spm.spatial.normalise.estwrite.eoptions.biasreg  = 0.0001;
matlabbatch{1}.spm.spatial.normalise.estwrite.eoptions.biasfwhm = 60;
matlabbatch{1}.spm.spatial.normalise.estwrite.eoptions.tpm      = {fullfile(fileparts(which('spm')), 'tpm/TPM.nii')};
matlabbatch{1}.spm.spatial.normalise.estwrite.eoptions.affreg   = 'mni';
matlabbatch{1}.spm.spatial.normalise.estwrite.eoptions.reg      = [0 0.001 0.5 0.05 0.2];
matlabbatch{1}.spm.spatial.normalise.estwrite.eoptions.fwhm     = 0;
matlabbatch{1}.spm.spatial.normalise.estwrite.eoptions.samp     = 3;
matlabbatch{1}.spm.spatial.normalise.estwrite.woptions.bb = [-78 -112 -70
                                                             78 76 85];
matlabbatch{1}.spm.spatial.normalise.estwrite.woptions.vox = [2 2 2];
matlabbatch{1}.spm.spatial.normalise.estwrite.woptions.interp = 4;
matlabbatch{1}.spm.spatial.normalise.estwrite.woptions.prefix = 'w';

% run spm batch
spm_jobman('run', matlabbatch);

end