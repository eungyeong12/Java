import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class JSlider_SpeedControl extends JPanel {
    JSlider jslider_SpeedControl;
    Container contentPane;
    double ballSpeed;
    int fr_width, fr_height;
    int fr_x_margin, fr_y_margin;
    int border_thickness;
    final int JSlider_MAX = 100;
    JPanel_BouncingBall jp_bouncingBall;
    JSlider_SpeedControl(JPanel_BouncingBall jp_bouncingBall,
                         int fr_width, int fr_height, int border_thickness) { // constructor
        this.fr_width = fr_width;
        this.fr_height = fr_height;
//this.fr_x_margin = x_margin;
//this.fr_y_margin = y_margin;
        this.border_thickness = border_thickness;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jslider_SpeedControl = new JSlider(JSlider.HORIZONTAL, 0, JSlider_MAX, 50);
        jslider_SpeedControl.addChangeListener(new ChangeSliderListener());
        add(jslider_SpeedControl);
        this.jp_bouncingBall = jp_bouncingBall;
        this.jp_bouncingBall.ballSpeed =
                (double)jslider_SpeedControl.getValue()
                        * 10.0 / JSlider_MAX;
        setVisible(true);
    }
    private void setDefaultCloseOperation(int exitOnClose) {
// TODO Auto-generated method stub
    }
    class ChangeSliderListener implements ChangeListener {
        public void stateChanged(ChangeEvent e) {
            ballSpeed = (double)jslider_SpeedControl.getValue()
                    * 10.0 / JSlider_MAX;
            jp_bouncingBall.ballSpeed = ballSpeed;
            System.out.printf("BallSpeed changed : %.2f\n", ballSpeed);
        }
    }
}
