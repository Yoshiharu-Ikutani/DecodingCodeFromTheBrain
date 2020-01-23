%-----------------------------------------------------------------------
% author = { Yoshiharu Ikutani }
%-----------------------------------------------------------------------

function path_files = grep_files(PATH, EXPRESSION, fill)

if ~exist('fill', 'var'); fill = false(1); end
filenames = dir(PATH);
filenames = {filenames.name};
path_files = filenames(cellfun('length', regexp(filenames, EXPRESSION)) > 0)';
if fill; path_files = fullfile(PATH, path_files); end

end%function