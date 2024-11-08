
'sudo tlmgr install standalone' but before `sudo tlmgr update --self`  
'sudo tlmgr install fontawesome'
then  
`pdflatex pic.tex`  
check PDF  

`pdf2svg pic.pdf pic.svg`  

# Todo g
`
      % CIA Bild direkt in LaTeX zeichnen
      \node[anchor=center] at (5.4,3.45) {
        \begin{tikzpicture}
            % Dreieck zeichnen
            \draw[thick, fill=red!30, opacity=0.5] (0,2) -- (-1.73,-1) -- (1.73,-1) -- cycle;
            % Beschriftungen
            \node[opacity=0.5] at (0,2.3) {Confidentiality};
            \node[opacity=0.5] at (-2,-1) {Integrity};
            \node[opacity=0.5] at (2,-1) {Availability};
            % CIA in der Mitte
            \node[opacity=0.5] at (0,0) {\huge CIA};
        \end{tikzpicture}
    };
`