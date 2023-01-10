package swing;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SearchText extends JTextField{
    public SearchText(){
        setBorder(new EmptyBorder(5,5,5,5));
        setSelectionColor(new Color(220,204,182));
    }
    
    private final String hint = "Search Here ...";
    
    @Override
    public void paint(Graphics grph){
        super.paint(grph);
        if(getText().length() == 0){
            int h = getHeight();
            ((Graphics2D) grph).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            Insets ins = getInsets();
            FontMetrics fm = grph.getFontMetrics();
            int c0 = getBackground().getRGB();
            int c1 = getForeground().getRGB();
            int m =0xfefefefe;
            int c2 = ((c0 & m) >>> 1) + ((c1 & m) >>> 1);
            grph.setColor(new Color(c2, true));
            grph.drawString(hint, ins.left, h/2 + fm.getAscent()/2 -2);
        }
    }
}
