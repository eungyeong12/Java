import javax.swing.*;
import java.awt.*;

public class JPanel_Rectangle extends JPanel {
    int panel_width;
    int panel_height;
    int rect_width;
    int rect_length;
    Color color;
    public JPanel_Rectangle(int panel_width, int panel_height, int rect_width, int rect_length, Color color) {
        this.panel_width = panel_width;
        this.panel_height = panel_height;
        this.rect_width = rect_width;
        this.rect_length = rect_length;
        this.color = color;
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(color);
        g2.setStroke(new BasicStroke(5));
        g2.drawRect(40, 55, rect_width, rect_length);
    }
}
