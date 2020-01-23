# Decoding Functional Categories Of Source Code From The Brain

This repository contains MATLAB code used for preprocessing and decoding analyses in our paper: xxxx. The paper demonstrated that functional categories of source code could be decoded from programmers' brain activity and the decoding accuracies were significantly correlated with individual programming expertise quantified as behavioral performances on source-code categorization.

## Data (fMRI data and subject information)

The dataset including fMRI scans, subject information, and experimental stimuli is available at OpenNeuro ([link](https://openneuro.org/)).
The downloaded dataset should be placed in the root of this repository. The entire directory structure should be same as following:

```
repository_root
│
├── ds002411 ( The dataset downloaded from OpenNeuro )
│   ├── stimuli
│   ├── sub-01
│   ├── sub-02
│   ...
│   ├── sub-29
│   └── [And other 'json' and 'tsv' files]
│
├── README.md
├── lib_* (decoding, preproc, util, secondLevel)
├── run_preprocessing.m
├── run_searchllight_analysis.m
├── run_second_level_analysis.m
├── run_second_level_analysis_subcategory.m
└── set_path_of_root_directory.m
```

## Requirements

You need to install the softwares below and set internal paths correctly.

* SPM12 ([link](https://www.fil.ion.ucl.ac.uk/spm/software/spm12/))
* SPM Masking Toolbox ([link](http://www0.cs.ucl.ac.uk/staff/g.ridgway/masking/))
* The Decoding Toolbox ([link](https://sites.google.com/site/tdtdecodingtoolbox/))

## Getting started

### 0. Check all requirements are satisfied

Please type the following commands in your MATLAB environment. You are ready if you get formal help documents from them.

```
>> help spm
>> help masking_batch
>> help decoding
```

### 1. Download the full or partial dataset

Before starting the analysis, you need to download at least one subject data (e.g. 'sub-01') and put them on the repository root.
When I say **'repository root'**, it means where this repository is in your enviroment. For example, it may be like '/Users/User1/Documents/Github/DecodingCodeFromTheBrain'.

### 2. Set the path to the repository root

Open **'set_path_of_root_directory.m'** and write your path to the repository root in **'root_dir'** variable.

### 3. Run preprocessing procedure

Open **'run_preprocessing.m'** and run all lines of the script. It perform every preprocessing steps including realignment, slice timing correction, coregister, normalization, and segmentation. After all preprocessings were done, it will automatically conduct beta map estimations for all task trials and output the results in **'/ds002411/sub-*/preproc/beta/'**.

WARNING: this would generate additional 3GB+ data for each subject. Be careful on the memory capacity of your computational environment.

### 4. Decode functional categories of source code from the brain

Open **'run_searchllight_analysis.m'** and run all lines of the script. The script will perform decoding analysis on **single subject data**. 
The results will be saved in **'/ds002411/results/searchlight_radius_4_category/'** and **'/ds002411/results/searchlight_radius_4_subcategory/'**.
If you want to perform decoding on every subject data, please check **'run_searchllight_analysis_for_all_subjects.m'** and run all lines.

### 5. Run second-level analyses

If you complete performing 12 or more subject decoding analyses, you can check your decoding results are significant or not by second-level analysis.
Open **'run_second_level_analysis.m'** and run all lines of the script. This script will perform two t-tests below:

```
[1] t-test to examine 'where we could decode the functional categories of source code from brain activities'
[2] t-test to investigate a linear correlation between behavioral performances and decoding accuracies for each searchlight location.
```

The results will be saved in **'/ds002411/results/sl_rad4_category/'**. You then need to check the result using SPM12 -> Results. After SPM12 windows apper, please select SPM12 -> Results and specify 'SPM.mat' file in **'/ds002411/results/sl_rad4_category/all_than_chance'** or **'corr_behavior'**.

If you see 'SPM contrast manager', select 't-contrast' and click 'Define new contrast'. Then, please input following parameters for each result.

```
if you selected 'sl_rad4_category/all_than_chance/SPM.mat'
>> name : 'Mean decoding accuracy > chance'
>> type : 't-contrast'
>> contrast : '1' -> 'submit'

if you selected 'sl_rad4_category/corr_behavior/SPM.mat'
>> name : 'positive corr. with behavioral performance'
>> type : 't-contrast'
>> contrast : '0 1' -> 'submit'
```

After parameter settings, please click 'OK' and the results of statistical tests will be shown in the SPM window.

## How to replicate the original paper results

```
(1) Open **'/lib_decoding/searchlight_decoding.m'** and set 'true' in variables named 'enableScaling' and 'enableParameterSearch' on line 10 and 11.
(2) Open **'/lib_decoding/searchlight_decoding_subcategory.m'** and set 'true' in the same-named variables.
(3) Run decoding analyses for every subject using **'run_searchllight_analysis_for_all_subjects.m'**.
(4) Run second-level analysis using **'run_second_level_analysis.m'** and **'run_second_level_analysis.m'**
```

NOTE: the decoding analysis consumes 5+ days for each subject in authors' own computational environment (MacPro 3.5Gz, 6-core Intel Xeon E5).

## Contact

For further information, please contact the corresponding author ( email, takatomi-k@is.naist.jp ).