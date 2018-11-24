import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.MenuBar;
import java.awt.ScrollPane;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.Vector;

import javax.print.attribute.standard.JobHoldUntil;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.sun.xml.internal.messaging.saaj.soap.JpegDataContentHandler;

import sun.swing.SwingAccessor.JTextComponentAccessor;


//�޴��� �� �гη� ������ �����ӿ� ��ġ��(CardLayout)
//ù ��° �޴��� �޴���
class firstmenubar extends JPanel {
	public firstmenubar(Menu panel) {
		setPreferredSize(new Dimension(400, 100));
		Color mushroom = new Color(255,220,217);
		Color elephant = new Color(143, 134, 129);
		Color thatch = new Color(166, 127, 120);
		Color gunmetal = new Color(50, 67, 95);
		
		JButton firstm_1 = new JButton("To do List-A");
		JButton firstm_2 = new JButton("To do List-V");
		JButton m2_1 = new JButton("Schedule-A");
		JButton m2_2 = new JButton("Schedule-V");
		
		firstm_1.setUI(new StyledButtonUI_menu());
		firstm_2.setUI(new StyledButtonUI_menu());
		firstm_1.setBackground(thatch);
		firstm_2.setBackground(thatch);
		
		m2_1.setUI(new StyledButtonUI_menu());
		m2_2.setUI(new StyledButtonUI_menu());
		m2_1.setBackground(thatch);
		m2_2.setBackground(thatch);

		firstm_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout)(panel.firstCards.getLayout());
				cardLayout.show(panel.firstCards,"menu_s1");
				panel.firstCards.revalidate();
				panel.firstCards.repaint();
			}
		});
		firstm_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout)(panel.firstCards.getLayout());
				cardLayout.show(panel.firstCards,"menu_s2");
				panel.firstCards.revalidate();
				panel.firstCards.repaint();
			}
		});
		
		m2_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout)(panel.firstCards.getLayout());
				cardLayout.show(panel.firstCards,"menu2_1");
				panel.firstCards.revalidate();
				panel.firstCards.repaint();
			}
		});
		
		m2_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout)(panel.firstCards.getLayout());
				cardLayout.show(panel.firstCards,"menu2_2");
				panel.firstCards.revalidate();
				panel.firstCards.repaint();
			}
		});

		JPanel btnjp = new JPanel();
		btnjp.add(firstm_2);
		btnjp.add(firstm_1);
		btnjp.add(m2_2);
		btnjp.add(m2_1);

		//setBackground(mushroom);
		setLayout(new FlowLayout());
		btnjp.setBackground(mushroom);
		add(btnjp);
	}
}

//��, ����° �޴��� �޴���
class menubar extends JPanel {
	public menubar(Menu panel) {
		setPreferredSize(new Dimension(500, 100));
		Color mushroom = new Color(255,220,217);
		Color elephant = new Color(143, 134, 129);
		Color thatch = new Color(166, 127, 120);
		Color gunmetal = new Color(50, 67, 95);

		//JButton m1 = new JButton("To do List");
		
		JButton m3_1 = new JButton("Q & A-A");
		JButton m3_2 = new JButton("Q & A-V");
		JButton m4_1 = new JButton("DIARY-A");
		JButton m4_2 = new JButton("DIARY-V");
		//m1.setUI(new StyledButtonUI_menu());
		m3_1.setUI(new StyledButtonUI_menu());
		m3_2.setUI(new StyledButtonUI_menu());
		m4_1.setUI(new StyledButtonUI_menu());
		m4_2.setUI(new StyledButtonUI_menu());
		//m1.setBackground(elephant);
		m3_1.setBackground(thatch);
		m3_2.setBackground(thatch);
		m4_1.setBackground(thatch);
		m4_2.setBackground(thatch);
		
		m3_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout)(panel.Cards.getLayout());
				cardLayout.show(panel.Cards,"menu3_1");
				panel.Cards.revalidate();
				panel.Cards.repaint();
			}
		});
		
		m3_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout)(panel.Cards.getLayout());
				cardLayout.show(panel.Cards,"menu3_2");
				panel.Cards.revalidate();
				panel.Cards.repaint();
			}
		});
		
		m4_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout)(panel.Cards.getLayout());
				cardLayout.show(panel.Cards,"menu4_1");
				panel.Cards.revalidate();
				panel.Cards.repaint();
			}
		});
		
		m4_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout)(panel.Cards.getLayout());
				cardLayout.show(panel.Cards,"menu4_2");
				panel.Cards.revalidate();
				panel.Cards.repaint();
			}
		});


		JPanel btnjp = new JPanel();
		btnjp.add(m3_2);
		btnjp.add(m3_1);
		btnjp.add(m4_2);
		btnjp.add(m4_1);

		//setBackground(mushroom);
		btnjp.setBackground(mushroom);
		add(btnjp);
	}
}

//ù��° �޴� - Add
class menu_s1 extends JPanel {
	Date d = new Date();

