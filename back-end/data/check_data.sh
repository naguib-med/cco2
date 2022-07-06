awk -F'\t' '{print $14 " " $15}' miningdata.tsv | grep -vn '\$[^$]\+\$'
awk -F'\t' '{print $10}' miningdata.tsv | grep -n '^0$'
