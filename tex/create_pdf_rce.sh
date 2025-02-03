#!/bin/bash

directory=$1
copy=$2

current_date=$(date +"%Y%m%d_%H%M%S")

if [ -d "$directory" ]; then
    for input_file in "$directory"/*.tex; do
        filename=$(basename -- "$input_file")
        filename="${filename%.*}"
        
        output_file="${directory}/${current_date}_RCE_${filename}"

        cp "$input_file" "${output_file}.tex"

        pdflatex -output-directory="$directory" -jobname="${current_date}_RCE_${filename}" "$input_file"

        convert -density 300 "${output_file}.pdf" -quality 100 "${output_file}.png"

        if [ "$copy" == "true" ]; then
            mkdir -p backup
            cp "${output_file}.pdf" backup/rce/
            cp "${output_file}.png" backup/rce/
            cp "${output_file}.tex" backup/rce/
            cp "${output_file}.pdf" ~/Library/Mobile\ Documents/com~apple~CloudDocs/scm/rce/
            cp "${output_file}.png" ~/Library/Mobile\ Documents/com~apple~CloudDocs/scm/rce/
            cp "${output_file}.tex" ~/Library/Mobile\ Documents/com~apple~CloudDocs/scm/rce/
        fi

        rm "$directory"/*.aux "$directory"/*.log
    done
else
    echo "no such directory"
fi