	public menu_s1(Menu panel) {
		setBorder(BorderFactory.createEmptyBorder(10 , 10 , 10 , 10));
		setPreferredSize(new Dimension(500, 275));
		JLabel menu1 = new JLabel("< To do List > ADD");
		menu1.setFont(new Font("���� ���", Font.BOLD, 20));

		Color mushroom = new Color(255,220,217);
		Color elephant = new Color(143, 134, 129);
		Color thatch = new Color(166, 127, 120);
		Color gunmetal = new Color(50, 67, 95);
		//setBackground(mushroom);
		
		GridLayout gridLayout_1 = new GridLayout();
		gridLayout_1.setRows(3);
		gridLayout_1.setColumns(1);
		gridLayout_1.setHgap(20); // �� cell ������ ���� (������ px)
		setLayout(gridLayout_1);

		JTextArea qa = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(qa);
		
		JPanel etcbtn = new JPanel();
		//etcbtn.setBackground(mushroom);
		JButton save = new JButton("SAVE");
		JButton clear = new JButton("CLEAR");
		save.setUI(new StyledButtonUI_etc());
		clear.setUI(new StyledButtonUI_etc());
		save.setBackground(thatch);
		clear.setBackground(thatch);
		etcbtn.add(save);
		etcbtn.add(clear);
		
		add(menu1);
		add(scrollPane);
		add(etcbtn);
		
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("org.sqlite.JDBC");
					Connection connection = DriverManager.getConnection("jdbc:sqlite:OnedayWrite.db");
					
					// �ʿ��� ���ǹ��� connection ��ü�� ���Ͽ� ����
					PreparedStatement ps = connection.prepareStatement("INSERT INTO ToDoList VALUES(?, ?, ?)");
					ps.setString(1, qa.getText());
					SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String ds = f.format(d);
					ps.setString(2, ds);
					f = new SimpleDateFormat("yyyy-MM");
					ds = f.format(d);
					ps.setString(3, ds);
					
					
					int res = ps.executeUpdate();
					if(res == 1) {
						JOptionPane.showMessageDialog(null, "���������� ����Ǿ����ϴ�.", "�� ��", JOptionPane.WARNING_MESSAGE);
					}
					
					ps.close();
					
					connection.close();
				} catch (ClassNotFoundException | SQLException e1) {
					System.out.println("ToDoList �����ͺ��̽� ���� ����" + e1.getMessage());
				}
			}
		});
		
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				qa.setText("");
			}
		});
	}
}
//ù��° �޴� - View
class menu_s2 extends JPanel {
	Date d = new Date();
	
	Color bg = new Color(238, 238, 238);
	String colName[] = {"To Do List", "DATETIME"};
	Object[][] rowDate = new Object[0][2];
	DefaultTableModel model = new DefaultTableModel(rowDate, colName);
	JTable table = new JTable(model);
	JScrollPane jsp = new JScrollPane(table);
	
	JButton update = null;
	JButton delete = null;
	
	int row;
	
	private void select() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:OnedayWrite.db");
			
			// �ʿ��� ���ǹ��� connection ��ü�� ���Ͽ� ����
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM ToDoList where date = ?");
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM");
			String ds = f.format(d);
			ps.setString(1, ds);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String todolist = rs.getString("todolist");
				String date = rs.getString("datetime");
				
				Object data[] = {todolist, date};
				model.addRow(data);
			}
			
			ps.close();
			rs.close();
			
			DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();// DefaultTableCellHeaderRenderer ���� (��� ������ ����)
			tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER); // DefaultTableCellHeaderRenderer�� ������ ��� ���ķ� ����
			
			TableColumnModel tcmSchedule = table.getColumnModel(); // ������ ���̺��� ColumnModel�� ������
			for (int j = 0; j < tcmSchedule.getColumnCount(); j++) { // �ݺ����� �̿��Ͽ� ���̺��� ��� ���ķ� ����
				tcmSchedule.getColumn(j).setCellRenderer(tScheduleCellRenderer);
			}
			
			table.setBackground(bg);
								
			connection.close();
		} catch (ClassNotFoundException | SQLException e1) {
			System.out.println("ToDoList �����ͺ��̽� ���� ����" + e1.getMessage());
		}
	}
	
	public menu_s2(Menu panel) {
		setBorder(BorderFactory.createEmptyBorder(10 , 10 , 10 , 10));
		setPreferredSize(new Dimension(500, 275));
		
		JLabel menu1 = new JLabel("< To do List > VIEW");
		menu1.setFont(new Font("���� ���", Font.BOLD, 20));
		
		Color mushroom = new Color(255,220,217);
		Color elephant = new Color(143, 134, 129);
		Color thatch = new Color(166, 127, 120);
		Color gunmetal = new Color(50, 67, 95);
		Color bg = new Color(238, 238, 238);
		
		add(menu1);
			
		setLayout(new GridLayout(4, 0));
		JPanel btn = new JPanel();
		btn.setLayout(new FlowLayout());
		update = new JButton();
		delete = new JButton();
		
		JTextField Update = new JTextField(40);
		JPanel up = new JPanel();
		up.add(Update);
		
		select();
		
		table.addMouseListener(new MouseListener() {
			   @Override
			   public void mouseReleased(MouseEvent e) {}
			   @Override
			   public void mousePressed(MouseEvent e) {}
			   @Override
			   public void mouseExited(MouseEvent e) {}
			   @Override
			   public void mouseEntered(MouseEvent e) {}
			   
			   @Override
			   public void mouseClicked(MouseEvent e) { //���콺�� ������ ���� ������ ������ �ؽ�Ʈ�ʵ忡 ����ϱ� 
			    row = table.getSelectedRow();
			    
			    Update.setText((String)model.getValueAt(row, 0));
			   }
			   
			  });
		
		update = new JButton();
		update.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand());
				
				//row = table.getSelectedRow();
				if(row<0) return;
								
				String query = "UPDATE ToDoList SET todolist = ?, datetime = ?, date = ? WHERE todolist = ? AND datetime = ?";
				
				try {
					Class.forName("org.sqlite.JDBC");
					Connection connection = DriverManager.getConnection("jdbc:sqlite:OnedayWrite.db");
					
					// �ʿ��� ���ǹ��� connection ��ü�� ���Ͽ� ����
					PreparedStatement ps = connection.prepareStatement(query);
					
					//modelUpdate.fireTableDataChanged();
					ps.setString(1, Update.getText());
					SimpleDateFormat fUpdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String dsUpdate = fUpdate.format(d);
					ps.setString(2, dsUpdate);
					fUpdate = new SimpleDateFormat("yyyy-MM");
					dsUpdate = fUpdate.format(d);
					ps.setString(3, dsUpdate);
					ps.setString(4, (String)model.getValueAt(row, 0));
					ps.setString(5, (String)model.getValueAt(row, 1));
					
					int cnt = ps.executeUpdate();
					
					ps.close();
					connection.close();
				} catch (ClassNotFoundException | SQLException e1) {
					System.out.println("Schedule �����ͺ��̽� ���� ���� " + e1.getMessage());
				}
				model.setRowCount(0);
				select();
				Update.setText("");
			}
		});
		update.setText("UPDATE");
		update.setUI(new StyledButtonUI_etc());
		update.setBackground(thatch);
		btn.add(update);

		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 System.out.println(e.getActionCommand());        // ���õ� ��ư�� �ؽ�Ʈ�� ���
				 
				 //row = table.getSelectedRow();
				 if(row<0) return; // ������ �ȵ� ���¸� -1����
				 
				 String query = "DELETE FROM ToDoList WHERE todolist = ? AND datetime = ?";
				 
				 try{
					 Class.forName("org.sqlite.JDBC");
					 Connection connection = DriverManager.getConnection("jdbc:sqlite:OnedayWrite.db");
					 PreparedStatement ps = connection.prepareStatement(query);
					 
					 ps.setString(1, (String)model.getValueAt(row, 0));
					 //System.out.println((String)model.getValueAt(row, 0));
					 ps.setString(2, (String)model.getValueAt(row, 1));
					 //System.out.println((String)model.getValueAt(row, 1));
					 
					 int cnt = ps.executeUpdate();
					 
					 ps.close();
					 connection.close();
				 } catch (ClassNotFoundException | SQLException e1) {
						System.out.println("Schedule �����ͺ��̽� ���� ���� " + e1.getMessage());
				 }
				 
				 model.removeRow(row);
			}
		});
		delete.setText("DELETE");
		delete.setUI(new StyledButtonUI_etc());
		delete.setBackground(thatch);
		btn.add(delete);
		
		add(jsp);
		add(up);
		add(btn);
	}
	 
}

