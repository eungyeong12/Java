import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Draw_Star extends JFrame {
    public static void main(String[] args) {
        int cx = 125;
        int cy = 125;
        int radius = 100;
        int JF_width = 300, JF_height = 300;
        int loc_x = 300, loc_y = 300;
        Color star_color = Color.red;
        JFrame jf = new JFrame("JFrame_DrawStar");
        JPanel_DrawStar jp_star = new JPanel_DrawStar(cx, cy,
                radius, star_color);
        Border border_jpStar =
                BorderFactory.createTitledBorder("JPanel_DrawStar");
        jp_star.setBorder(border_jpStar);
        jf.add(jp_star);
        jf.setSize(JF_width, JF_height);
        jf.setLocation(loc_x, loc_y);
        jf.setVisible(true);
    }
}
