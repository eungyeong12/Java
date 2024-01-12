import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class JPanel_RadioButton_Color extends JPanel {
    JRadioButton[] rb_color = new JRadioButton[3];
    JPanel_BouncingBall jp_bouncingBall;
    JPanel_RadioButton_Color(JPanel_BouncingBall jp_bouncingBall) {
        this.jp_bouncingBall = jp_bouncingBall;
        String[] color_str = {"red", "green", "blue"};
        ButtonGroup bgrp_color = new ButtonGroup();
        for (int i = 0; i < rb_color.length; i++) {
            rb_color[i] = new JRadioButton(color_str[i]);
            rb_color[i].addItemListener(new RB_Color_ItemListener());
            bgrp_color.add(rb_color[i]);
            add(rb_color[i]);
        }
        rb_color[0].setSelected(true);
    }

    class RB_Color_ItemListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.DESELECTED)
                return;
            if (rb_color[0].isSelected()) {
                jp_bouncingBall.ball_color = Color.red;
                System.out.printf("BallColor changed to RED\n");
            } else if (rb_color[1].isSelected()) {
                jp_bouncingBall.ball_color = Color.GREEN;
                System.out.printf("BallColor changed to GREEN\n");
            } else if (rb_color[2].isSelected()) {
                jp_bouncingBall.ball_color = Color.BLUE;
                System.out.printf("BallColor changed to BLUE\n");
            }
        }
    }
}
