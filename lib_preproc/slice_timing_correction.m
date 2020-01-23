%-----------------------------------------------------------------------
% requirements = { SPM12 }
% author = { Yoshiharu Ikutani }
%-----------------------------------------------------------------------

function ret = slice_timing_correction(subj_preproc_dir)

% set parameter
TR = 2; % Hard coding of 'RepetitionTime' in 'sub-*_task-ProgramCategorization_run-*_bold.json'
subj_preproc_run_dir = grep_files(subj_preproc_dir, 'run-.*', 1);

for ii = 1:length(subj_preproc_run_dir)
    
    % set param
    input_scans = strcat(grep_files(subj_preproc_run_dir{ii}, 'r_sub.*.nii', 1), ',1');
    vol_sample  = spm_read_vols(spm_vol(input_scans{1}));
    num_slices  = size(vol_sample, 3);
    slice_order = [1:1:num_slices];
    ref_slice   = floor(num_slices/2);
    % disp(strcat('num_slice: ', num2str(num_slices)))
    
    % Initialise SPM
    clear matlabbatch;
    spm('Defaults','fMRI');
    spm_jobman('initcfg');
    
    % input nii files
    matlabbatch{1}.spm.temporal.st.scans = {input_scans};
    
    % set spm parameters
    matlabbatch{1}.spm.temporal.st.nslices = num_slices;
    matlabbatch{1}.spm.temporal.st.tr = TR;
    matlabbatch{1}.spm.temporal.st.ta = TR - TR/num_slices;
    matlabbatch{1}.spm.temporal.st.so = slice_order;
    matlabbatch{1}.spm.temporal.st.refslice = ref_slice;
    matlabbatch{1}.spm.temporal.st.prefix = 'a';
    
    % run spm batch
    spm_jobman('run', matlabbatch);
    
end

end