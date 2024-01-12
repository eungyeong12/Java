import javax.swing.*;
import java.awt.*;

public class JPanel_Circle extends JPanel {
    int panel_width;
    int panel_height;
    int radius;
    Color color;
    public JPanel_Circle(int panel_width, int panel_height, int radius, Color color) {
        this.panel_width = panel_width;
        this.panel_height = panel_height;
        this.radius = radius;
        this.color = color;
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(color);
        g2.setStroke(new BasicStroke(5));
        g2.drawOval(30, 30, radius*2, radius*2);
    }
}