//�ι�° �޴� - ADD
class menu_2_1 extends JPanel{
	Date d = new Date();
	
	public menu_2_1(Menu panel) {
		setBorder(BorderFactory.createEmptyBorder(10 , 10 , 10 , 10));
		setPreferredSize(new Dimension(500, 275));

		JLabel menu2 = new JLabel("< SCHEDULE > ADD");
		menu2.setFont(new Font("���� ���", Font.BOLD, 20));

		Color mushroom = new Color(255,220,217);
		Color elephant = new Color(143, 134, 129);
		Color thatch = new Color(166, 127, 120);
		Color gunmetal = new Color(50, 67, 95);

		//setBackground(mushroom);

		GridLayout gridLayout_2 = new GridLayout();
		gridLayout_2.setRows(3);
		gridLayout_2.setColumns(1);
		gridLayout_2.setHgap(20); // �� cell ������ ���� (������ px)
		setLayout(gridLayout_2);

		JTextArea qa = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(qa);
		
		JPanel etcbtn = new JPanel();
		//etcbtn.setBackground(mushroom);
		JButton save = new JButton("SAVE");
		JButton clear = new JButton("CLEAR");
		save.setUI(new StyledButtonUI_etc());
		clear.setUI(new StyledButtonUI_etc());
		save.setBackground(thatch);
		clear.setBackground(thatch);
		etcbtn.add(save);
		etcbtn.add(clear);
		
		add(menu2);
		add(qa);
		add(etcbtn);
		
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("org.sqlite.JDBC");
					Connection connection = DriverManager.getConnection("jdbc:sqlite:OnedayWrite.db");
					
					// �ʿ��� ���ǹ��� connection ��ü�� ���Ͽ� ����
					PreparedStatement ps = connection.prepareStatement("INSERT INTO Schedule VALUES(?, ?, ?)");
					ps.setString(1, qa.getText());
					SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String ds = f.format(d);
					ps.setString(2, ds);
					f = new SimpleDateFormat("yyyy-MM-dd");
					ds = f.format(d);
					ps.setString(3, ds);
					
					
					int res = ps.executeUpdate();
					if(res == 1) {
						JOptionPane.showMessageDialog(null, "���������� ����Ǿ����ϴ�.", "�� ��", JOptionPane.WARNING_MESSAGE);
					}
					
					ps.close();
					connection.close();
				} catch (ClassNotFoundException | SQLException e1) {
					System.out.println("Schedule �����ͺ��̽� ���� ����" + e1.getMessage());
				}
			}
		});
		
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				qa.setText("");
			}
		});
		
	}

}
///�ι�° �޴� - VIEW
class menu_2_2 extends JPanel{
	Date d = new Date();
	SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
	String ds = f.format(d);
	
	Color bg = new Color(238, 238, 238);
	String colName[] = {"SCHEDULE", "DATETIME"};
	Object[][] rowDate = new Object[0][2];
	DefaultTableModel model = new DefaultTableModel(rowDate, colName);
	JTable table = new JTable(model);
	JScrollPane jsp = new JScrollPane(table);
	
	JButton update = null;
	JButton delete = null;
	
	int row;
	
	private void select() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:OnedayWrite.db");
			
			// �ʿ��� ���ǹ��� connection ��ü�� ���Ͽ� ����
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM Schedule where date = ?");
			ps.setString(1, ds);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String sche = rs.getString("schedule");
				String date = rs.getString("datetime");
				
