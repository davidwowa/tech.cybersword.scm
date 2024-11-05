#!/bin/bash

topic=$1
copy=$2

current_date=$(date +"%Y%m%d_%H%M%S")

input_file="pic.tex"
output_file="${current_date}_pic_${topic}"

cp $input_file "${output_file}.tex"

pdflatex -jobname=$output_file $input_file

if [ "$copy" == "true" ]; then
    mkdir -p backup
    cp "${output_file}.pdf" backup/
    cp "${output_file}.tex" ~/Library/Mobile\ Documents/com~apple~CloudDocs/scm/
fi

rm *.aux *.log