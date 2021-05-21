package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.EventObject;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import connect.ConnectDB;
import dao.KhachHang_DAO_impl;
import entity.KhachHang;


public class KhachHang_Pane extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField timKiemTen;
	private JTable table;
	private DefaultTableModel tableModel;
	private KhachHang_DAO_impl kh_DAO;
	private ArrayList<KhachHang> dsKhachHang;
	private JButton buttonDauTrang;
	private JButton buttonLui;
	private JLabel pageNumber;
	private JButton buttonTien;
	private JButton buttonCuoiTrang;
	private JTextField timKiemMa;
	private JComboBox<String> cbGioiTinh;
	private JComboBox<String> cbDiaChi;
	
	public DefaultTableModel getTableModel() {
		return tableModel;
	}
	public void setTableModel(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
	}
	public KhachHang_Pane() {
		setBackground(Color.WHITE);
		setLayout(null);
		buidKhachHang();
	}
	/**
	 * 
	 */
	private void buidKhachHang() {
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KhachHang_Pane.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KhachHang_Pane.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KhachHang_Pane.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		try {
			ConnectDB.getInstance().connect();;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		kh_DAO = new KhachHang_DAO_impl();
		
		JLabel tieuDe = new JLabel();
		tieuDe.setText("Khách hàng");
		tieuDe.setFont(new Font(MainScreen.FONT_TEXT, Font.BOLD, 24));
		tieuDe.setForeground(MainScreen.COLOR_TEXT);
		tieuDe.setBounds(10, 10, 200, 50);
		add(tieuDe);
		
		timKiemMa = new JTextField() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				if(getText().length() > 0) {
					return;
				}
				Graphics2D g2d = (Graphics2D) g;
				g2d.setColor(Color.GRAY);
				g2d.setFont(new Font(MainScreen.FONT_TEXT, Font.ITALIC, 16));
				g2d.drawString("Nhập mã", getInsets().left, g.getFontMetrics().getMaxAscent() + getInsets().top);
			}
		};
		timKiemMa.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 16));
//		timKiemMa.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, MainScreen.COLOR_MAIN));
		timKiemMa.setBounds(10, 55, 500, 30);
		timKiemMa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				tableModel.setRowCount(0);
				pageNumber.setText("1");
				themVaoBang();
			}
		});
		add(timKiemMa);
		
		timKiemTen = new JTextField() {
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
				g.drawString("Nhập tên", getInsets().left, g.getFontMetrics().getMaxAscent() + getInsets().top);
			}
		};
		timKiemTen.requestFocus(false);
		timKiemTen.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 16));
		timKiemTen.setBounds(10, 100, 500, 30);
//		timKiemTen.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, MainScreen.COLOR_MAIN));
		timKiemTen.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				tableModel.setRowCount(0);
				pageNumber.setText("1");
				themVaoBang();
			}
		});
		add(timKiemTen);
		
		cbGioiTinh = new JComboBox<String>();
		cbGioiTinh.setFont(new Font(MainScreen.FONT_TEXT, Font.BOLD, 16));
		cbGioiTinh.addItem("<Tất cả>");
		cbGioiTinh.addItem("Nam");
		cbGioiTinh.addItem("Nữ");
		cbGioiTinh.setBounds(550, 55, 200, 30);
		cbGioiTinh.addActionListener(this);
		add(cbGioiTinh);
		
		DefaultComboBoxModel<String> cbDiaChiModel = new DefaultComboBoxModel<String>();
		cbDiaChiModel.addElement("<Tỉnh/TP>");
//		cbDiaChiModel.addAll(kh_DAO.getAllTinh());
		cbDiaChi = new JComboBox<String>();
		cbDiaChi.setFont(new Font(MainScreen.FONT_TEXT, Font.BOLD, 16));
		cbDiaChi.setModel(cbDiaChiModel);
		cbDiaChi.setBounds(550, 100, 200, 30);
		cbDiaChi.addActionListener(this);
		add(cbDiaChi);
		
		int[] columnWidth = {150, 210, 100, 100, 150, 255, 255};
        String[] columnNames = new String[] {"ID", "Tên KH", "Giới Tính", "Ngày sinh", "SDT", "Email", "DiaChi"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel) {
        	@Override
        	public boolean editCellAt(int row, int column, EventObject e) {
        		return false;
        	}
        };
        table.getTableHeader().setBackground(MainScreen.COLOR_MAIN);
        table.getTableHeader().setDefaultRenderer(new SimpleHeaderRenderer());
