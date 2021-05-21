package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ThemGUI extends JFrame {
	private JPanel wrapper;
	private JPanel header;
	private int xx;
	private int xy;
	private JLabel exitLabel;
	private JTextField maTxt;
	private JTextField tenTxt;
	private JTextField ngaySinhTxt;
	private JTextField sDTTxt;
	private JTextField emailTxt;
	private JButton buttonThem;
	
	public JPanel getWrapper() {
		return wrapper;
	}
	public void setWrapper(JPanel wrapper) {
		this.wrapper = wrapper;
	}
	public JPanel getHeader() {
		return header;
	}
	public void setHeader(JPanel header) {
		this.header = header;
	}
	public JLabel getExitLabel() {
		return exitLabel;
	}
	public void setExitLabel(JLabel exitLabel) {
		this.exitLabel = exitLabel;
	}
	public JTextField getMaTxt() {
		return maTxt;
	}
	public void setMaTxt(JTextField maTxt) {
		this.maTxt = maTxt;
	}
	public JTextField getTenTxt() {
		return tenTxt;
	}
	public void setTenTxt(JTextField tenTxt) {
		this.tenTxt = tenTxt;
	}
	public JTextField getNgaySinhTxt() {
		return ngaySinhTxt;
	}
	public void setNgaySinhTxt(JTextField ngaySinhTxt) {
		this.ngaySinhTxt = ngaySinhTxt;
	}
	public JTextField getsDTTxt() {
		return sDTTxt;
	}
	public void setsDTTxt(JTextField sDTTxt) {
		this.sDTTxt = sDTTxt;
	}
	public JTextField getEmailTxt() {
		return emailTxt;
	}
	public void setEmailTxt(JTextField emailTxt) {
		this.emailTxt = emailTxt;
	}
	public JButton getButtonThem() {
		return buttonThem;
	}
	public void setButtonThem(JButton buttonThem) {
		this.buttonThem = buttonThem;
	}
	public ThemGUI() {
//		setLocationRelativeTo(null);
		setLocation(564, 10);
		setUndecorated(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		setSize(400, 800);
		buidThemGUI();
		
	}
	private void buidThemGUI() {
		addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				requestFocus();
			}
		});
		
		addWindowFocusListener(new WindowAdapter() {
			@Override
			public void windowLostFocus(WindowEvent e) {
				requestFocus();
			}
		});
		
		wrapper = new JPanel();
		wrapper.setLayout(null);
		wrapper.setBackground(new Color(255, 255, 255, 0));
		add(wrapper);
		header = new JPanel();
		header.setLayout(null);
		header.setBackground(MainScreen.COLOR_MAIN);
		header.setBounds(0, 0, 400, 40);
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx = e.getX();
				xy = e.getY();
			}
		});
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - xx, y - xy - 100);
			}
		});
		exitLabel = new JLabel();
		exitLabel.setIcon(new ImageIcon(getClass().getResource("/gui/icon/multiply_20px.png")));
		exitLabel.setBounds(360, 0, 40, 40);
		exitLabel.setHorizontalAlignment(JLabel.CENTER);
		exitLabel.setOpaque(true);
		exitLabel.setBackground(MainScreen.COLOR_MAIN);
		exitLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitLabel.setBackground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitLabel.setBackground(MainScreen.COLOR_MAIN);
			}
		});
		header.add(exitLabel);
		
		wrapper.add(header);
		
		JLabel maLabel = new JLabel("Mã khách hàng: ");
		maLabel.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 14));
		maLabel.setBounds(10, 50, 120, 30);
		wrapper.add(maLabel);
		maTxt = new JTextField();
		maTxt.setBounds(130, 50, 260, 27);
		maTxt.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, MainScreen.COLOR_MAIN));
		maTxt.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 14));
		wrapper.add(maTxt);
		
		JLabel tenLabel = new JLabel("Tên khách hàng: ");
		tenLabel.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 14));
		tenLabel.setBounds(10, 90, 120, 30);
		wrapper.add(tenLabel);
		tenTxt = new JTextField();
		tenTxt.setBounds(130, 90, 260, 27);
		tenTxt.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 14));
		tenTxt.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, MainScreen.COLOR_MAIN));
		wrapper.add(tenTxt);
		
		JLabel ngaySinhLabel = new JLabel("Ngày sinh: ");
		ngaySinhLabel.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 14));
		ngaySinhLabel.setBounds(10, 130, 120, 30);
		wrapper.add(ngaySinhLabel);
		ngaySinhTxt = new JTextField();
		ngaySinhTxt.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 14));
		ngaySinhTxt.setBounds(130, 130, 260, 27);
		ngaySinhTxt.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, MainScreen.COLOR_MAIN));
		wrapper.add(ngaySinhTxt);
		
		JLabel sDTLabel = new JLabel("Số điện thoại: ");
		sDTLabel.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 14));
		sDTLabel.setBounds(10, 170, 120, 30);
		wrapper.add(sDTLabel);
		sDTTxt = new JTextField();
		sDTTxt.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 14));
		sDTTxt.setBounds(130, 170, 260, 27);
		sDTTxt.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, MainScreen.COLOR_MAIN));
		wrapper.add(sDTTxt);
		
		JLabel emailLabel = new JLabel("Email: ");
		emailLabel.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 14));
		emailLabel.setBounds(10, 210, 120, 30);
		wrapper.add(emailLabel);
		emailTxt = new JTextField();
		emailTxt.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 14));
		emailTxt.setBounds(130, 210, 260, 27);
		emailTxt.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, MainScreen.COLOR_MAIN));
		wrapper.add(emailTxt);
		
		buttonThem = new JButton("Thêm");
		buttonThem.setForeground(Color.WHITE);
		buttonThem.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 16));
		buttonThem.setBackground(MainScreen.COLOR_MAIN);
		buttonThem.setBounds(310, 550, 80, 40);
		wrapper.add(buttonThem);
		
		requestFocus();
	}
}
