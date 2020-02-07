## Replicate Figure.2a in the original paper
## Note: results from 'All subjects' will differ
## because one subject was excluded from the published dataset.
## (See the 'DATASET' section of https://openneuro.org/datasets/ds002411 )

# init
WhereThisScriptLocates = "/Where/This/Script/Locates" # <- SET your own path !!!!
setwd(WhereThisScriptLocates)
library(ggplot2) # install.packages("ggplot2")

# read subject data
subj_data    = read.delim("../participants.tsv", sep='\t')
atCoder_rate = subj_data$atCoder_Rate
holder = atCoder_rate != 0

# read behavioral performance data
performance_MRI = NULL
event_files = list.files("../events/01_fmri/", full.names = T)
for (fi in 1:length(event_files)){
  tmp = read.delim(event_files[fi], sep='\t')
  performance_MRI[fi] = sum(tmp$correctness == 'correct') / nrow(tmp)
}
df.all    = data.frame(atCoder_rate, performance_MRI, holder)
df.holder = df.all[df.all$holder,] # only rate holders

# significance check
res.all   = cor.test(df.all$atCoder_rate, df.all$performance_MRI)
res.holder = cor.test(df.holder$atCoder_rate, df.holder$performance_MRI)
sprintf('All subjects: r = %.4f, p = %.6f, n = %d',
        res.all$estimate, res.all$p.value, nrow(df.all))
sprintf('Only rate holders: r = %.4f, p = %.6f, n = %d', 
        res.holder$estimate, res.holder$p.value, nrow(df.holder))

# plot
fig = ggplot(df.all, aes(x = atCoder_rate, y = performance_MRI * 100)) +
  geom_point(aes(fill = holder), size = 5, shape = 21, colour = "black") +
  scale_x_continuous(limits=c(0,3000)) + 
  scale_y_continuous(limits=c(50,100)) +
  scale_fill_manual(values=c("gray", "#4682b4")) +
  stat_smooth(method = "lm", se = F, color = 'black', size= 0.5) +
  theme_bw() +
  theme(legend.position="none")
print(fig)
ggsave(filename = './replicate_fig2a.png', plot = fig)