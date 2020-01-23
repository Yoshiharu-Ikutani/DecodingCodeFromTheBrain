%-----------------------------------------------------------------------
% requirements = { SPM12 }
% author = { Yoshiharu Ikutani }
%-----------------------------------------------------------------------

function ret = split_and_clearn(subj_func_dir, subj_preproc_dir)

subj_bold_scan  = grep_files(subj_func_dir{1}, '^sub.*_bold.nii$', 1);
for ii = 1:length(subj_bold_scan)
    
    dist = fullfile(subj_preproc_dir, sprintf('run-%02d', ii));
    spm_file_split(subj_bold_scan{ii});
    movefile(fullfile(subj_func_dir{1}, 'sub*_bold_*.nii'), dist)
    
    scan_in_dummy = grep_files(dist, '^sub.*bold_0000[1-8].nii', 1);
    for fi = 1:length(scan_in_dummy)
        delete(scan_in_dummy{fi});
    end%fi
    
end%ii

end%function