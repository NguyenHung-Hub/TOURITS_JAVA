package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.DateFormatter;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import connect.ConnectDB;
import dao.DiaChi_DAO;
import dao.KhachHang_DAO;
import entity.DiaChi;
import entity.KhachHang;

public class SignIn extends JFrame implements ActionListener {
	private JButton buttonHuy;
	private KhachHang_DAO kh_DAO;
	private JButton buttonDangKy;
	private JTextField hoTenTextField;
	private JComboBox<String> gioiTinhComboBox;
	private JDateChooser ngaySinhChooser;
	private JTextField sDTTextField;
	private JTextField emailTextField;
	private JComboBox<String> tinhThanhComboBox;
	private JComboBox<String> quanHuyenComboBox;
	private JComboBox<String> phuongXaComboBox;
	private JPasswordField matKhauField;
	private JPasswordField nhapLaiMKField;
	private DefaultComboBoxModel<String> tinhThanhComboBoxModel;
	private DefaultComboBoxModel<String> quanHuyenComboBoxModel;
	private DefaultComboBoxModel<String> phuongXaComboBoxModel;
	public SignIn() {
		buidSignIn();
	}
	private void buidSignIn() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		kh_DAO = new KhachHang_DAO();
		
		JPanel wrapper = new JPanel();
		wrapper.setBackground(new Color(68, 187, 182));
		wrapper.setLayout(null);
		
		JLabel title = new JLabel("????NG K?? T??I KHO???N", JLabel.CENTER);
		title.setFont(new Font(MainScreen.FONT_TEXT, Font.BOLD, 30));
		title.setForeground(Color.WHITE);
		title.setBackground(new Color(68, 71, 90));
		title.setOpaque(true);
		title.setBounds(0, 0, 900, 80);
		wrapper.add(title);
		
