import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

public class Cal extends JPanel {
	
	Color mushroom = new Color(255,220,217);
	Color elephant = new Color(143, 134, 129);
	Color thatch = new Color(166, 127, 120);
	Color gunmetal = new Color(50, 67, 95);
	Color mc = elephant;
	
	/** The currently-interesting year (not modulo 1900!) */
	protected int yy;

	/** Currently-interesting month and day */
	protected int mm, dd;

	/** The buttons to be displayed */
	protected JButton labs[][];

	/** The number of day squares to leave blank at the start of this month */
	protected int leadGap = 0;

	/** A Calendar object used throughout */
	Calendar calendar = new GregorianCalendar();

	/** Today's year */
	protected final int thisYear = calendar.get(Calendar.YEAR);

	/** Today's month */
	protected final int thisMonth = calendar.get(Calendar.MONTH);

	/** One of the buttons. We just keep its reference for getBackground(). */
	private JButton b0;

	/** The month choice */
	private JButton mcB = new JButton();
	private JButton mcF = new JButton();

	/** The year choice */
	private JButton ycB = new JButton();
	private JButton ycF = new JButton();

	/**
	 * Construct a Cal, starting with today.
	 */
	Cal() {
		super();
		setYYMMDD(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
		buildGUI();
		recompute();
	}
	
	
	/**
	 * Construct a Cal, given the leading days and the total days
	 * 
	 * @exception IllegalArgumentException
	 *                    If year out of range
	 */
	Cal(int year, int month, int today) {
		super();
		setYYMMDD(year, month, today);
		buildGUI();
		recompute();
	}

	private void setYYMMDD(int year, int month, int today)
	{
		yy = year;
		mm = month;
		dd = today;
	}

	
	String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
	
	/** Build the GUI. Assumes that setYYMMDD has been called. */
	private void buildGUI()
	{
		getAccessibleContext().setAccessibleDescription("Calendar not accessible yet. Sorry!");
		setBorder(BorderFactory.createEtchedBorder());

		setLayout(new BorderLayout());

		JPanel tp = new JPanel();
		JLabel info = new JLabel("     "+yy+" . "+String.format("%02d", mm+1)+"  ");
		JLabel info_m = new JLabel(months[mm]+"     ");
		info.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		mcB.setText("<");
		mcF.setText(">");
		mcB.setUI(new StyledButtonUI());
		mcF.setUI(new StyledButtonUI());
		mcB.setBackground(Color.white);
		mcF.setBackground(Color.white);
		ycB.setText("<<");
		ycF.setText(">>");
		ycB.setUI(new StyledButtonUI());
		ycF.setUI(new StyledButtonUI());
		ycB.setBackground(Color.white);
		ycF.setBackground(Color.white);
		
		mcB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				if(mm > 0) mm --;
				info.setText("     "+yy+" . "+String.format("%02d", mm+1)+"     ");
				info_m.setText(months[mm]+"     ");
				recompute();
			}
		});
		mcF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(mm < 11) mm ++;
				info.setText("     "+yy+" . "+String.format("%02d", mm+1)+"     ");
				info_m.setText(months[mm]+"     ");
				recompute();
			}
		});
		mcB.getAccessibleContext().setAccessibleName("Months");
		mcF.getAccessibleContext().setAccessibleName("Months");
		mcB.getAccessibleContext().setAccessibleDescription("Choose a month of the year");
		mcF.getAccessibleContext().setAccessibleDescription("Choose a month of the year");
		
		
		ycB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				yy --;
				info.setText("     "+yy+" . "+String.format("%02d", mm+1)+"     ");
				recompute();
			}
		});
		ycF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				yy ++;
				info.setText("     "+yy+" . "+String.format("%02d", mm+1)+"     ");
				recompute();
			}
		});
		tp.add(BorderLayout.WEST, ycB);
		tp.add(BorderLayout.WEST, mcB);
		tp.add(BorderLayout.NORTH, info);
		tp.add(BorderLayout.SOUTH, info_m);
		tp.add(BorderLayout.EAST, mcF);
		tp.add(BorderLayout.EAST, ycF);
		tp.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		add(BorderLayout.NORTH, tp);

		//오늘, 선택한 날짜 각각 표시
		//JButton ButToday = new JButton("Today");
		JLabel today = new JLabel("Today  is  " + calendar.get(Calendar.YEAR) + " .  " + 
		(calendar.get(Calendar.MONTH)+1) + " .  " + calendar.get(Calendar.DAY_OF_MONTH)+"     ");
		
		Date d = new Date();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		String ds = f.format(d);
		int scheCount = 0;

		try {
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:OnedayWrite.db");	
			
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM Schedule where date = ?");
			ps.setString(1, ds);
			ResultSet rs = ps.executeQuery();
					
			while(rs.next()) {
				scheCount++;
			}
					
			ps.close();
			rs.close();
					
			connection.close();
		} catch (ClassNotFoundException | SQLException e1) {
			System.out.println("Schedule 데이터베이스 연결 오류" + e1.getMessage());
		}
		
		JLabel Schedule = new JLabel();
		
		if(scheCount == 0) Schedule.setText("오늘은 일정이 없습니다.");
		else Schedule.setText("오늘은 " + scheCount + "개의 일정이 있습니다. SCHEDULE를 확인해주세요.");
		
		f = new SimpleDateFormat("yyyy");
		ds = f.format(d);
		int QCount = 0;
		int DCount = 0;

		try {
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:OnedayWrite.db");	
			
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM QA where year = ?");
			ps.setString(1, ds);
			ResultSet rs = ps.executeQuery();
					
			while(rs.next()) {
				QCount++;
			}
			
			ps = connection.prepareStatement("SELECT * FROM DIARY where year = ?");
			ps.setString(1, ds);
			rs = ps.executeQuery();
					
			while(rs.next()) {
				DCount++;
			}
					
			ps.close();
			rs.close();
					
			connection.close();
		} catch (ClassNotFoundException | SQLException e1) {
			System.out.println("Schedule 데이터베이스 연결 오류" + e1.getMessage());
		}
		
		JLabel year = new JLabel();
		
		year.setText("올해는 " + QCount + "개의 Q & A와 " + DCount + "개의 일기가 작성되었습니다.");
		
		f = new SimpleDateFormat("MM");
		ds = f.format(d);
		QCount = 0;
		DCount = 0;

		try {
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:OnedayWrite.db");	
			
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM QA where month = ?");
			ps.setString(1, ds);
			ResultSet rs = ps.executeQuery();
					
			while(rs.next()) {
				QCount++;
			}
			
			ps = connection.prepareStatement("SELECT * FROM DIARY where month = ?");
			ps.setString(1, ds);
			rs = ps.executeQuery();
					
			while(rs.next()) {
				DCount++;
			}
					
			ps.close();
			rs.close();
					
			connection.close();
		} catch (ClassNotFoundException | SQLException e1) {
			System.out.println("Schedule 데이터베이스 연결 오류" + e1.getMessage());
		}
		
		JLabel month = new JLabel();
		
		month.setText("이번 달은 " + QCount + "개의 Q & A와 " + DCount + "개의 일기가 작성되었습니다.");
		
		today.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		Schedule.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		year.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		month.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		JPanel tl = new JPanel();
		GridLayout gridLayout = new GridLayout();
		gridLayout.setRows(4);
		gridLayout.setColumns(1);
		gridLayout.setHgap(10); // 각 cell 사이의 간격 (단위는 px)
		tl.setLayout(gridLayout);
		//tl.add(ButToday);
		
		tl.add(today);
		tl.add(Schedule);
		tl.add(year);
		tl.add(month);
		add(BorderLayout.EAST, tl);
		
		
		
		JPanel bp = new JPanel();
		bp.setLayout(new GridLayout(7, 7));
		labs = new JButton[6][7]; // first row is days
		String weekday[] = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

		for (int i = 0; i < 7; i++) {
			if(i==0) {
				b0 = new JButton(weekday[i]);
				b0.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
				b0.setBackground(mc);
				b0.setForeground(Color.red);
				b0.setUI(new StyledButtonUI());
				bp.add(b0);
			} else {
				final JButton button = new JButton(weekday[i]);
				button.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
				button.setBackground(mc);
				button.setForeground(Color.white);
				// customize the button with your own look
				button.setUI(new StyledButtonUI());
				bp.add(button);
			}
		}
		//        bp.add(b0 = new JButton("S"));
		//        bp.add(new JButton("M"));
		//        bp.add(new JButton("T"));
		//        bp.add(new JButton("W"));
		//        bp.add(new JButton("R"));
		//        bp.add(new JButton("F"));
		//        bp.add(new JButton("S"));

		ActionListener dateSetter = new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String num = e.getActionCommand();
				if (!num.equals(""))
				{
					// set the current day highlighted
					setDayActive(Integer.parseInt(num));
					// When this becomes a Bean, you can
					// fire some kind of DateChanged event here.
					// Also, build a similar daySetter for day-of-week btns.
				}
			}
		};

		// Construct all the buttons, and add them.
		for (int i = 0; i < 6; i++)
			for (int j = 0; j < 7; j++)
			{
				bp.add(labs[i][j] = new JButton(""));
				labs[i][j].setFont(new Font("맑은 고딕", Font.PLAIN, 14));
				labs[i][j].setBackground(Color.white);
				labs[i][j].setForeground(Color.black);	
				labs[i][j].setUI(new StyledButtonUI_small());
				labs[i][j].addActionListener(dateSetter);
			}

		add(BorderLayout.SOUTH, bp);
	}

	public final static int dom[] = 
		{ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	/** Compute which days to put where, in the Cal panel */
	protected void recompute()
	{
		// System.out.println("Cal::recompute: " + yy + ":" + mm + ":" + dd);
		if (mm < 0 || mm > 11)
			throw new IllegalArgumentException("Month " + mm + " bad, must be 0-11");
		clearDayActive();
		calendar = new GregorianCalendar(yy, mm, dd);

		// Compute how much to leave before the first.
		// getDay() returns 0 for Sunday, which is just right.
		leadGap = new GregorianCalendar(yy, mm, 1).get(Calendar.DAY_OF_WEEK) - 1;
		// System.out.println("leadGap = " + leadGap);

		int daysInMonth = dom[mm];
		if (isLeap(calendar.get(Calendar.YEAR)) && mm > 1)
			++daysInMonth;

		// Blank out the labels before 1st day of month
		for (int i = 0; i < leadGap; i++)
		{
			labs[0][i].setText("");
		}
		
		// Fill in numbers for the day of month.
		for (int i = 1; i <= daysInMonth; i++)
		{
			//leadgap=>금요일=>6=>배열로는 5번째 자리
			//leadGap에는 년,월,1일의 요일-1이 들어감
			//[]: 행, []: 열 
			
			JButton b = labs[(leadGap + i - 1) / 7][(leadGap + i - 1) % 7];
			b.setText(Integer.toString(i));
			if((leadGap + i - 1) % 7 == 0) b.setForeground(Color.red);
		}
		

		// 7 days/week * up to 6 rows
		for (int i = leadGap + 1 + daysInMonth; i < 6 * 7; i++)
		{
			labs[(i) / 7][(i) % 7].setText("");
		}

		// Shade current day, only if current month
		if (thisYear == yy && mm == thisMonth)
			setDayActive(dd); // shade the box for today

		// Say we need to be drawn on the screen
		repaint();
	}

	/**
	 * isLeap() returns true if the given year is a Leap Year.
	 * 
	 * "a year is a leap year if it is divisible by 4 but not by 100, except
	 * that years divisible by 400 *are* leap years." -- Kernighan &
	 * Ritchie, _The C Programming Language_, p 37.
	 */
	public boolean isLeap(int year)
	{
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
			return true;
		return false;
	}

	/** Set the year, month, and day */
	public void setDate(int yy, int mm, int dd)
	{
		// System.out.println("Cal::setDate");
		this.yy = yy;
		this.mm = mm; // starts at 0, like Date
		this.dd = dd;
		recompute();
	}

	/** Unset any previously highlighted day */
	private void clearDayActive()
	{
		JButton b;

		// First un-shade the previously-selected square, if any
		if (activeDay > 0)
		{
			b = labs[(leadGap + activeDay - 1) / 7][(leadGap + activeDay - 1) % 7];
			b.setBackground(Color.white);
			b.repaint();
			activeDay = -1;
		}
	}

	private int activeDay = -1;

	/** Set just the day, on the current month */
	public void setDayActive(int newDay)
	{		
		clearDayActive();

		// Set the new one
		if (newDay <= 0)
			dd = new GregorianCalendar().get(Calendar.DAY_OF_MONTH);
		else
			dd = newDay;
		// Now shade the correct square
		Component square = labs[(leadGap + newDay - 1) / 7][(leadGap + newDay - 1) % 7];
		square.setBackground(Color.red);
		square.repaint();
		activeDay = newDay;
	}

	/** For testing, a main program */
	public static void main(String[] av)
	{
		JFrame f = new JFrame("Cal");
		Container c = f.getContentPane();
		c.setLayout(new FlowLayout());

		// and beside it, the current month.
		c.add(new Cal());

		f.pack();
		f.setVisible(true);
		
	}
}