				Object data[] = {sche, date};
				model.addRow(data);
			}
						
			ps.close();
			rs.close();
			
			DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();// DefaultTableCellHeaderRenderer ���� (��� ������ ����)
			tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER); // DefaultTableCellHeaderRenderer�� ������ ��� ���ķ� ����
			
			TableColumnModel tcmSchedule = table.getColumnModel(); // ������ ���̺��� ColumnModel�� ������
			for (int j = 0; j < tcmSchedule.getColumnCount(); j++) { // �ݺ����� �̿��Ͽ� ���̺��� ��� ���ķ� ����
				tcmSchedule.getColumn(j).setCellRenderer(tScheduleCellRenderer);
			}
			
			table.setBackground(bg);
								
			connection.close();
		} catch (ClassNotFoundException | SQLException e1) {
			System.out.println("Schedule �����ͺ��̽� ���� ����" + e1.getMessage());
		}
	}
	
	public menu_2_2(Menu panel) {
		setBorder(BorderFactory.createEmptyBorder(10 , 10 , 10 , 10));
		setPreferredSize(new Dimension(500, 275));

		JLabel menu2 = new JLabel("< SCHEDULE > VIEW");
		menu2.setFont(new Font("���� ���", Font.BOLD, 20));

		Color mushroom = new Color(255,220,217);
		Color elephant = new Color(143, 134, 129);
		Color thatch = new Color(166, 127, 120);
		Color gunmetal = new Color(50, 67, 95);
		
		add(menu2);

		setLayout(new GridLayout(4, 0));
		JPanel btn = new JPanel();
		btn.setLayout(new FlowLayout());
		update = new JButton();
		delete = new JButton();
		
		JTextField Update = new JTextField(40);
		JPanel up = new JPanel();
		up.add(Update);
		
		select();
		
		table.addMouseListener(new MouseListener() {
			   @Override
			   public void mouseReleased(MouseEvent e) {}
			   @Override
			   public void mousePressed(MouseEvent e) {}
			   @Override
			   public void mouseExited(MouseEvent e) {}
			   @Override
			   public void mouseEntered(MouseEvent e) {}
			   
			   @Override
			   public void mouseClicked(MouseEvent e) { //���콺�� ������ ���� ������ ������ �ؽ�Ʈ�ʵ忡 ����ϱ� 
			    row = table.getSelectedRow();
			    
			    Update.setText((String)model.getValueAt(row, 0));
			   }
			   
			  });
		
		update = new JButton();
		update.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand());
				
				//row = table.getSelectedRow();
				if(row<0) return;
				
				String query = "UPDATE Schedule SET schedule = ?, datetime = ?, date = ? WHERE schedule = ? AND datetime = ?";
				
				try {
					Class.forName("org.sqlite.JDBC");
					Connection connection = DriverManager.getConnection("jdbc:sqlite:OnedayWrite.db");
					
					// �ʿ��� ���ǹ��� connection ��ü�� ���Ͽ� ����
					PreparedStatement ps = connection.prepareStatement(query);
					
					//modelUpdate.fireTableDataChanged();
					ps.setString(1, Update.getText());
					SimpleDateFormat fUpdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String dsUpdate = fUpdate.format(d);
					ps.setString(2, dsUpdate);
					fUpdate = new SimpleDateFormat("yyyy-MM-dd");
					dsUpdate = fUpdate.format(d);
					ps.setString(3, dsUpdate);
					ps.setString(4, (String)model.getValueAt(row, 0));
					ps.setString(5, (String)model.getValueAt(row, 1));
					
					int cnt = ps.executeUpdate();
					
					ps.close();
					connection.close();
				} catch (ClassNotFoundException | SQLException e1) {
					System.out.println("Schedule �����ͺ��̽� ���� ���� " + e1.getMessage());
				}
				model.setRowCount(0);
				select();
				Update.setText("");
			}
		});
		update.setText("UPDATE");
		update.setUI(new StyledButtonUI_etc());
		update.setBackground(thatch);
		btn.add(update);

		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 System.out.println(e.getActionCommand());        // ���õ� ��ư�� �ؽ�Ʈ�� ���
				 
				 //row = table.getSelectedRow();
				 if(row<0) return; // ������ �ȵ� ���¸� -1����
				 
				 String query = "DELETE FROM Schedule WHERE schedule = ? AND datetime = ?";
				 
				 try{
					 Class.forName("org.sqlite.JDBC");
					 Connection connection = DriverManager.getConnection("jdbc:sqlite:OnedayWrite.db");
					 PreparedStatement ps = connection.prepareStatement(query);
					 
					 ps.setString(1, (String)model.getValueAt(row, 0));
					 //System.out.println((String)model.getValueAt(row, 0));
					 ps.setString(2, (String)model.getValueAt(row, 1));
					 //System.out.println((String)model.getValueAt(row, 1));
					 
					 int cnt = ps.executeUpdate();
					 
					 ps.close();
					 connection.close();
				 } catch (ClassNotFoundException | SQLException e1) {
						System.out.println("Schedule �����ͺ��̽� ���� ���� " + e1.getMessage());
				 }
				 
				 model.removeRow(row);
			}
		});
		delete.setText("DELETE");
		delete.setUI(new StyledButtonUI_etc());
		delete.setBackground(thatch);
		btn.add(delete);
		
		add(jsp);
		add(up);
		add(btn);
	}
	 
}

//����° �޴� - ADD
class menu_3_1 extends JPanel {
	Date d = new Date();
	SimpleDateFormat f = new SimpleDateFormat("MMdd");
	