		JLabel hoTenLabel = new JLabel("H??? t??n (*): ");
		hoTenLabel.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 16));
		hoTenLabel.setForeground(Color.WHITE);
		hoTenLabel.setBounds(10, 85, 100, 30);
		wrapper.add(hoTenLabel);
		
		hoTenTextField = new JTextField();
		hoTenTextField.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 16));
		hoTenTextField.setBounds(110, 85, 300, 30);
		wrapper.add(hoTenTextField);
		
		JLabel gioiTinhLabel = new JLabel("Gi???i t??nh (*): ");
		gioiTinhLabel.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 16));
		gioiTinhLabel.setForeground(Color.WHITE);
		gioiTinhLabel.setBounds(450, 85, 100, 30);
		wrapper.add(gioiTinhLabel);
		
		gioiTinhComboBox = new JComboBox<String>();
		gioiTinhComboBox.addItem("Nam");
		gioiTinhComboBox.addItem("N???");
		gioiTinhComboBox.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 16));
		gioiTinhComboBox.setBounds(580, 85, 300, 30);
		wrapper.add(gioiTinhComboBox);
		
		JLabel ngaySinhLabel = new JLabel("Ng??y sinh (*): ");
		ngaySinhLabel.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 16));
		ngaySinhLabel.setForeground(Color.WHITE);
		ngaySinhLabel.setBounds(10, 120, 100, 30);
		wrapper.add(ngaySinhLabel);
		
		String dd = LocalDate.now().toString();


		Date date;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(dd);
			ngaySinhChooser = new JDateChooser();
			ngaySinhChooser.setBounds(110, 120, 300, 30);
			ngaySinhChooser.setDate(date);
			ngaySinhChooser.setDateFormatString("dd/MM/yyyy");
			ngaySinhChooser.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 16));
			ngaySinhChooser.setBackground(new Color(68, 187, 182));
			wrapper.add(ngaySinhChooser);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel sDTLabel = new JLabel("S??? ??i???n tho???i (*):");
		sDTLabel.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 16));
		sDTLabel.setForeground(Color.WHITE);
		sDTLabel.setBounds(450, 120, 120, 30);
		wrapper.add(sDTLabel);
		
		sDTTextField = new JTextField();
		sDTTextField.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 16));
		sDTTextField.setBounds(580, 120, 300, 30);
		wrapper.add(sDTTextField);
		
		JLabel emailLabel = new JLabel("Email: ");
		emailLabel.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 16));
		emailLabel.setForeground(Color.WHITE);
		emailLabel.setBounds(10, 155, 100, 30);
		wrapper.add(emailLabel);
		
		emailTextField = new JTextField();
		emailTextField.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 16));
		emailTextField.setBounds(110, 155, 300, 30);
		wrapper.add(emailTextField);
		
		JLabel diaChiLabel = new JLabel("?????a ch??? (*): ");
		diaChiLabel.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 16));
		diaChiLabel.setForeground(Color.WHITE);
		diaChiLabel.setBounds(10, 190, 100, 30);
		wrapper.add(diaChiLabel);
		
		tinhThanhComboBoxModel = new DefaultComboBoxModel<String>();
		tinhThanhComboBoxModel.addElement("<T???nh/Th??nh>");
		tinhThanhComboBoxModel.addAll(DiaChi_DAO.getAllTinh());
		tinhThanhComboBox = new JComboBox<String>(tinhThanhComboBoxModel);
		tinhThanhComboBox.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 16));
		tinhThanhComboBox.setBounds(110, 190, 300, 30);
		wrapper.add(tinhThanhComboBox);
		
		quanHuyenComboBoxModel = new DefaultComboBoxModel<String>();
		quanHuyenComboBoxModel.addElement("<Qu???n/Huy???n>");
		quanHuyenComboBox = new JComboBox<String>(quanHuyenComboBoxModel);
		quanHuyenComboBox.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 16));
		quanHuyenComboBox.setBounds(430, 190, 230, 30);
		wrapper.add(quanHuyenComboBox);
		
		phuongXaComboBoxModel = new DefaultComboBoxModel<String>();
		phuongXaComboBoxModel.addElement("<Ph?????ng/X??>");
		phuongXaComboBox = new JComboBox<String>(phuongXaComboBoxModel);
		phuongXaComboBox.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 16));
		phuongXaComboBox.setBounds(680, 190, 200, 30);
		wrapper.add(phuongXaComboBox);
		
		JLabel matKhauLabel = new JLabel("M???t kh???u (*): ");
		matKhauLabel.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 16));
		matKhauLabel.setForeground(Color.WHITE);
		matKhauLabel.setBounds(10, 225, 100, 30);
		wrapper.add(matKhauLabel);
		
		matKhauField = new JPasswordField();
		matKhauField.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 16));
		matKhauField.setBounds(110, 225, 300, 30);
		wrapper.add(matKhauField);
		
		JLabel nhapLaiMKLabel = new JLabel("Nh???p l???i m???t kh???u:");
		nhapLaiMKLabel.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 16));
		nhapLaiMKLabel.setForeground(Color.WHITE);
		nhapLaiMKLabel.setBounds(450, 225, 140, 30);
		wrapper.add(nhapLaiMKLabel);
		
		nhapLaiMKField = new JPasswordField();
		nhapLaiMKField.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 16));
		nhapLaiMKField.setBounds(580, 225, 300, 30);
		wrapper.add(nhapLaiMKField);
		
		buttonHuy = new JButton("H???y");
		buttonHuy.setBackground(new Color(68, 71, 90));
		buttonHuy.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 16));
		buttonHuy.setForeground(Color.WHITE);
		buttonHuy.setBounds(340, 440, 100, 40);
		wrapper.add(buttonHuy);
		
		buttonDangKy = new JButton("????ng k??");
		buttonDangKy.setBackground(new Color(68, 71, 90));
		buttonDangKy.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 16));
		buttonDangKy.setForeground(Color.WHITE);
		buttonDangKy.setBounds(460, 440, 100, 40);
		wrapper.add(buttonDangKy);
		
		GroupLayout wrapperLayout = new GroupLayout(wrapper);
		wrapper.setLayout(wrapperLayout);
		wrapperLayout.setHorizontalGroup(
			wrapperLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGap(0, 900, Short.MAX_VALUE)
		);
		wrapperLayout.setVerticalGroup(
			wrapperLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGap(0, 500, Short.MAX_VALUE)
		);
		setContentPane(wrapper);
		pack();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
				new Login().setVisible(true);
			}
		});
		tinhThanhComboBox.addActionListener(this);
		quanHuyenComboBox.addActionListener(this);
		quanHuyenComboBox.addActionListener(this);
		buttonHuy.addActionListener(this);
		buttonDangKy.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(tinhThanhComboBox)) {
			quanHuyenComboBoxModel.addAll(DiaChi_DAO.getQuanHuyenTheoTinh(tinhThanhComboBox.getSelectedItem().toString()));
		}
		else if(o.equals(quanHuyenComboBox)) {
			phuongXaComboBoxModel.addAll(DiaChi_DAO.getPhuongXaTheoQuanHuyenVaTinh(tinhThanhComboBox.getSelectedItem().toString(), quanHuyenComboBox.getSelectedItem().toString()));
		}
		else if(o.equals(buttonHuy)) {
			dispose();
			new Login().setVisible(true);
		}
		else if(o.equals(buttonDangKy)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			KhachHang khachHang = new KhachHang();
			khachHang.setMaKhachHang("");
			khachHang.setTenKhachHang(hoTenTextField.getText().trim());
			khachHang.setGioiTinh(gioiTinhComboBox.getSelectedItem().equals("N???") ? true:false);
			khachHang.setNgaySinh(java.sql.Date.valueOf(sdf.format(ngaySinhChooser.getDate())));
			khachHang.setDiaChi(DiaChi_DAO.getDiaChi(tinhThanhComboBoxModel.getSelectedItem().toString(), quanHuyenComboBoxModel.getSelectedItem().toString(), phuongXaComboBoxModel.getSelectedItem().toString()));
			khachHang.setSoDienThoai(sDTTextField.getText().trim());
			khachHang.setEmail(emailTextField.getText().trim());
			khachHang.setMatKhau(nhapLaiMKField.getText());
			if(kh_DAO.insertKhachHang(khachHang)) {
				JOptionPane.showMessageDialog(null, "Th??m th??nh c??ng");
			}
			else {
				JOptionPane.showMessageDialog(null, "Th??m kh??ng th??nh c??ng!");
			}
			dispose();
			new Login().setVisible(true);
		}
	}
}