//        table.getTableHeader().setFont(new Font(MainScreen.FONT_TEXT, Font.BOLD, 16));
        table.getTableHeader().setResizingAllowed(false);
        table.getTableHeader().setReorderingAllowed(false);
        table.setFillsViewportHeight(true);
        table.setIntercellSpacing(new Dimension(0, 0));
        table.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 16));
        table.setShowGrid(false);
        table.setRowHeight(30);
        table.getTableHeader().setPreferredSize(new Dimension(1240, 30));
        
		for (int i = 0; i < columnWidth.length; i++) {
			TableColumn column = table.getColumnModel().getColumn(i);
			column.setMinWidth(columnWidth[i]);
			column.setMaxWidth(columnWidth[i]);
			column.setPreferredWidth(columnWidth[i]);
		}
		JScrollPane sp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sp.setBounds(10, 150, 1220, 450);
        sp.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, MainScreen.COLOR_MAIN));
        add(sp);
        
        buttonDauTrang = new JButton();
        buttonDauTrang.setIcon(new ImageIcon(getClass().getResource("/gui/icon/skip_to_start_24px.png")));
        buttonDauTrang.setBounds(440, 600, 40, 30);
        buttonDauTrang.setBackground(MainScreen.COLOR_MAIN);
        buttonDauTrang.addActionListener(this);
        add(buttonDauTrang);
        
        
        buttonLui = new JButton();
        buttonLui.setIcon(new ImageIcon(getClass().getResource("/gui/icon/rewind_24px.png")));
        buttonLui.setBounds(500, 600, 40, 30);
        buttonLui.setBackground(MainScreen.COLOR_MAIN);
        buttonLui.addActionListener(this);
        add(buttonLui);
        
        pageNumber = new JLabel("1", JLabel.CENTER);
        pageNumber.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 16));
        pageNumber.setBounds(570, 600, 30, 30);
        add(pageNumber);
        
        buttonTien = new JButton();
        buttonTien.setIcon(new ImageIcon(getClass().getResource("/gui/icon/fast_forward_24px.png")));
        buttonTien.setBounds(630, 600, 40, 30);
        buttonTien.setBackground(MainScreen.COLOR_MAIN);
        buttonTien.addActionListener(this);
        add(buttonTien);
        
        buttonCuoiTrang = new JButton();
        buttonCuoiTrang.setIcon(new ImageIcon(getClass().getResource("/gui/icon/end_24px.png")));
        buttonCuoiTrang.setBounds(690, 600, 40, 30);
        buttonCuoiTrang.setBackground(MainScreen.COLOR_MAIN);
        buttonCuoiTrang.addActionListener(this);
        add(buttonCuoiTrang);
        
//        themVaoBang();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int tongTrang = 1;
		String gioiTinh = "";
		int index = cbGioiTinh.getSelectedIndex();
		if(index == 1) {
			gioiTinh = "0";
		}
		else if(index == 2) {
			gioiTinh = "1";
		}
		int tongKhachHang = kh_DAO.tongKhachHang(timKiemMa.getText().trim(), timKiemTen.getText().trim(), gioiTinh);
		tongTrang = tongKhachHang % 20 == 0 ? tongKhachHang / 20 : (tongKhachHang / 20) + 1;
		Object o = e.getSource();
		if(o.equals(buttonTien)) {
			
			int page = Integer.parseInt(pageNumber.getText()) + 1;
	        if(page <= tongTrang) {
	        	tableModel.setRowCount(0);
	        	pageNumber.setText(Integer.toString(page));
	        	table.clearSelection();
	        	themVaoBang();
	        }
		}
		else if(o.equals(buttonLui)) {
			int page = Integer.parseInt(pageNumber.getText()) - 1;
			if(page > 0) {
				tableModel.setRowCount(0);
				pageNumber.setText(Integer.toString(page));
				table.clearSelection();
				themVaoBang();
			}
		}
		else if(o.equals(buttonCuoiTrang)) {
			int page = Integer.parseInt(pageNumber.getText());
			if(page != tongTrang) {
				tableModel.setRowCount(0);
				pageNumber.setText(Integer.toString(tongTrang));
				table.clearSelection();
				themVaoBang();
			}
		}
		else if(o.equals(buttonDauTrang)) {
			int page = Integer.parseInt(pageNumber.getText());
			if(page != 1) {
				tableModel.setRowCount(0);
				pageNumber.setText("1");
				table.clearSelection();
				themVaoBang();
			}
		}
		else if(o.equals(cbGioiTinh)) {
			tableModel.setRowCount(0);
			pageNumber.setText("1");
			themVaoBang();
		}
		else if(o.equals(cbDiaChi)) {
			tableModel.setRowCount(0);
			pageNumber.setText("1");
			themVaoBang();
		}
	}
	private void themVaoBang() {
		int page = Integer.parseInt(pageNumber.getText());
		String gioiTinh = "";
		int index = cbGioiTinh.getSelectedIndex();
		if(index == 1) {
			gioiTinh = "0";
		}
		else if(index == 2) {
			gioiTinh = "1";
		}
		
		dsKhachHang = kh_DAO.themVaoBang(page - 1, timKiemMa.getText().trim(), timKiemTen.getText().trim(), gioiTinh);
		for (KhachHang khachHang : dsKhachHang) {
			tableModel.addRow(new Object[] {khachHang.getMaKhachHang(), khachHang.getTenKhachHang(), khachHang.isGioiTinh() ? "Nữ":"Nam", khachHang.getNgaySinh(), khachHang.getSoDienThoai(), khachHang.getEmail(), khachHang.getDiaChi()});
		}
	}
}
