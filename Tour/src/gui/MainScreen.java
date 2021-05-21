package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.Timer;

import dohuyhoang.animation.AnimationPane;
import dohuyhoang.animation.AnimationPaneColor;
import dohuyhoang.animation.roundedpane.RoundedPane;

public class MainScreen extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Color COLOR_MAIN = new Color(0, 0, 0);
	static Color COLOR_TEXT = new Color(0, 0, 0);
	static Color COLOR_SUB_TEXT = new Color(12829635);
	static Color BACKGROUND_COLOR = new Color(223, 219, 224);
	static Color COLOR_PN = Color.WHITE;
	static String FONT_TEXT = "Segoe ui";
	private final int radius = 10;
	private JPanel wrapper;
	private JPanel shadowBlack;
	private TrangChu_Pane trangchu;
	private CaiDat_Pane caiDat;
	private int xx;
	private int xy;
	private KhachHang_Pane khachHang;
	private ChuyenDi_Pane chuyenDi;
	private Message message;
	private ThemGUI themGUI;
	private JScrollPane sp;

	public MainScreen() {
		setUndecorated(true);
		setLayout(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
		setLocation(120, 10);
		requestFocus();
		buidMainScreen();
	}

	private void buidMainScreen() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		wrapper = new RoundedPane(radius);
		wrapper.setOpaque(false);
		wrapper.setBackground(BACKGROUND_COLOR);
		wrapper.setLayout(null);
		
		Nav nav = new Nav(radius, "right");
		nav.setBounds(0, 0, 60, 800);
		nav.getMenuBtn().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(!(message.isVisible() || themGUI.isVisible())) {
					if(nav.getWidth() == 60) {
							AnimationPane animation = new AnimationPane(nav, new Rectangle(nav.getX(), nav.getY(), 60, nav.getHeight()), new Rectangle(nav.getX(), nav.getY(), 200, nav.getHeight()));
							animation.start();
							shadowBlack.setVisible(true);
							AnimationPane animation2 = new AnimationPane(nav.getMenuBtn(), new Rectangle(-115, 0, 200, 50), new Rectangle(20, 0, 200, 50));
							animation2.start();
							setComponentZOrder(nav, 0);
					}
					else {
						AnimationPane animation = new AnimationPane(nav, new Rectangle(nav.getX(), nav.getY(), 200, nav.getHeight()), new Rectangle(nav.getX(), nav.getY(), 60, nav.getHeight()));
						animation.start();
						shadowBlack.setVisible(false);
						AnimationPane animation2 = new AnimationPane(nav.getMenuBtn(), new Rectangle(20, 0, 200, 50), new Rectangle(-115, 0, 200, 50));
						animation2.start();
					}
				}
			}
		});
		wrapper.add(nav);
		
		
		
		shadowBlack = new RoundedPane(radius);
		shadowBlack.setOpaque(false);
		shadowBlack.setBackground(new Color(0, 0, 0, 0.3f));
		shadowBlack.setVisible(false);
		shadowBlack.setBounds(0, 0, 1300, 800);
		shadowBlack.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(!(message.isVisible() || themGUI.isVisible())) {
					AnimationPane animation = new AnimationPane(nav, new Rectangle(nav.getX(), nav.getY(), 200, nav.getHeight()), new Rectangle(nav.getX(), nav.getY(), 60, nav.getHeight()));
					animation.start();
					shadowBlack.setVisible(false);
					AnimationPane animation2 = new AnimationPane(nav.getMenuBtn(), new Rectangle(20, 0, 200, 50), new Rectangle(-115, 0, 200, 50));
					animation2.start();
				}
			}
		});
		wrapper.add(shadowBlack);
		
		Header header = new Header(radius, "bottom");
		header.setBounds(0, 0, 1300, 60);
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
				setLocation(x - xx, y - xy);
			}
		});
		message = new Message();
		header.getExitPanel().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				message.getWrapper().setBounds(new Rectangle());
				shadowBlack.setVisible(true);
				message.setVisible(true);
				AnimationPane animation = new AnimationPane(message.getWrapper(), new Rectangle(0, 0, 400, 200), new Rectangle(0, 100, 400, 200));
				AnimationPaneColor animationColor = new AnimationPaneColor(message.getWrapper(), MainScreen.COLOR_PN);
				animationColor.start();
				animation.start();
				message.setLocationRelativeTo(null);
			}
		});
		message.getButtonExit().addMouseListener(new MouseAdapter() {
			private Timer tm;

			@Override
			public void mousePressed(MouseEvent e) {
				AnimationPane animationPane = new AnimationPane(message.getWrapper(), new Rectangle(0, 100, 400, 200), new Rectangle(0, 200, 400, 200));
				animationPane.start();
				AnimationPaneColor animationPaneColor = new AnimationPaneColor(message.getWrapper(), new Color(255, 255, 255, 0));
				animationPaneColor.start();
				tm =new Timer(200, new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						shadowBlack.setVisible(false);
						message.dispose();
						message.invalidate();
						requestFocus();
						tm.stop();
						message.getWrapper().setLocation(0, 0);
						message.getWrapper().repaint();
					}
				});
				tm.start();
			}
		});
		message.getButtonCancle().addMouseListener(new MouseAdapter() {
			private Timer tm;
			@Override
			public void mousePressed(MouseEvent e) {
				AnimationPane animationPane = new AnimationPane(message.getWrapper(), new Rectangle(0, 100, 400, 200), new Rectangle(0, 200, 400, 200));
				animationPane.start();
				AnimationPaneColor animationPaneColor = new AnimationPaneColor(message.getWrapper(), new Color(255, 255, 255, 0));
				animationPaneColor.start();
				tm =new Timer(200, new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						shadowBlack.setVisible(false);
						message.dispose();
						message.invalidate();
						requestFocus();
						tm.stop();
						message.getWrapper().setLocation(0, 0);
						message.getWrapper().repaint();
					}
				});
				tm.start();
			}
		});
		wrapper.add(header);
		
		
		trangchu = new TrangChu_Pane();
