#!/bin/bash

topic=$1
copy=$2

current_date=$(date +"%Y%m%d_%H%M%S")

input_file="pic.tex"
output_file="${current_date}_pic_${topic}"

cp $input_file "${output_file}.tex"

pdflatex -jobname=$output_file $input_file

convert -density 300 "${output_file}.pdf" -quality 100 "${output_file}.png"

if [ "$copy" == "true" ]; then
    mkdir -p backup
    cp "${output_file}.pdf" backup/
    cp "${output_file}.pdf" ~/Library/Mobile\ Documents/com~apple~CloudDocs/scm/
fi

rm *.aux *.log
