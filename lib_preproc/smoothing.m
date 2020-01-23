%-----------------------------------------------------------------------
% requirements = { SPM12 }
% author = { Yoshiharu Ikutani }
%-----------------------------------------------------------------------

function ret = smoothing(input_scans)

% Initialise SPM
clear matlabbatch;
spm('Defaults','fMRI');
spm_jobman('initcfg');

%
matlabbatch{1}.spm.spatial.smooth.data = input_scans;
matlabbatch{1}.spm.spatial.smooth.fwhm = [6 6 6];
matlabbatch{1}.spm.spatial.smooth.dtype = 0;
matlabbatch{1}.spm.spatial.smooth.im = 0;
matlabbatch{1}.spm.spatial.smooth.prefix = 's_';
% Note:
% "The WB classification accuracy maps of individual subjects were spatially smoothed at 6-mm FWHM"
% From Min Xu et al., Science Advances, 2017;

% run spm batch
spm_jobman('run', matlabbatch);

end