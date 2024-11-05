package tech.cybersword;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        String fileName = "root_" + new java.text.SimpleDateFormat("yyyyMMdd_HHmmsss").format(new java.util.Date()) + ".svg";

        String problem = "You need to know how many cores exists on CPU?";
        String solution = "Use -> nproc or nproc --all";

        String fontSize = "30";

        String font = "Courier New";
        String transparentGreen = "rgba(0, 255, 0, 0.25)";
        String transparentGreen2 = "rgba(0, 255, 0, 0.1)";
        String transparentRed = "rgba(255, 0, 0, 0.25)";
        String strokeWidth = "1";

        String https = "🌐 https://cybersword.tech";
        String linkeid = "🔗 www.linkedin.com/in/cybersword-tech";
        String instagram = "📷 ph1sher";
        String x_twitter = "✖️ @davidwowa";

        StringBuilder svgContent = new StringBuilder();
        svgContent.append("<svg width=\"1080\" height=\"1080\" xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\">\n");
        svgContent.append("  <!-- Hintergrund -->\n");
        svgContent.append("  <rect width=\"100%\" height=\"100%\" fill=\"black\"/>\n");
        
        svgContent.append("  <!-- Grüner Rahmen -->\n");
        svgContent.append("  <rect x=\"5\" y=\"5\" width=\"1060\" height=\"1060\" stroke=\"lime\" stroke-width=\""+strokeWidth+"\" fill=\"none\"/>\n");
        
        svgContent.append("  <!-- Zufällige Nullen und Einsen über das Bild verteilt, innerhalb des Rahmens -->\n");
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            int x = 20 + random.nextInt(1030);
            int y = 30 + random.nextInt(1030);
            int value = random.nextInt(2);
            svgContent.append(String.format("  <text x=\"%d\" y=\"%d\" fill=\"#006400\" font-family=\"%s\" font-size=\"18\" text-anchor=\"start\" letter-spacing=\"2\">%d</text>\n", x, y, font, value));
        }
        
        svgContent.append("  <!-- Platzhalter für Problem - Rahmen -->\n");
        svgContent.append("  <rect x=\"10\" y=\"10\" width=\"97.5%\" height=\"45%\" stroke=\"lime\" stroke-width=\""+strokeWidth+"\" fill=\""+transparentRed+"\"/>\n");
        svgContent.append("  <text x=\"10\" y=\"30\" fill=\"lime\" font-family=\""+font+"\" font-size=\"30\" text-anchor=\"start\">Problem:</text>\n");

        svgContent.append("  <text x=\"500\" y=\"350\" fill=\"lime\" font-family=\""+font+"\" font-size=\""+fontSize+"\" text-anchor=\"middle\" font-weight=\"bold\" style=\"textLength: 980; lengthAdjust: spacingAndGlyphs;\">"+problem+"</text>\n");
        
        svgContent.append("  <!-- Platzhalter für Solution -->\n");
        svgContent.append("  <rect x=\"10\" y=\"501\" width=\"97.5%\" height=\"45%\" stroke=\"lime\" stroke-width=\""+strokeWidth+"\" fill=\""+transparentGreen+"\"/>\n");
        svgContent.append("  <text x=\"10\" y=\"521\" fill=\"lime\" font-family=\""+font+"\" font-size=\"30\" text-anchor=\"start\">Solution:</text>\n");

        svgContent.append("  <text x=\"500\" y=\"841\" fill=\"lime\" font-family=\""+font+"\" font-size=\""+fontSize+"\" text-anchor=\"middle\" font-weight=\"bold\" style=\"textLength: 980; lengthAdjust: spacingAndGlyphs;\">"+solution+"</text>\n");

        // svgContent.append("  <!-- Rechteck für weiteres SVG auf der rechten Seite -->\n");
        // svgContent.append("  <rect x=\"823\" y=\"10\" width=\"22%\" height=\"97.3%\" stroke=\"lime\" stroke-width=\""+strokeWidth+"\" fill=\""+transparentGreen+"\"/>\n");
        // svgContent.append("  <text x=\"920\" y=\"250\" fill=\"lime\" font-family=\""+font+"\" font-size=\"20\" text-anchor=\"start\">Embed SVG here</text>\n");

         // Einfügen einer weiteren SVG-Datei in das Rechteck auf der rechten Seite
        //  try (BufferedReader reader = new BufferedReader(new FileReader("CS_v.svg"))) {
        //     String line;
        //     svgContent.append("  <g transform=\"translate(900, 50) scale(0.14)\" fill=\""+transparentGreen+"\">\n");
        //     while ((line = reader.readLine()) != null) {
        //         // Überspringen der XML-Deklaration
        //         if (line.trim().startsWith("<?xml")) {
        //             continue;
        //         }
        //         svgContent.append("    ").append(line).append("\n");
        //     }
        //     svgContent.append("  </g>\n");
        // } catch (IOException e) {
        //     System.err.println("Fehler beim Lesen der eingebetteten SVG-Datei: " + e.getMessage());
        // }

        svgContent.append("  <!-- Rechteck für weiteres SVG unten -->\n");
        svgContent.append("  <rect x=\"10\" y=\"990\" width=\"97.5%\" height=\"6.5%\" stroke=\"lime\" stroke-width=\""+strokeWidth+"\" fill=\""+transparentGreen2+"\"/>\n");
        svgContent.append("  <text x=\"20\" y=\"1020\" fill=\"lime\" font-family=\""+font+"\" font-size=\"20\" font-weight=\"bold\" text-anchor=\"start\">"+https+"</text>\n");
        svgContent.append("  <text x=\"20\" y=\"1040\" fill=\"lime\" font-family=\""+font+"\" font-size=\"20\" font-weight=\"bold\" text-anchor=\"start\">"+instagram+"</text>\n");
        svgContent.append("  <text x=\"505\" y=\"1020\" fill=\"lime\" font-family=\""+font+"\" font-size=\"20\" font-weight=\"bold\" text-anchor=\"start\">"+x_twitter+"</text>\n");
        svgContent.append("  <text x=\"505\" y=\"1040\" fill=\"lime\" font-family=\""+font+"\" font-size=\"20\" font-weight=\"bold\" text-anchor=\"start\">"+linkeid+"</text>\n");
        svgContent.append("</svg>\n");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(svgContent.toString());
            System.out.println("SVG-Datei erfolgreich erstellt: " + fileName);
        } catch (IOException e) {
            System.err.println("Fehler beim Schreiben der SVG-Datei: " + e.getMessage());
        }
    }
}
