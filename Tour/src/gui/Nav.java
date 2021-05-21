package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dohuyhoang.animation.AnimationPane;
import dohuyhoang.animation.roundedpane.RoundedPane;

public class Nav extends RoundedPane {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel menuIcon;
	private JLabel trangChuLbl;
	private JPanel trangChuBar;
	private JPanel trangChuBtn;
	private JLabel khachHangLbl;
	private JPanel khachHangBtn;
	private JLabel tourLbl;
	private JPanel tourBtn;
	private JLabel caiDatLbl;
	private JPanel caiDatBtn;
	private JPanel menuBtn;
	private RoundedPane selectPanel;
	
	public JLabel getMenuIcon() {
		return menuIcon;
	}

	public JLabel getTrangChuLbl() {
		return trangChuLbl;
	}

	public JPanel getTrangChuBtn() {
		return trangChuBtn;
	}

	public JLabel getKhachHangLbl() {
		return khachHangLbl;
	}

	public JPanel getKhachHangBtn() {
		return khachHangBtn;
	}

	public JLabel getTourLbl() {
		return tourLbl;
	}

	public JPanel getTourBtn() {
		return tourBtn;
	}

	public JPanel getTrangChuBar() {
		return trangChuBar;
	}

	public JLabel getCaiDatLbl() {
		return caiDatLbl;
	}

	public JPanel getCaiDatBtn() {
		return caiDatBtn;
	}

	public JPanel getMenuBtn() {
		return menuBtn;
	}

	public Nav(int radius, String direction) {
		super(radius, direction);
		setBackground(MainScreen.COLOR_MAIN);
		setOpaque(false);
		setLayout(null);
		buidNav();
	}
	
	private void buidNav() {
		
		menuIcon = new JLabel();
		menuIcon.setText("MENU");
		menuIcon.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 14));
		menuIcon.setIcon(new ImageIcon(getClass().getResource("/gui/icon/menu_20px.png")));
		menuIcon.setIconTextGap(100);
		menuIcon.setForeground(Color.WHITE);
		menuIcon.setHorizontalTextPosition(JLabel.LEFT);
		menuIcon.setBounds(0, 0, 200, 50);
		menuBtn = new JPanel();
		menuBtn.setOpaque(false);
