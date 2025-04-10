import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ASCIIArtConverter {
    private static final String ASCII_SCALE = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\\\|()1{}[]?-_+~<>i!lI;:,\\\"^`'. ";

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Bitte Eingabe- und Ausgabedatei angeben!");
            System.out.println("Beispiel: java ASCIIArtConverter bild.jpg ausgabe.txt");
            System.exit(1);
        }
        String inputPath = args[0];
        String outputPath = args[1];

        BufferedImage originalImage = null;
        try {
            originalImage = ImageIO.read(new File(inputPath));
        } catch (IOException e) {
            System.err.println("Fehler beim Laden des Bildes: " + e.getMessage());
            System.exit(2);
        }
        if (originalImage == null) {
            System.err.println("Konnte das Bild nicht einlesen (null).");
            System.exit(2);
        }
    }
}