	public menu_3_1(Menu panel) {
		setBorder(BorderFactory.createEmptyBorder(10 , 10 , 10 , 10));
		setPreferredSize(new Dimension(500, 275));

		JLabel menu3 = new JLabel("< Q & A > ADD");
		menu3.setFont(new Font("���� ���", Font.BOLD, 20));

		Color mushroom = new Color(255,220,217);
		Color elephant = new Color(143, 134, 129);
		Color thatch = new Color(166, 127, 120);
		Color gunmetal = new Color(50, 67, 95);

		//setBackground(mushroom);

		GridLayout gridLayout_3 = new GridLayout();
		gridLayout_3.setRows(4);
		gridLayout_3.setColumns(1);
		gridLayout_3.setHgap(20); // �� cell ������ ���� (������ px)
		setLayout(gridLayout_3);

		JTextArea qa = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(qa);
		
		JPanel showQ = new JPanel();
		JTextField q = new JTextField(40);
		q.setHorizontalAlignment(JTextField.CENTER);
		showQ.add(q);
		
		try {
			String ds = f.format(d);
			
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:OnedayWrite.db");
			
			PreparedStatement ps = connection.prepareStatement("SELECT q FROM Q where qdate = ?");
			ps.setString(1, ds);
			ResultSet rs = ps.executeQuery();
			
			String Q = rs.getString("q");
			
			q.setText(Q);
			
			ps.close();
			rs.close();
			
			connection.close();
		} catch (ClassNotFoundException | SQLException e1) {
			System.out.println("Q �����ͺ��̽� ���� ���� " + e1.getMessage());
		}
		q.setEditable(false);
		q.setFont(new Font("���� ���", Font.BOLD, 15));

		JPanel etcbtn = new JPanel();
		//etcbtn.setBackground(mushroom);
		JButton save = new JButton("SAVE");
		JButton clear = new JButton("CLEAR");
		save.setUI(new StyledButtonUI_etc());
		clear.setUI(new StyledButtonUI_etc());
		save.setBackground(thatch);
		clear.setBackground(thatch);
		etcbtn.add(save);
		etcbtn.add(clear);
		
		add(menu3);
		add(showQ);
		add(qa);
		add(etcbtn);
		
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					f = new SimpleDateFormat("yyyyMMdd");
					String ds = f.format(d);
					String Qa = null;
					
					Class.forName("org.sqlite.JDBC");
					Connection connection = DriverManager.getConnection("jdbc:sqlite:OnedayWrite.db");
					
					PreparedStatement ps = connection.prepareStatement("SELECT qa FROM QA where fdate = ?");
					ps.setString(1, ds);
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						Qa = rs.getString("qa");
					}
					
					if(Qa == null) {
						ps = connection.prepareStatement("INSERT INTO QA VALUES(?, ?, ?, ?, ?, ?)");
						ps.setString(1, qa.getText());
						f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						ds = f.format(d);
						ps.setString(2, ds);
						f = new SimpleDateFormat("yyyyMMdd");
						ds = f.format(d);
						ps.setString(3, ds);
						f = new SimpleDateFormat("MMdd");
						ds = f.format(d);
						ps.setString(4, ds);
						f = new SimpleDateFormat("yyyy");
						ds = f.format(d);
						ps.setString(5, ds);
						f = new SimpleDateFormat("MM");
						ds = f.format(d);
						ps.setString(6, ds);
						
						int res = ps.executeUpdate();
						if(res == 1) {
							JOptionPane.showMessageDialog(null, "���������� ����Ǿ����ϴ�.", "�� ��", JOptionPane.WARNING_MESSAGE);
						}
					}else if(Qa != null) {
						JOptionPane.showMessageDialog(null, "�̹� ����� Q&A�� �ֽ��ϴ�.", "�� ��", JOptionPane.WARNING_MESSAGE);
					}
					
					ps.close();
					rs.close();
					
					connection.close();
				} catch (ClassNotFoundException | SQLException e1) {
					System.out.println("Q&A �����ͺ��̽� ���� ���� " + e1.getMessage());
				}
			}
		});
		
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				qa.setText("");
			}
		});
	}
}
//����° �޴� - VIEW
class menu_3_2 extends JPanel {
	Date d = new Date();
	SimpleDateFormat f = new SimpleDateFormat("MMdd");
	String ds = f.format(d);
	
	Color bg = new Color(238, 238, 238);
	String colName[] = {"Q & A", "DATETIME"};
	Object[][] rowDate = new Object[0][2];
	DefaultTableModel model = new DefaultTableModel(rowDate, colName);
	JTable table = new JTable(model);
	JScrollPane jsp = new JScrollPane(table);
	
	JButton update = null;
	JButton delete = null;
	
	int row;
	
	private void select() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:OnedayWrite.db");
			
			// �ʿ��� ���ǹ��� connection ��ü�� ���Ͽ� ����
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM QA where mddate = ?");
			ps.setString(1, ds);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String qa = rs.getString("qa");
				String date = rs.getString("datetime");
				
