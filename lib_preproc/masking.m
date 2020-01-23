%-----------------------------------------------------------------------
% requirements = { SPM12 }
% requirements = { SPM Masking Toolbox (http://www0.cs.ucl.ac.uk/staff/g.ridgway/masking/) }
% author = { Yoshiharu Ikutani }
%-----------------------------------------------------------------------

function ret = masking(subj_dir, mask_output_dir)

% Initialise SPM
clear matlabbatch;
spm('Defaults','fMRI');
spm_jobman('initcfg');

% set input scans
input_scans = [];
for subj_index = 1:length(subj_dir)
    tmp = grep_files(fullfile(subj_dir{subj_index}, 'preproc/anat/'), '^c1.*.nii', 1);
    input_scans = [input_scans; strcat(tmp{1}, ',1')];
end%subj_index

%
matlabbatch{1}.spm.tools.masking{1}.makeavg.innames = cellstr(input_scans);
matlabbatch{1}.spm.tools.masking{1}.makeavg.avgexpr = 'mean(X)';
matlabbatch{1}.spm.tools.masking{1}.makeavg.outname = 'average_GM.nii';
matlabbatch{1}.spm.tools.masking{1}.makeavg.outdir  = {mask_output_dir};
matlabbatch{2}.spm.tools.masking{1}.optthr.inname(1) = cfg_dep('Make Average: Average Image', substruct('.','val', '{}',{1}, '.','val', '{}',{1}, '.','val', '{}',{1}, '.','val', '{}',{1}), substruct('.','files'));
matlabbatch{2}.spm.tools.masking{1}.optthr.optfunc  = '@opt_thr_corr';
matlabbatch{2}.spm.tools.masking{1}.optthr.outname  = 'average_GM_optthr.nii';
matlabbatch{2}.spm.tools.masking{1}.optthr.outdir   = {mask_output_dir};
matlabbatch{3}.spm.util.checkreg.data(1) = cfg_dep('Make Average: Average Image', substruct('.','val', '{}',{1}, '.','val', '{}',{1}, '.','val', '{}',{1}, '.','val', '{}',{1}), substruct('.','files'));
matlabbatch{3}.spm.util.checkreg.data(2) = cfg_dep('Optimal Thresholding: Mask Image', substruct('.','val', '{}',{2}, '.','val', '{}',{1}, '.','val', '{}',{1}, '.','val', '{}',{1}), substruct('.','outname'));

% run spm batch
spm_jobman('run', matlabbatch);

end