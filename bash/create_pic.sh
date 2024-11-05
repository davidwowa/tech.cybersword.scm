#!/bin/bash

# Voraussetzungen: ImageMagick muss installiert sein
# Installiere ImageMagick (unter Linux): sudo apt-get install imagemagick

# Bildgröße definieren
WIDTH=1080
HEIGHT=1080

# Farben definieren
COLOR1="#FF6347"  # Rot
COLOR2="#4682B4"  # Blau
COLOR3="#32CD32"  # Grün

# Texte definieren
TEXT1="Teil 1: Einführung"
TEXT2="Teil 2: Hauptinhalt"
TEXT3="Teil 3: Schluss"

# Erstelle ein neues Bild (weiß als Hintergrund)
convert -size ${WIDTH}x${HEIGHT} canvas:white instagram_post.png

# Höhe für jeden Bereich berechnen
SECTION_HEIGHT=$((HEIGHT / 3))

# Erstelle drei Abschnitte mit Farben und Texten
convert instagram_post.png \
    -fill "$COLOR1" -draw "rectangle 0,0 $WIDTH,$SECTION_HEIGHT" \
    -fill "$COLOR2" -draw "rectangle 0,$SECTION_HEIGHT $WIDTH,$((2 * SECTION_HEIGHT))" \
    -fill "$COLOR3" -draw "rectangle 0,$((2 * SECTION_HEIGHT)) $WIDTH,$HEIGHT" \
    -fill white -gravity center -pointsize 60 \
    -draw "text 0,-$((SECTION_HEIGHT + SECTION_HEIGHT / 2)) '$TEXT1'" \
    -draw "text 0,0 '$TEXT2'" \
    -draw "text 0,$((SECTION_HEIGHT + SECTION_HEIGHT / 2)) '$TEXT3'" \
    instagram_post.png

# Optional: Öffne das Bild (je nach System kann der Befehl variieren)
xgd-open instagram_post.png