				Object data[] = {qa, date};
				model.addRow(data);
			}
						
			ps.close();
			rs.close();
			
			DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();// DefaultTableCellHeaderRenderer ���� (��� ������ ����)
			tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER); // DefaultTableCellHeaderRenderer�� ������ ��� ���ķ� ����
			
			TableColumnModel tcmSchedule = table.getColumnModel(); // ������ ���̺��� ColumnModel�� ������
			for (int j = 0; j < tcmSchedule.getColumnCount(); j++) { // �ݺ����� �̿��Ͽ� ���̺��� ��� ���ķ� ����
				tcmSchedule.getColumn(j).setCellRenderer(tScheduleCellRenderer);
			}
			
			table.setBackground(bg);
								
			connection.close();
		} catch (ClassNotFoundException | SQLException e1) {
			System.out.println("QA �����ͺ��̽� ���� ����" + e1.getMessage());
		}
	}
	
	public menu_3_2(Menu panel) {
		setBorder(BorderFactory.createEmptyBorder(10 , 10 , 10 , 10));
		setPreferredSize(new Dimension(500, 275));

		JLabel menu3 = new JLabel("< Q & A > VIEW");
		menu3.setFont(new Font("���� ���", Font.BOLD, 20));

		Color mushroom = new Color(255,220,217);
		Color elephant = new Color(143, 134, 129);
		Color thatch = new Color(166, 127, 120);
		Color gunmetal = new Color(50, 67, 95);
		Color bg = new Color(238, 238, 238);

		//setBackground(mushroom);

		add(menu3);

		setLayout(new GridLayout(4, 0));
		JPanel btn = new JPanel();
		btn.setLayout(new FlowLayout());
		update = new JButton();
		delete = new JButton();
		
		JTextField Update = new JTextField(40);
		JPanel up = new JPanel();
		up.add(Update);
		
		select();
		
		table.addMouseListener(new MouseListener() {
			   @Override
			   public void mouseReleased(MouseEvent e) {}
			   @Override
			   public void mousePressed(MouseEvent e) {}
			   @Override
			   public void mouseExited(MouseEvent e) {}
			   @Override
			   public void mouseEntered(MouseEvent e) {}
			   
			   @Override
			   public void mouseClicked(MouseEvent e) { //���콺�� ������ ���� ������ ������ �ؽ�Ʈ�ʵ忡 ����ϱ� 
			    row = table.getSelectedRow();
			    
			    Update.setText((String)model.getValueAt(row, 0));
			    }
			   
		});
		
		update = new JButton();
		update.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand());
				
				//row = table.getSelectedRow();
				if(row<0) return;
				
				String query = "UPDATE QA SET QA = ?, datetime = ?, finddate = ?, mddate = ?, year = ?, month = ? WHERE qa = ? AND datetime = ?";
				
				try {
					Class.forName("org.sqlite.JDBC");
					Connection connection = DriverManager.getConnection("jdbc:sqlite:OnedayWrite.db");
					
					// �ʿ��� ���ǹ��� connection ��ü�� ���Ͽ� ����
					PreparedStatement ps = connection.prepareStatement(query);
					
					//modelUpdate.fireTableDataChanged();
					ps.setString(1, Update.getText());
					SimpleDateFormat fUpdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String dsUpdate = fUpdate.format(d);
					ps.setString(2, dsUpdate);
					fUpdate = new SimpleDateFormat("yyyyMMdd");
					dsUpdate = fUpdate.format(d);
					ps.setString(3, dsUpdate);
					fUpdate = new SimpleDateFormat("MMdd");
					dsUpdate = fUpdate.format(d);
					ps.setString(4, dsUpdate);
					fUpdate = new SimpleDateFormat("yyyy");
					dsUpdate = fUpdate.format(d);
					ps.setString(5, dsUpdate);
					fUpdate = new SimpleDateFormat("MM");
					dsUpdate = fUpdate.format(d);
					ps.setString(6, dsUpdate);
					
					int cnt = ps.executeUpdate();
					
					ps.close();
					connection.close();
				} catch (ClassNotFoundException | SQLException e1) {
					System.out.println("QA �����ͺ��̽� ���� ���� " + e1.getMessage());
				}
				model.setRowCount(0);
				select();
				Update.setText("");
			}
		});
		update.setText("UPDATE");
		update.setUI(new StyledButtonUI_etc());
		update.setBackground(thatch);
		btn.add(update);

		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 System.out.println(e.getActionCommand());        // ���õ� ��ư�� �ؽ�Ʈ�� ���
				 
				 //row = table.getSelectedRow();
				 if(row<0) return; // ������ �ȵ� ���¸� -1����
				 
				 String query = "DELETE FROM QA WHERE qa = ? AND datetime = ?";
				 
				 try{
					 Class.forName("org.sqlite.JDBC");
					 Connection connection = DriverManager.getConnection("jdbc:sqlite:OnedayWrite.db");
					 PreparedStatement ps = connection.prepareStatement(query);
					 
					 ps.setString(1, (String)model.getValueAt(row, 0));
					 //System.out.println((String)model.getValueAt(row, 0));
					 ps.setString(2, (String)model.getValueAt(row, 1));
					 //System.out.println((String)model.getValueAt(row, 1));
					 
					 int cnt = ps.executeUpdate();
					 
					 ps.close();
					 connection.close();
				 } catch (ClassNotFoundException | SQLException e1) {
						System.out.println("QA �����ͺ��̽� ���� ���� " + e1.getMessage());
				 }
				 
				 model.removeRow(row);
				 Update.setText("");
			}
		});
		delete.setText("DELETE");
		delete.setUI(new StyledButtonUI_etc());
		delete.setBackground(thatch);
		btn.add(delete);
		
		add(jsp);
		add(up);
		add(btn);
	}
	 
}

//�׹�° �޴� - ADD
class menu_4_1 extends JPanel implements ActionListener{
	Date d = new Date();
	SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
	String ds = f.format(d);
	JLabel pictureSrc = new JLabel("");
	JRadioButton r1, r2;
	String p = null;
	
	public menu_4_1(Menu panel) throws IOException {
		setBorder(BorderFactory.createEmptyBorder(10 , 10 , 10 , 10));
		setPreferredSize(new Dimension(500, 275));

		JLabel menu3 = new JLabel("< DIARY > ADD");
		menu3.setFont(new Font("���� ���", Font.BOLD, 20));

		Color mushroom = new Color(255,220,217);
		Color elephant = new Color(143, 134, 129);
		Color thatch = new Color(166, 127, 120);
		Color gunmetal = new Color(50, 67, 95);

		//setBackground(mushroom);

		GridLayout gridLayout_3 = new GridLayout();
		gridLayout_3.setRows(4);
		gridLayout_3.setColumns(1);
		gridLayout_3.setHgap(20); // �� cell ������ ���� (������ px)
		setLayout(gridLayout_3);

		JTextArea qa = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(qa);
		
		JPanel picture = new JPanel(new GridLayout(1, 2));
		JPanel pic = new JPanel();
		JPanel picbtn = new JPanel();
		JTextArea NamePicture = new JTextArea(1, 20);
		JLabel name = new JLabel("���� �̸� �� (OnedayWrite ����)");
		NamePicture.setBorder(BorderFactory.createLineBorder(Color.RED));
		pic.add(name);
		pic.add(NamePicture);
		ButtonGroup g = new ButtonGroup();
		r1 = new JRadioButton("jpg", true);
		r2 = new JRadioButton("png");
		g.add(r1); picbtn.add(r1);
		g.add(r2); picbtn.add(r2);
		picture.add(pic);
		picture.add(picbtn);
		
		r1.addActionListener(this);
		r2.addActionListener(this);
		
		JPanel etcbtn = new JPanel();
		//etcbtn.setBackground(mushroom);
		JButton save = new JButton("SAVE");
		JButton clear = new JButton("CLEAR");
		save.setUI(new StyledButtonUI_etc());
		clear.setUI(new StyledButtonUI_etc());
		save.setBackground(thatch);
		clear.setBackground(thatch);
		etcbtn.add(save);
		etcbtn.add(clear);
		
		add(menu3);
		add(qa);
		add(picture);
		add(etcbtn);
		
		if(NamePicture != null) {
			p = NamePicture + pictureSrc.getText();
		}
		
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					f = new SimpleDateFormat("yyyy-MM-dd");
					String ds = f.format(d);
					String diary = null;
					
					Class.forName("org.sqlite.JDBC");
					Connection connection = DriverManager.getConnection("jdbc:sqlite:OnedayWrite.db");
					
					PreparedStatement ps = connection.prepareStatement("SELECT diary FROM DIARY where date = ?");
					ps.setString(1, ds);
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						diary = rs.getString("diary");
					}
					
