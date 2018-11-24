import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;

class StyledButtonUI extends BasicButtonUI {

    @Override
    public void installUI (JComponent c) {
        super.installUI(c);
        AbstractButton button = (AbstractButton) c;
        button.setOpaque(false);
        button.setBorder(new EmptyBorder(5, 15, 5, 15));
        button.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
        button.setPreferredSize(new Dimension(150, 40));
    }

    @Override
    public void paint (Graphics g, JComponent c) {
        AbstractButton b = (AbstractButton) c;
        paintBackground(g, b, b.getModel().isPressed() ? 2 : 0);
        super.paint(g, c);
    }

    private void paintBackground (Graphics g, JComponent c, int yOffset) {
        Dimension size = c.getSize();
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(c.getBackground().darker());
        //System.out.println(size.width);
        g.fillRect(0, yOffset, size.width, size.height - yOffset);
        g.setColor(c.getBackground());
        g.fillRect(0, yOffset, size.width, size.height - yOffset-5);
    }
}

class StyledButtonUI_small extends BasicButtonUI {

    @Override
    public void installUI (JComponent c) {
        super.installUI(c);
        AbstractButton button = (AbstractButton) c;
        button.setOpaque(false);
        button.setBorder(new EmptyBorder(5, 15, 5, 15));
        button.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
        button.setVerticalAlignment(SwingConstants.TOP);
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setPreferredSize(new Dimension(150, 70));
    }

    @Override
    public void paint (Graphics g, JComponent c) {
        AbstractButton b = (AbstractButton) c;
        paintBackground(g, b, b.getModel().isPressed() ? 2 : 0);
        super.paint(g, c);
    }

    private void paintBackground (Graphics g, JComponent c, int yOffset) {
        Dimension size = c.getSize();
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(c.getBackground().darker());
        //System.out.println(size.width);
        g.fillRect(0, yOffset, size.width, size.height - yOffset);
        g.setColor(c.getBackground());
        g.fillRect(0, yOffset, size.width, size.height - yOffset-5);
    }
}

class StyledButtonUI_menu extends BasicButtonUI {

    @Override
    public void installUI (JComponent c) {
        super.installUI(c);
        AbstractButton button = (AbstractButton) c;
        button.setOpaque(false);
        button.setBorder(new EmptyBorder(5, 15, 5, 15));
        button.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setPreferredSize(new Dimension(120, 50));
    }

    @Override
    public void paint (Graphics g, JComponent c) {
        AbstractButton b = (AbstractButton) c;
        paintBackground(g, b, b.getModel().isPressed() ? 2 : 0);
        super.paint(g, c);
    }

    private void paintBackground (Graphics g, JComponent c, int yOffset) {
        Dimension size = c.getSize();
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(c.getBackground().darker());
        //System.out.println(size.width);
        g.fillRect(0, yOffset, size.width, size.height - yOffset);
        g.setColor(c.getBackground());
        g.fillRect(0, yOffset, size.width, size.height - yOffset-5);
    }
}

class StyledButtonUI_etc extends BasicButtonUI {

    @Override
    public void installUI (JComponent c) {
        super.installUI(c);
        AbstractButton button = (AbstractButton) c;
        button.setOpaque(false);
        button.setBorder(new EmptyBorder(5, 15, 5, 15));
        button.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setPreferredSize(new Dimension(90, 40));
    }

    @Override
    public void paint (Graphics g, JComponent c) {
        AbstractButton b = (AbstractButton) c;
        paintBackground(g, b, b.getModel().isPressed() ? 2 : 0);
        super.paint(g, c);
    }

    private void paintBackground (Graphics g, JComponent c, int yOffset) {
        Dimension size = c.getSize();
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(c.getBackground().darker());
        //System.out.println(size.width);
        g.fillRect(0, yOffset, size.width, size.height - yOffset);
        g.setColor(c.getBackground());
        g.fillRect(0, yOffset, size.width, size.height - yOffset-5);
    }
}

public class Cal_Button {
	public static void main (String[] args) {
		//½ÃÇè¿ë
	    /*JFrame f = new JFrame("Button UI Test");
	    f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    JPanel p = new JPanel();
	    p.setBackground(Color.black);
	    f.setContentPane(p);
	    p.setLayout(new FlowLayout(5, 5, 5));
	    p.setBorder(new EmptyBorder(10, 10, 10, 10));
	
	    for (int i = 1; i <= 5; i++) {
	        final JButton button = new JButton("Button #" + i);
	        button.setFont(new Font("Calibri", Font.PLAIN, 14));
	        button.setBackground(new Color(0x2dce98));
	        button.setForeground(Color.white);
	        // customize the button with your own look
	        button.setUI(new StyledButtonUI());
	        p.add(button);
	    }
	
	    f.pack();
	    f.setLocation(500, 500);
	    f.setVisible(true);*/
	    
	}
}