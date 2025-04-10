import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.imageio.ImageIO;

public class ASCIIArtConverter {
    private static final String ASCII_SCALE = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\\\|()1{}[]?-_+~<>i!lI;:,\\\"^`'. ";

    public static void main(String[] args) {
        String inputPath = "resources/Unbenannt.jpg";
        String outputPath = "resources/output.txt";

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
        BufferedImage grayImage = new BufferedImage(
                originalImage.getWidth(),
                originalImage.getHeight(),
                BufferedImage.TYPE_BYTE_GRAY
        );
        Graphics2D g2d = grayImage.createGraphics();
        g2d.drawImage(originalImage, 0, 0, null);
        g2d.dispose();

        int width = grayImage.getWidth();
        int height = grayImage.getHeight();
        StringBuilder asciiArt = new StringBuilder();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int brightness = grayImage.getRaster().getSample(x, y, 0);
                int index = Math.round((brightness / 255.0f) * (ASCII_SCALE.length() - 1));
                asciiArt.append(ASCII_SCALE.charAt(index));
            }
            asciiArt.append("\n");
        }
        try (PrintWriter writer = new PrintWriter(new File(outputPath))) {
            writer.print(asciiArt.toString());
        } catch (IOException e) {
            System.err.println("Fehler beim Schreiben der Ausgabedatei: " + e.getMessage());
            System.exit(3);
        }
        System.out.println("ASCII-Art erfolgreich generiert in: " + outputPath);
    }
}