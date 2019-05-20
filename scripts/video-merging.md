# save and set splitting characters
```bash
TEMPIFS=$IFS
IFS=$'\n'
```
# replace filename spaces with undersocre _
```bash
for file in $(ls $1); do mv "$file" "${file// /_}"; done
# add + for the mkvmerge commang usage 
IFS=$TEMPIFS
str=$(ls | while read -r line; do echo "$line + "; done | tr "\n" " ")
# substring removes the last plus +
mkvmerge -o output.webm -w ${str:0:-4}
```