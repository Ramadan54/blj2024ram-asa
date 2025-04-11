import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CSRenderer extends JPanel {

  private CoordinateSystem cs;
  private JFrame mainFrame;

  private int size;
  private int fieldScale;
  private int pointSize;

  private final int OFFSET_MID;
  private final int OFFSET_END;

  public CSRenderer(CoordinateSystem cs, int fieldScale, int pointSize) {
    this.cs = cs;
    this.size = cs.getCoordinateSystemSize() * fieldScale;
    this.fieldScale = fieldScale;
    this.pointSize = pointSize;

    OFFSET_MID = (size + fieldScale) / 2;
    OFFSET_END = size + (fieldScale / 2);

    this.setPreferredSize(new Dimension(size + fieldScale, size + fieldScale));
    this.setupMouseMotionListener(2);

    mainFrame = new JFrame();
    mainFrame.setResizable(true);
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    mainFrame.add(this);
    mainFrame.pack();
    mainFrame.setLocationRelativeTo(null);

    mainFrame.setVisible(true);
  }
  public CSRenderer(CoordinateSystem cs) {
    this(cs, 1, 3);
  }
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setStroke(new BasicStroke(fieldScale));

    for (int i = (fieldScale / 2); i <= OFFSET_END; i += (10 * fieldScale)) {
      g2d.setColor(Color.LIGHT_GRAY);
      g2d.drawLine(i, 0, i, OFFSET_END);
      g2d.drawLine(0, i, OFFSET_END, i);

      g2d.setColor(Color.BLACK);
      g2d.drawLine(i, -5 * fieldScale + OFFSET_MID, i, 5 * fieldScale + OFFSET_MID);
      g2d.drawLine(-5 * fieldScale + OFFSET_MID, i, 5 * fieldScale + OFFSET_MID, i);
    }
    g2d.drawLine(OFFSET_MID, 0, OFFSET_MID, OFFSET_END);
    g2d.drawLine(0, OFFSET_MID, OFFSET_END, OFFSET_MID);

    g2d.setColor(Color.RED);
    g2d.drawLine(OFFSET_MID, OFFSET_MID, OFFSET_MID, OFFSET_MID);

    for (DrawableShape shape : cs.getAllShapes()) {
      shape.draw(g2d, fieldScale, pointSize, size);
    }
  }
  private void setupMouseMotionListener(int leeway) {
    int scaledLeeway = leeway + pointSize / 2;
    this.addMouseMotionListener(new MouseAdapter() {
      @Override
      public void mouseMoved(MouseEvent me) {
        for (DrawableShape shape : cs.getAllShapes()) {
          if (shape instanceof CSPoint point) {
            int px = point.x * fieldScale + size / 2;
            int py = size / 2 - point.y * fieldScale;

            if ((me.getX() >= px - scaledLeeway && me.getX() <= px + scaledLeeway)
                    && (me.getY() >= py - scaledLeeway && me.getY() <= py + scaledLeeway)) {
              mainFrame.setTitle(point.toString());
            }
          }
        }
      }
    });
  }
}
