import javax.swing.*;
import java.awt.*;

public class JPanel_Polygon extends JPanel {
    int panel_width;
    int panel_height;
    int radius;
    int num_vert;
    Color color;

    public JPanel_Polygon(int panel_width, int panel_height, int radius, int num_vert, Color color) {
        this.panel_width = panel_width;
        this.panel_height = panel_height;
        this.radius = radius;
        this.num_vert = num_vert;
        this.color = color;
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        double theta_rad = 0;
        final double PI = 3.141592;
        g2.setColor(color);
        g2.setStroke(new BasicStroke(3));
        int px[] = new int[num_vert];
        int py[] = new int[num_vert];
        for(int i=0; i<num_vert; i++) {
            theta_rad = -PI/2.0+i*(2.0*PI)/(double)num_vert;
            px[i] = (int)(140+radius * Math.cos(theta_rad));
            py[i] = (int)(140+radius * Math.sin(theta_rad));
        }
        g2.setStroke(new BasicStroke(5));
        int i = 0;
        g2.drawPolygon(px, py, num_vert);
    }


}
