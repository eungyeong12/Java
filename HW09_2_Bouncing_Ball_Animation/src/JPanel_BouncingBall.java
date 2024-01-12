import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JPanel_BouncingBall extends JPanel implements ActionListener {
    Timer timer = new Timer(5, this); // this as ActionListener
    int ball_diameter, panel_width, panel_height;
    int panel_x_margin, panel_y_margin;
    int border_thickness;
    double ballSpeed = 1.0; // controlled by JSlider (0.0 ~ 10.0)
    Color ball_color = Color.red;
    int pos_x = border_thickness, pos_y = border_thickness;
    int dx = 1, dy = 1;
    JPanel_BouncingBall(int ball_diameter, int fr_width, int fr_height,
                        int border_thickness, int panel_x_margin, int panel_y_margin) {
        this.ball_diameter = ball_diameter;
        this.panel_width = fr_width;
        this.panel_height = fr_height;
        this.panel_x_margin = panel_x_margin;
        this.panel_y_margin = panel_y_margin;
        this.border_thickness = border_thickness;
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);;
        g.setColor(this.ball_color);
        g.fillOval(pos_x, pos_y, ball_diameter, ball_diameter);
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        pos_x += (int)(dx*ballSpeed);
        pos_y += (int)(dy*ballSpeed);
        if (pos_x <= 0 && (dx < 0)) {
            System.out.printf("Ball touched left boundary at (%d, %d), so chainging direction of x\n", pos_x, pos_y);
            pos_x = 0; dx = -dx;
        }
        if (pos_x >= (panel_width - ball_diameter - border_thickness - panel_x_margin) && (dx > 0)) { System.out.printf("Ball touched right boundary at (%d, %d), so chainging direction of x\n", pos_x, pos_y);
            pos_x = panel_width - ball_diameter - border_thickness- panel_x_margin; dx = -dx; }
        if (pos_y <= 0 && (dy < 0)) {
            System.out.printf("Ball touched top boundary at (%d, %d), so chainging direction of y\n", pos_x, pos_y);
            pos_y = 0; dy = -dy;
        }
        if (pos_y >= (panel_height - ball_diameter - border_thickness - panel_y_margin) && (dy > 0)) {
            System.out.printf("Ball touched bottom boundary at (%d, %d), so chainging direction of y\n", pos_x, pos_y);
            pos_y = panel_height - ball_diameter - border_thickness- panel_y_margin; dy = -dy;
        }
        System.out.printf("Ball speed(%5.2f), position(%3d, %3d)\n", ballSpeed, pos_x, pos_y); repaint(); // repaint JPanel
    }
}