//		menuBtn.setBackground(MainScreen.COLOR_MAIN);
		menuBtn.setLayout(null);
		menuBtn.setBounds(-115, 0, 200, 50);
		menuBtn.add(menuIcon);
		menuBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(menuBtn);
		
		
		
		trangChuLbl = new JLabel();
		trangChuLbl.setText("Trang chủ");
		trangChuLbl.setIcon(new ImageIcon(getClass().getResource("/gui/icon/home_30-1px.png")));
		trangChuLbl.setIconTextGap(20);
		trangChuLbl.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 18));
		trangChuLbl.setForeground(Color.BLACK);
		trangChuLbl.setBounds(15, 10, 200, 40);
		trangChuBtn = new JPanel();
		trangChuBtn.setOpaque(false);
		trangChuBtn.setLayout(null);
		trangChuBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		trangChuBtn.setBackground(MainScreen.COLOR_MAIN);
		trangChuBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnMousePressed(e,
						trangChuLbl,
						"/gui/icon/home_30-1px.png",
						new JLabel[] {khachHangLbl, tourLbl, caiDatLbl},
						new String[] {"/gui/icon/customer_30px.png",
								"/gui/icon/earth_planet_30px-1.png",
								"/gui/icon/settings_30px.png"},
						new Rectangle(selectPanel.getX(), selectPanel.getY(), 230, 60),
						new Rectangle(selectPanel.getX(), 100, 230, 60));
			}
		});
		trangChuBtn.add(trangChuLbl);
		
		khachHangLbl = new JLabel();
		khachHangLbl.setText("Khách hàng");
		khachHangLbl.setIcon(new ImageIcon(getClass().getResource("/gui/icon/customer_30px.png")));
		khachHangLbl.setIconTextGap(20);
		khachHangLbl.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 18));
		khachHangLbl.setForeground(Color.WHITE);
		khachHangLbl.setBounds(15, 10, 200, 40);
		khachHangBtn = new JPanel();
		khachHangBtn.setOpaque(false);
		khachHangBtn.setLayout(null);
		khachHangBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		khachHangBtn.setBackground(MainScreen.COLOR_MAIN);
		khachHangBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnMousePressed(e,
						khachHangLbl,
						"/gui/icon/customer_30px-1.png",
						new JLabel[] {trangChuLbl, tourLbl, caiDatLbl},
						new String[] {"/gui/icon/home_30px.png",
								"/gui/icon/earth_planet_30px-1.png",
								"/gui/icon/settings_30px.png"},
						new Rectangle(selectPanel.getX(), selectPanel.getY(), 230, 60),
						new Rectangle(selectPanel.getX(), 160, 230, 60));
			}
		});
		khachHangBtn.add(khachHangLbl);
		
		tourLbl = new JLabel();
		tourLbl.setText("Chuyến đi");
		tourLbl.setIcon(new ImageIcon(getClass().getResource("/gui/icon/earth_planet_30px-1.png")));
		tourLbl.setIconTextGap(20);
		tourLbl.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 18));
		tourLbl.setForeground(Color.WHITE);
		tourLbl.setBounds(15, 10, 200, 40);
		tourBtn = new JPanel();
		tourBtn.setLayout(null);
		tourBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		tourBtn.setOpaque(false);
		tourBtn.setBackground(MainScreen.COLOR_MAIN);
		tourBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnMousePressed(e,
						tourLbl,
						"/gui/icon/earth_planet_30px.png",
						new JLabel[] {trangChuLbl, khachHangLbl, caiDatLbl},
						new String[] {"/gui/icon/home_30px.png",
								"/gui/icon/customer_30px.png",
								"/gui/icon/settings_30px.png"},
						new Rectangle(selectPanel.getX(), selectPanel.getY(), 230, 60),
						new Rectangle(selectPanel.getX(), tourBtn.getY(), 230, 60));
			}
		});
		tourBtn.add(tourLbl);
		
		caiDatLbl = new JLabel();
		caiDatLbl.setText("Cài đặt");
		caiDatLbl.setIcon(new ImageIcon(getClass().getResource("/gui/icon/settings_30px.png")));
		caiDatLbl.setIconTextGap(20);
		caiDatLbl.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 18));
		caiDatLbl.setForeground(Color.WHITE);
		caiDatLbl.setBounds(15, 10, 200, 40);
		caiDatBtn = new JPanel();
		caiDatBtn.setOpaque(false);
		caiDatBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		caiDatBtn.setLayout(null);
		caiDatBtn.setBackground(MainScreen.COLOR_MAIN);
		caiDatBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnMousePressed(e,
						caiDatLbl,
						"/gui/icon/settings_30px-1.png",
						new JLabel[] {trangChuLbl, khachHangLbl, tourLbl},
						new String[] {"/gui/icon/home_30px.png",
								"/gui/icon/customer_30px.png",
								"/gui/icon/earth_planet_30px-1.png"},
						new Rectangle(selectPanel.getX(), selectPanel.getY(), 230, 60),
						new Rectangle(selectPanel.getX(), caiDatBtn.getY(), 230, 60));
			}
		});
		caiDatBtn.add(caiDatLbl);
		
		trangChuBtn.setBounds(0, 100, 200, 60);
		add(trangChuBtn);
		
		khachHangBtn.setBounds(0, 160, 200, 60);
		add(khachHangBtn);
		
		tourBtn.setBounds(0, 220, 200, 60);
		add(tourBtn);
		
		caiDatBtn.setBounds(0, 740, 200, 60);
		add(caiDatBtn);
		
		selectPanel = new RoundedPane(50);
		selectPanel.setBackground(new Color(255, 255, 255)); 
		selectPanel.setOpaque(false);
		selectPanel.setBounds(5, 100, 230, 60);
		add(selectPanel);
		
	}
	
	private void setColor(JLabel lbl, String path) {
		lbl.setIcon(new ImageIcon(getClass().getResource(path)));
		lbl.setForeground(Color.BLACK);
	}
	private void resetColor(JLabel [] labels, String [] paths) {
		for(int i = 0; i < labels.length; i++) {
			labels[i].setIcon(new ImageIcon(getClass().getResource(paths[i])));
			labels[i].setForeground(Color.WHITE);
		}
	}
	private void btnMousePressed(MouseEvent e, JLabel lbl, String path, JLabel[] labels, String [] paths, Rectangle from, Rectangle to) {
		AnimationPane animation = new AnimationPane(selectPanel, from, to);
		animation.start();
		setColor(lbl, path);
		resetColor(labels, paths);
	}
}
