import javax.swing.*;
import java.awt.*;

public class Animation_BouncingBall {
    static int ball_diameter = 100;
    static int panel_width = 400;
    static int panel_ball_height = 300;
    static int panel_color_height = 60;
    static int panel_control_height = 60;
    static int panel_y_colorControl = 60;
    static int panel_y_speedControl = 60;
    static int border_thickness = 3;
    static int panel_x_margin = 20;
    static int panel_y_margin = 30;
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setTitle("Bouncing Ball with Speed Control");
        jf.setLayout(new BorderLayout());
        JPanel_BouncingBall jp_bouncingBall = new
                JPanel_BouncingBall(ball_diameter, panel_width, panel_ball_height, border_thickness, panel_x_margin, panel_y_margin);
        jp_bouncingBall.setVisible(true);
        jp_bouncingBall.setBorder(BorderFactory. createMatteBorder(border_thickness, border_thickness, border_thickness, border_thickness, Color.MAGENTA));
        jf.add(jp_bouncingBall, BorderLayout.CENTER);
        JPanel_RadioButton_Color jp_RB_Color = new
                JPanel_RadioButton_Color(jp_bouncingBall);
        jp_RB_Color.setVisible(true);
        jp_RB_Color.setSize(panel_width, panel_color_height);
        jp_RB_Color.setBorder(BorderFactory. createTitledBorder("Color Control"));
        jf.add(jp_RB_Color, BorderLayout.NORTH);
        JSlider_SpeedControl jslider_SpeedControl = new
                JSlider_SpeedControl(jp_bouncingBall, panel_width, panel_control_height, border_thickness);
        jslider_SpeedControl.setBorder(BorderFactory. createTitledBorder("Speed Control"));
        jslider_SpeedControl.setVisible(true);
        jf.add(jslider_SpeedControl, BorderLayout.SOUTH);
        jf.setSize(panel_width+border_thickness, panel_y_colorControl
                + panel_ball_height + panel_y_speedControl);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.getRootPane().setBorder(BorderFactory. createTitledBorder("Animation of Bouncing Ball"));
        jf.getRootPane().setBorder(BorderFactory. createMatteBorder(border_thickness, border_thickness, border_thickness, border_thickness, Color.BLUE));
        jf.setVisible(true);
    }

}
