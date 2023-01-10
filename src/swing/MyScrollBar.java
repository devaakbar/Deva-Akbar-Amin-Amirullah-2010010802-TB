package swing;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

public class MyScrollBar extends JScrollBar {

    public MyScrollBar() {
        setUI(new ScrollBarUI());
        setPreferredSize(new Dimension(8, 8));
        setForeground(new Color(48, 144, 216));
        setBackground(new Color(30, 30, 30));
    }
}