					if(diary == null) {
						ps = connection.prepareStatement("INSERT INTO DIARY VALUES(?, ?, ?, ?, ?, ?)");						
						ps.setString(1, qa.getText());
						f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						ds = f.format(d);
						ps.setString(2, ds);
						f = new SimpleDateFormat("yyyy-MM-dd");
						ds = f.format(d);
						ps.setString(3, ds);
						f = new SimpleDateFormat("yyyy");
						ds = f.format(d);
						ps.setString(4, ds);
						f = new SimpleDateFormat("MM");
						ds = f.format(d);
						ps.setString(5, ds);
						if(p != null) {
							File file = new File(p);
							FileInputStream is = new FileInputStream(file);
							byte[] fileBytes = new byte[(int) file.length()];
							is.read(fileBytes);
							ps.setBytes(6, fileBytes);
							
							is.close();
						} else {
							ps.setString(6, null);
						}
							
						int res = ps.executeUpdate();
						if(res == 1) {
							JOptionPane.showMessageDialog(null, "���������� ����Ǿ����ϴ�.", "�� ��", JOptionPane.WARNING_MESSAGE);
						}
					}else if(diary != null) {
						JOptionPane.showMessageDialog(null, "�̹� ����� diary�� �ֽ��ϴ�.", "�� ��", JOptionPane.WARNING_MESSAGE);
					}
					
					ps.close();
					rs.close();
					
					connection.close();
				} catch (ClassNotFoundException | SQLException | IOException e1) {
					System.out.println("Q&A �����ͺ��̽� ���� ���� " + e1.getMessage());
				}
			}
		});
		
		//is.close();		
		
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				qa.setText("");
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == r1) {
			pictureSrc.setText(".jpg");
		} else if (e.getSource() == r2) {
			pictureSrc.setText(".png");
		}
	}
	
}
//�׹�° �޴� - VIEW
class menu_4_2 extends JPanel {
	Date d = new Date();
	SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
	String ds = f.format(d);
	
	Color bg = new Color(238, 238, 238);
	String colName[] = {"DIARY", "DATETIME"};
	Object[][] rowDate = new Object[0][2];
	DefaultTableModel model = new DefaultTableModel(rowDate, colName);
	JTable table = new JTable(model);
	JScrollPane jsp = new JScrollPane(table);
	
	JButton update = null;
	JButton delete = null;
	
	int row;
	
	private void select() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:OnedayWrite.db");
			
			// �ʿ��� ���ǹ��� connection ��ü�� ���Ͽ� ����
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM DIARY where date = ?");
			ps.setString(1, ds);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String sche = rs.getString("diary");
				String date = rs.getString("datetime");
				
