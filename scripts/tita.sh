# !/bin/bash
# tita command line tool 

case "$1" in

"unisci")  
	TEMPIFS=$IFS
	IFS=$'\n'
	for file in $(ls); do mv "$file" "${file// /_}"; done
	IFS=$TEMPIFS
	str=$(ls | while read -r line; do echo "$line + "; done | tr "\n" " ")
	mkvmerge -o output.webm -w ${str:0:-4}
    ;;
"notebook")
	docker run -p 8888:8888 -v ~/notebook:/home/jovyan/work jupyter/scipy-notebook
	;;
"test")
	echo $(ls)
	;;
*) echo "Tita not Aprrove your behaviour"
   ;;
esac
