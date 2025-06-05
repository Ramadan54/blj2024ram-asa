package ch.noseryoung;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class GameIO extends JFrame {
    private final Game game;
    private final int size;
    private final double scale;
    private final GamePanel panel;

    public GameIO(Game game, int size, double scale) {
        this.game = game;
        this.size = size;
        this.scale = scale;

        panel = new GamePanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Sokoban");
        setContentPane(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_LEFT) game.move(-1, 0);
                if (key == KeyEvent.VK_RIGHT) game.move(1, 0);
                if (key == KeyEvent.VK_UP) game.move(0, -1);
                if (key == KeyEvent.VK_DOWN) game.move(0, 1);
                panel.repaint();
            }
        });
    }

    private class GamePanel extends JPanel {
        private final BufferedImage image;

        public GamePanel() {
            int width = (int)(game.getLevel()[0].length * size * scale);
            int height = (int)(game.getLevel().length * size * scale);
            setPreferredSize(new Dimension(width, height));
            image = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int[][] level = game.getLevel();
            Graphics2D g2d = image.createGraphics();

            for (int y = 0; y < level.length; y++) {
                for (int x = 0; x < level[y].length; x++) {
                    drawTile(g2d, level[y][x]);
                    g.drawImage(image, (int)(x * size * scale), (int)(y * size * scale),
                            (int)(size * scale), (int)(size * scale), null);

                    if (x == game.getPlayerX() && y == game.getPlayerY()) {
                        drawTile(g2d, 6);
                        g.drawImage(image, (int)(x * size * scale), (int)(y * size * scale),
                                (int)(size * scale), (int)(size * scale), null);
                    }
                }
            }
        }

        private void drawTile(Graphics2D g, int tile) {
            Color color;
            switch (tile) {
                case 0: color = Color.LIGHT_GRAY; break;
                case 1: color = Color.DARK_GRAY; break;
                case 2: color = new Color(205, 133, 63); break;
                case 3: color = new Color(160, 82, 45); break;
                case 4: color = Color.PINK; break;
                case 5: color = Color.RED; break;
                case 6: color = Color.BLUE; break;
                default: color = Color.BLACK; break;
            }
            g.setColor(color);
            g.fillRect(0, 0, size, size);
        }
    }
}