				Object data[] = {sche, date};
				model.addRow(data);
			}
						
			ps.close();
			rs.close();
			
			DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();// DefaultTableCellHeaderRenderer ���� (��� ������ ����)
			tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER); // DefaultTableCellHeaderRenderer�� ������ ��� ���ķ� ����
			
			TableColumnModel tcmSchedule = table.getColumnModel(); // ������ ���̺��� ColumnModel�� ������
			for (int j = 0; j < tcmSchedule.getColumnCount(); j++) { // �ݺ����� �̿��Ͽ� ���̺��� ��� ���ķ� ����
				tcmSchedule.getColumn(j).setCellRenderer(tScheduleCellRenderer);
			}
			
			table.setBackground(bg);
								
			connection.close();
		} catch (ClassNotFoundException | SQLException e1) {
			System.out.println("DIARY �����ͺ��̽� ���� ����" + e1.getMessage());
		}
	}
	
	public menu_4_2(Menu panel) {
		setBorder(BorderFactory.createEmptyBorder(10 , 10 , 10 , 10));
		setPreferredSize(new Dimension(500, 275));

		JLabel menu3 = new JLabel("< DIARY > VIEW");
		menu3.setFont(new Font("���� ���", Font.BOLD, 20));

		Color mushroom = new Color(255,220,217);
		Color elephant = new Color(143, 134, 129);
		Color thatch = new Color(166, 127, 120);
		Color gunmetal = new Color(50, 67, 95);
		Color bg = new Color(238, 238, 238);

		//setBackground(mushroom);

		add(menu3);

		setLayout(new GridLayout(4, 0));
		JPanel btn = new JPanel();
		btn.setLayout(new FlowLayout());
		update = new JButton();
		delete = new JButton();
		
		JTextField Update = new JTextField(40);
		JPanel up = new JPanel();
		up.add(Update);
		
		select();
		
		table.addMouseListener(new MouseListener() {
			   @Override
			   public void mouseReleased(MouseEvent e) {}
			   @Override
			   public void mousePressed(MouseEvent e) {}
			   @Override
			   public void mouseExited(MouseEvent e) {}
			   @Override
			   public void mouseEntered(MouseEvent e) {}
			   
			   @Override
			   public void mouseClicked(MouseEvent e) { //���콺�� ������ ���� ������ ������ �ؽ�Ʈ�ʵ忡 ����ϱ� 
			    row = table.getSelectedRow();
			    
			    Update.setText((String)model.getValueAt(row, 0));
			   }	   
		});
		
		update = new JButton();
		update.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand());
				
				//row = table.getSelectedRow();
				if(row<0) return;
				
				String query = "UPDATE DIARY SET diary = ?, datetime = ?, date = ?, year = ?, month = ? WHERE diary = ? AND datetime = ?";
				
				try {
					Class.forName("org.sqlite.JDBC");
					Connection connection = DriverManager.getConnection("jdbc:sqlite:OnedayWrite.db");
					
					// �ʿ��� ���ǹ��� connection ��ü�� ���Ͽ� ����
					PreparedStatement ps = connection.prepareStatement(query);
					
					//modelUpdate.fireTableDataChanged();
					ps.setString(1, Update.getText());
					SimpleDateFormat fUpdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String dsUpdate = fUpdate.format(d);
					ps.setString(2, dsUpdate);
					fUpdate = new SimpleDateFormat("yyyy-MM-dd");
					dsUpdate = fUpdate.format(d);
					ps.setString(3, dsUpdate);
					fUpdate = new SimpleDateFormat("yyyy");
					dsUpdate = fUpdate.format(d);
					ps.setString(4, dsUpdate);
					fUpdate = new SimpleDateFormat("MM");
					dsUpdate = fUpdate.format(d);
					ps.setString(5, dsUpdate);
					
					int cnt = ps.executeUpdate();
					
					ps.close();
					connection.close();
				} catch (ClassNotFoundException | SQLException e1) {
					System.out.println("Schedule �����ͺ��̽� ���� ���� " + e1.getMessage());
				}
				model.setRowCount(0);
				select();
				Update.setText("");
			}
		});
		update.setText("UPDATE");
		update.setUI(new StyledButtonUI_etc());
		update.setBackground(thatch);
		btn.add(update);
		
		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 System.out.println(e.getActionCommand());        // ���õ� ��ư�� �ؽ�Ʈ�� ���
				 
				 //row = table.getSelectedRow();
				 if(row<0) return; // ������ �ȵ� ���¸� -1����
				 
				 String query = "DELETE FROM DIARY WHERE diary = ? AND datetime = ?";
				 
				 try{
					 Class.forName("org.sqlite.JDBC");
					 Connection connection = DriverManager.getConnection("jdbc:sqlite:OnedayWrite.db");
					 PreparedStatement ps = connection.prepareStatement(query);
					 
					 ps.setString(1, (String)model.getValueAt(row, 0));
					 //System.out.println((String)model.getValueAt(row, 0));
					 ps.setString(2, (String)model.getValueAt(row, 1));
					 //System.out.println((String)model.getValueAt(row, 1));
					 
					 int cnt = ps.executeUpdate();
					 
					 ps.close();
					 connection.close();
				 } catch (ClassNotFoundException | SQLException e1) {
						System.out.println("Schedule �����ͺ��̽� ���� ���� " + e1.getMessage());
				 }
				 
				 model.removeRow(row);
				 Update.setText("");
			}
		});
		delete.setText("DELETE");
		delete.setUI(new StyledButtonUI_etc());
		delete.setBackground(thatch);
		btn.add(delete);
		
		add(jsp);
		add(up);
		add(btn);
	}
	 
}

public class Menu extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public static JPanel firstCards = new JPanel();
	public static JPanel Cards = new JPanel();
	
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					//ù��° �޴�
					Menu panel1 = new Menu();
					panel1.setPreferredSize(new Dimension(500, 375));
					panel1.setBounds(100, 100, 450, 300);
					//panel1.firstCards = new JPanel();
					panel1.firstCards.setBorder(new EmptyBorder(0, 0, 0, 0));
					panel1.firstCards.setLayout(new CardLayout(0, 0));
					panel1.add(firstCards);
					menu_s1 menu_s1 = new menu_s1(panel1);
					menu_s2 menu_s2 = new menu_s2(panel1);
					menu_2_1 menu2_1 = new menu_2_1(panel1);
					menu_2_2 menu2_2 = new menu_2_2(panel1);

					panel1.firstCards.add(menu_s1, "menu_s1");
					panel1.firstCards.add(menu_s2, "menu_s2");
					panel1.firstCards.add(menu2_1, "menu2_1");
					panel1.firstCards.add(menu2_2, "menu2_2");

					firstmenubar fmenubar = new firstmenubar(panel1);
					//ù ��° �޴��� ��
					
					//�ι�°, ����° �޴�
					Menu panel2 = new Menu();
					panel2.setPreferredSize(new Dimension(500, 375));
					panel2.setBounds(100, 100, 450, 300);
					//panel2.Cards = new JPanel();
					panel2.Cards.setBorder(new EmptyBorder(0, 0, 0, 0));
					panel2.Cards.setLayout(new CardLayout(0, 0));
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
					//��, ����° �޴��� ��

					JFrame ff= new JFrame("CardlayoutFuckYou");
					ff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					ff.setPreferredSize(new Dimension(500,750));
					//BoxLayout boxLayout = new BoxLayout(ff, BoxLayout.Y_AXIS);
					//ff.setLayout(boxLayout);
					Box box = Box.createVerticalBox();
				    box.add(fmenubar);
				    box.add(Box.createVerticalStrut(10));
				    box.add(panel1);
				    box.add(Box.createVerticalStrut(10));
				    box.add(menubar);
				    box.add(Box.createVerticalStrut(10));
				    box.add(panel2);
				    ff.add(box, BorderLayout.CENTER);
					/*ff.add(fmenubar);
					ff.add(panel1);
					ff.add(menubar);
					ff.add(panel2);*/
					ff.pack();
					ff.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*public Menu() {

		setPreferredSize(new Dimension(500, 350));
		setBounds(100, 100, 450, 300);
		Cards = new JPanel();
		Cards.setBorder(new EmptyBorder(0, 0, 0, 0));
		Cards.setLayout(new CardLayout(0, 0));
		add(Cards);
	}*/

}
