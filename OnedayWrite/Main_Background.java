import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;

import com.thehowtotutorial.splashscreen.JSplash;

public class Main_Background {

	public static void main(String[] args) {

		//사용할 색상 미리 정의
		Color mushroom = new Color(255,220,217);
		Color elephant = new Color(143, 134, 129);
		Color thatch = new Color(166, 127, 120);
		Color gunmetal = new Color(50, 67, 95);
		Color mc = mushroom;
		Color sc = thatch;

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				//스플래쉬
				JSplash splash = new JSplash(Main_Background.class.getResource("javatitle.png"),
						true, true, false, "Version 1.0", null, Color.BLACK, Color.BLACK);

				Thread t = new Thread(new Runnable() {
					@Override
					public void run() {
						splash.splashOn();
						splash.setProgress(0, "Loading Start");
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						splash.setProgress(20, "Loading 20%");
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						splash.setProgress(40,"Loading 40%");
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						splash.setProgress(60,"Loading 60%");
						try {
							Thread.sleep(300);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						splash.setProgress(80,"Starting Java Program");
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						splash.splashOff();

						//프레임
						JFrame frame = new JFrame();
						frame.setTitle("하루 글");
						frame.setLocation(200, 100);
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.setPreferredSize(new Dimension(1500,750));
						frame.setBackground(mc); //배경색은 mc변수 사용

						//frame에 붙이는 데 BoxLayout-Horizontal 사용
						Box boxh = Box.createHorizontalBox();
						boxh.add(new Cal()); //가로로 달력 붙임

						//1, 2개 메뉴(To do List는 기본 고정, 일정과 Q&A는 Cardlayout으로 관리)
						try {
							//첫번째 메뉴
							
							Menu panel1 = new Menu();
							JPanel firstCards = panel1.firstCards;
							panel1.setPreferredSize(new Dimension(500, 250));
							panel1.setBounds(100, 100, 450, 300);
							firstCards.setBorder(new EmptyBorder(0, 0, 0, 0));
							firstCards.setLayout(new CardLayout(0, 0));
							panel1.add(firstCards);
							menu_s1 menu_s1 = new menu_s1(panel1);
							menu_s2 menu_s2 = new menu_s2(panel1);
							menu_2_1 menu2_1 = new menu_2_1(panel1);
							menu_2_2 menu2_2 = new menu_2_2(panel1);

							panel1.revalidate();
							panel1.repaint();
							
							firstCards.add(menu_s1, "menu_s1");
							firstCards.add(menu_s2, "menu_s2");
							panel1.firstCards.add(menu2_1, "menu2_1");
							panel1.firstCards.add(menu2_2, "menu2_2");

							firstmenubar fmenubar = new firstmenubar(panel1);
							//첫 번째 메뉴바 끝
							
							//두번째, 세번째 메뉴
							Menu panel2 = new Menu();
							JPanel Cards = panel2.Cards;
							panel2.setPreferredSize(new Dimension(500, 250));
							panel2.setBounds(100, 100, 450, 300);
							Cards.setBorder(new EmptyBorder(0, 0, 0, 0));
							Cards.setLayout(new CardLayout(0, 0));
							panel2.add(Cards);
							menu_3_1 menu3_1 = new menu_3_1(panel2);
							menu_3_2 menu3_2 = new menu_3_2(panel2);
							menu_4_1 menu4_1 = new menu_4_1(panel2);
							menu_4_2 menu4_2 = new menu_4_2(panel2);
							
							panel2.Cards.add(menu3_1, "menu3_1");
							panel2.Cards.add(menu3_2, "menu3_2");
							panel2.Cards.add(menu4_1, "menu4_1");
							panel2.Cards.add(menu4_2, "menu4_2");

							menubar menubar = new menubar(panel2);
							//두, 세번째 메뉴바 끝

							Box boxv = Box.createVerticalBox();
							boxv.add(fmenubar);
							boxv.add(panel1);
							boxv.add(Box.createVerticalStrut(10));
							boxv.add(menubar);
							boxv.add(panel2);
							
						    JPanel jj = new JPanel();
						    jj.add(boxv);
						    
						    boxh.add(jj);
						    
						    frame.add(boxh);
						} catch (Exception e) {
							e.printStackTrace();
						}
						
					    frame.add(boxh);
						//frame.setContentPane(Cards);
						frame.pack();
						frame.setVisible(true);
						
						

			}
		});
		t.start();

	}
});
}

}