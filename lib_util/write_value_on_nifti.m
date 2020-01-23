%-----------------------------------------------------------------------
% requirements = { SPM12 }
% author = { Yoshiharu Ikutani }
%-----------------------------------------------------------------------
% input : vol           = values which you wanna write
% input : ref_path      = path for reference nifti image
% input : output_path   = path for output image
% ('vol' must have the same dimension as ref nifti image)
function [status] = write_value_on_nifti(vol, ref_path, output_path)

% check
if ~exist(ref_path, 'file')
    disp('ref_path does not exist');
    status = -1; % failed
    return;
end

% write
HeaderInfo          = spm_vol(ref_path);
HeaderInfo.fname    = output_path; 
HeaderInfo.private.dat.fname = HeaderInfo.fname;
HeaderInfo          = rmfield(HeaderInfo, 'pinfo');
spm_write_vol(HeaderInfo, vol);

% check
if exist(output_path, 'file')
    status = 1;  % success
else
    status = -1; % failed
end

end