//		trangchu.setBounds(60, 100, 1240, 680);
		nav.getTrangChuBtn().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				khachHang.setVisible(false);
				chuyenDi.setVisible(false);
				caiDat.setVisible(false);
//				trangchu.setVisible(true);
				sp.setVisible(true);
			}
		});
		trangchu.setPreferredSize(new Dimension(1210, 1000));
		sp = new JScrollPane(trangchu, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setBounds(60, 100, 1240, 680);
//		sp.set
		wrapper.add(sp);
		
		themGUI = new ThemGUI();
		
		khachHang = new KhachHang_Pane();
		khachHang.setVisible(false);
		khachHang.setBounds(60, 100, 1240, 680);
		nav.getKhachHangBtn().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
//				trangchu.setVisible(false);
				sp.setVisible(false);
				chuyenDi.setVisible(false);
				caiDat.setVisible(false);
				khachHang.setVisible(true);
			}
		});
//		khachHang.getButtonThem().addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				themGUI.setLocationRelativeTo(null);
//				shadowBlack.setVisible(true);
//				themGUI.setVisible(true);
//				AnimationPane animation = new AnimationPane(themGUI.getWrapper(), new Rectangle(0, 0, 400, 600), new Rectangle(0, 100, 400, 600));
//				AnimationPaneColor animationColor = new AnimationPaneColor(themGUI.getWrapper(), MainScreen.COLOR_PN);
//				animation.start();
//				animationColor.start();
//			}
//		});
//		themGUI.getExitLabel().addMouseListener(new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent e) {
//				themGUI.dispose();
//				themGUI.getWrapper().setBounds(0, 0, 400, 600);
//				themGUI.invalidate();
//				themGUI.getExitLabel().setBackground(MainScreen.COLOR_MAIN);
//				shadowBlack.setVisible(false);
//				themGUI.getWrapper().setBackground(new Color(255, 255, 255, 0));
//			}
//		});
//		themGUI.getButtonThem().addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				khachHang.getTableModel().addRow(new Object[] {themGUI.getMaTxt().getText(), themGUI.getTenTxt().getText(),
//					themGUI.getNgaySinhTxt().getText(), themGUI.getsDTTxt().getText(), themGUI.getEmailTxt().getText()
//				});
//				themGUI.getMaTxt().setText("");
//				themGUI.getTenTxt().setText("");
//				themGUI.getNgaySinhTxt().setText("");
//				themGUI.getsDTTxt().setText("");
//				themGUI.getEmailTxt().setText("");
//				themGUI.dispose();
//				themGUI.invalidate();
//				shadowBlack.setVisible(false);
//				themGUI.getWrapper().setBounds(0, 0, 400, 600);
//				themGUI.getWrapper().setBackground(new Color(255, 255, 255, 0));
//			}
//		});
//		themGUI.getEmailTxt().addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				khachHang.getTableModel().addRow(new Object[] {themGUI.getMaTxt().getText(), themGUI.getTenTxt().getText(),
//						themGUI.getNgaySinhTxt().getText(), themGUI.getsDTTxt().getText(), themGUI.getEmailTxt().getText()
//					});
//					themGUI.getMaTxt().setText("");
//					themGUI.getTenTxt().setText("");
//					themGUI.getNgaySinhTxt().setText("");
//					themGUI.getsDTTxt().setText("");
//					themGUI.getEmailTxt().setText("");
//					themGUI.dispose();
//					themGUI.invalidate();
//					shadowBlack.setVisible(false);
//					themGUI.getWrapper().setBounds(0, 0, 400, 600);
//					themGUI.getWrapper().setBackground(new Color(255, 255, 255, 0));
//			}
//		});
		wrapper.add(khachHang);
		
		chuyenDi = new ChuyenDi_Pane();
		chuyenDi.setVisible(false);
		chuyenDi.setBounds(60, 100, 1240, 680);
		nav.getTourBtn().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
//				trangchu.setVisible(false);
				sp.setVisible(false);
				khachHang.setVisible(false);
				caiDat.setVisible(false);
				chuyenDi.setVisible(true);
			}
		});
		wrapper.add(chuyenDi);
		
		caiDat = new CaiDat_Pane();
		caiDat.setBounds(80, 70, 1200, 710);
		caiDat.setVisible(false);
		nav.getCaiDatBtn().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
//				trangchu.setVisible(false);
				sp.setVisible(false);
				khachHang.setVisible(false);
				chuyenDi.setVisible(false);
				caiDat.setVisible(true);
			}
		});
		wrapper.add(caiDat);
		
		// Create wrapper layout
		GroupLayout wrapperLayout = new GroupLayout(wrapper);
		wrapper.setLayout(wrapperLayout);
		wrapperLayout.setHorizontalGroup(
				wrapperLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1300, Short.MAX_VALUE));
		wrapperLayout.setVerticalGroup(
				wrapperLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 800, Short.MAX_VALUE));
		setContentPane(wrapper);
		pack();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				message.getWrapper().setBounds(new Rectangle());
				shadowBlack.setVisible(true);
				message.setVisible(true);
				AnimationPane animation = new AnimationPane(message.getWrapper(), new Rectangle(0, 0, 400, 200), new Rectangle(0, 100, 400, 200));
				AnimationPaneColor animationColor = new AnimationPaneColor(message.getWrapper(), MainScreen.COLOR_PN);
				animationColor.start();
				animation.start();
				message.setLocationRelativeTo(null);
			}
		});
	}
}

