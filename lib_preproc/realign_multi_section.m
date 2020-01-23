%-----------------------------------------------------------------------
% requirements = { SPM12 }
% author = { Yoshiharu Ikutani }
%-----------------------------------------------------------------------

function ret = realign_multi_section(subj_preproc_dir)

% set param
refRun  = 4; % index of functional RUN using as reference
subj_preproc_run_dir = grep_files(subj_preproc_dir, 'run-.*', 1);

% init
clear matlabbatch;
spm('Defaults','fMRI');
spm_jobman('initcfg');

% reorder
tmp = subj_preproc_run_dir{1};
subj_preproc_run_dir{1} = subj_preproc_run_dir{refRun};
subj_preproc_run_dir{refRun} = tmp;

% prepare input_scans
input_scans = cell(length(subj_preproc_run_dir),1);
for ii = 1:length(subj_preproc_run_dir)
    tmp = grep_files(subj_preproc_run_dir{ii}, '^sub-.*.nii', 1);
    input_scans{ii} = strcat(tmp, ',1');
end%ii

% set realign est & res
matlabbatch{1}.spm.spatial.realign.estwrite.data = input_scans; % input nii files
matlabbatch{1}.spm.spatial.realign.estwrite.eoptions.quality = 0.9;
matlabbatch{1}.spm.spatial.realign.estwrite.eoptions.sep = 4;
matlabbatch{1}.spm.spatial.realign.estwrite.eoptions.fwhm = 5;
matlabbatch{1}.spm.spatial.realign.estwrite.eoptions.rtm = 1;
matlabbatch{1}.spm.spatial.realign.estwrite.eoptions.interp = 2;
matlabbatch{1}.spm.spatial.realign.estwrite.eoptions.wrap = [0 0 0];
matlabbatch{1}.spm.spatial.realign.estwrite.eoptions.weight = '';
matlabbatch{1}.spm.spatial.realign.estwrite.roptions.which = [2 1];
matlabbatch{1}.spm.spatial.realign.estwrite.roptions.interp = 4;
matlabbatch{1}.spm.spatial.realign.estwrite.roptions.wrap = [0 0 0];
matlabbatch{1}.spm.spatial.realign.estwrite.roptions.mask = 1;
matlabbatch{1}.spm.spatial.realign.estwrite.roptions.prefix = 'r_';

% run spm batch
spm_jobman('run', matlabbatch);

% move spm_.*.ps file
ps_file = dir([pwd '/spm*.ps']);
if ~isempty(ps_file); movefile(fullfile(pwd, ps_file.name), fullfile(subj_preproc_dir, 'spm_realine.ps')); end

end%function