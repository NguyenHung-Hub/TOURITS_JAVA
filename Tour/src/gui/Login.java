package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dohuyhoang.animation.slideshowpane.SlideShowPane;

public class Login extends JFrame {
	private JTextField userTXT;
	public Login() {
		buidLogin();
	}
	private void buidLogin() {
		JPanel wrapper = new JPanel();
		wrapper.setBackground(new Color(68, 187, 182));
		wrapper.setLayout(null);
		
		JPanel rightPN = new JPanel();
		rightPN.setBounds(300, 0, 300, 350);
		rightPN.setBackground(new Color(68, 187, 182));
		rightPN.setLayout(null);
		JLabel userLabel = new JLabel();
		userLabel.setIcon(new ImageIcon(getClass().getResource("/gui/icon/icons8_user_20px.png")));
		userLabel.setBounds(30, 80, 30, 30);
		rightPN.add(userLabel);
		userTXT = new JTextField() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				if(getText().length() > 0) {
					return;
				}
				Graphics2D g2d = (Graphics2D)g;
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2d.setColor(Color.GRAY);
				g2d.setFont(new Font("Segoe ui", Font.ITALIC, 16));
				g.drawString("Tên đăng nhập", getInsets().left, g.getFontMetrics().getMaxAscent() + getInsets().top);
			}
			
		};
//		userTXT.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
		userTXT.setFont(new Font("Segoe ui", Font.PLAIN, 16));
		userTXT.requestFocus(false);
		userTXT.setBounds(60, 80, 200, 30);
		rightPN.add(userTXT);
		
		JLabel passLabel = new JLabel();
		passLabel.setIcon(new ImageIcon(getClass().getResource("/gui/icon/icons8_lock_20px.png")));
		passLabel.setBounds(30, 130, 30, 30);
		rightPN.add(passLabel);
		JPasswordField passTXT = new JPasswordField() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				if(getText().length() > 0) {
					return;
				}
				Graphics2D g2d = (Graphics2D)g;
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2d.setColor(Color.GRAY);
				g2d.setFont(new Font("Segoe ui", Font.ITALIC, 16));
				g.drawString("Mật khẩu", getInsets().left, g.getFontMetrics().getMaxAscent() + getInsets().top);
			}
		};
		passTXT.setOpaque(false);
		passTXT.setForeground(Color.BLACK);
//		passTXT.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
		passTXT.setFont(new Font("Segoe ui", Font.PLAIN, 16));
		passTXT.setBounds(60, 130, 200, 30);
		passTXT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Progress().setVisible(true);
				dispose();
			}
		});
		rightPN.add(passTXT);
		
		JCheckBox checkNhanVien = new JCheckBox("Nhân viên");
		checkNhanVien.setBounds(50, 160, 200, 30);
		checkNhanVien.setOpaque(false);
		checkNhanVien.setForeground(Color.WHITE);
		checkNhanVien.setFont(new Font("Segoe ui", Font.ITALIC, 12));
		rightPN.add(checkNhanVien);
		
		JButton buttonDangNhap = new JButton("Đăng nhập");
		buttonDangNhap.setFont(new Font("Segoe ui", Font.PLAIN, 14));
		buttonDangNhap.setForeground(Color.WHITE);
		buttonDangNhap.setFocusPainted(false);
		buttonDangNhap.setBounds(30, 220, 110, 40);
		buttonDangNhap.setBackground(new Color(68, 71, 90));
		buttonDangNhap.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(checkNhanVien.isSelected()) {
					new Progress().setVisible(true);
					dispose();
				}
			}
		});
		rightPN.add(buttonDangNhap);
		
		JButton buttonDangKy = new JButton("Đăng ký");
		buttonDangKy.setFont(new Font("Segoe ui", Font.PLAIN, 14));
		buttonDangKy.setForeground(Color.WHITE);
		buttonDangKy.setFocusPainted(false);
		buttonDangKy.setBounds(150, 220, 110, 40);
		buttonDangKy.setBackground(new Color(68, 71, 90));
		buttonDangKy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 new SignIn().setVisible(true);
				 dispose();
			}
		});
		rightPN.add(buttonDangKy);
		
		wrapper.add(rightPN);
		
		String[] listPath = {
				"/gui/img/picture.jpg",
				"/gui/img/picture2.jpg",
				"/gui/img/picture3.jpg",
				"/gui/img/picture4.jpeg",
				"/gui/img/picture5.png",
				"/gui/img/picture6.jpg",
		};
		String[] listTitle = {
			"Chào Mừng các bạn",
			"Xin Chào",
			"Hello",
			"Ha",
			"sdfa",
			"sahdfsd"
		};
		SlideShowPane slideShowPane = new SlideShowPane(listPath, 2000, 1000, new Rectangle(0, 0, 300, 350), listTitle);
		slideShowPane.start();
		slideShowPane.setBackground(new Color(68, 187, 182));
		slideShowPane.getPanels().get(2).setForeground(Color.BLACK);
		JLabel title = new JLabel("TRAVEL");
		title.setFont(new Font("Segoe ui", Font.BOLD, 18));
		title.setForeground(Color.WHITE);
		title.setBounds(10, 20, 100, 30);
		slideShowPane.add(title);
		slideShowPane.setBounds(0, 0, 300, 350);
		wrapper.add(slideShowPane);
		
		
		
		
		
		GroupLayout wrapperLayout = new GroupLayout(wrapper);
		wrapper.setLayout(wrapperLayout);
		wrapperLayout.setHorizontalGroup(
			wrapperLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGap(0, 600, Short.MAX_VALUE)
		);
		wrapperLayout.setVerticalGroup(
			wrapperLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGap(0, 350, Short.MAX_VALUE)
		);
		setContentPane(wrapper);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new Login().setVisible(true);
			}
		});
	}
}