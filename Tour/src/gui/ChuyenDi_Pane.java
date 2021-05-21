package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.EventObject;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import connect.ConnectDB;
import dao.ChuyenDi_Dao_impl;
import entity.ChuyenDi;

public class ChuyenDi_Pane extends JPanel {
	private JLabel tieuDe;
	private ChuyenDi_Dao_impl cd_DAO;
	private ArrayList<ChuyenDi> dsChuyenDi;
	private JLabel anhChuyenDi;
	private JLabel tenChuyenDi;
	public ChuyenDi_Pane() {
		setBackground(Color.WHITE);
		setLayout(null);
		buidChuyenDi();
	}
	private void buidChuyenDi() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		cd_DAO = new ChuyenDi_Dao_impl();
		
		tieuDe = new JLabel();
		tieuDe.setText("Tour");
		tieuDe.setFont(new Font(MainScreen.FONT_TEXT, Font.BOLD, 24));
		tieuDe.setForeground(MainScreen.COLOR_TEXT);
		tieuDe.setBounds(10, 10, 200, 50);
//		add(tieuDe);
		
		String[] columnTitle = {"Mã chuyến", "Tên chuyến", "Ngày khởi hành", "Ngày kết thúc"}; 
		DefaultTableModel tableModel = new DefaultTableModel(columnTitle, 0);
		JTable table = new JTable(tableModel) {;
			@Override
			public boolean editCellAt(int row, int column, EventObject e) {
				return false;
			}
		};
		table.getTableHeader().setDefaultRenderer(new SimpleHeaderRenderer());
		table.setFont(new Font(MainScreen.FONT_TEXT, Font.PLAIN, 16));
		table.getTableHeader().setBackground(MainScreen.COLOR_MAIN);
		table.getTableHeader().setPreferredSize(new Dimension(1220, 30));
		table.getTableHeader().setResizingAllowed(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.setFillsViewportHeight(true);
		table.setIntercellSpacing(new Dimension(0, 0));
		table.setShowGrid(false);
		table.setRowHeight(30);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ChuyenDi chuyenDi = cd_DAO.getChuyenDi(table.getValueAt(table.getSelectedRow(), 0).toString());
				anhChuyenDi.setIcon(new ImageIcon(chuyenDi.getAnh()));
				tenChuyenDi.setText(chuyenDi.getTenChuyenDi());
			}
		});
		JScrollPane sp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setBounds(610, 10, 600, 450);
//		sp.setBorder(BorderFactory.createMatteBorder(0, 5, 5, 5, MainScreen.COLOR_MAIN));
		add(sp);
			
		anhChuyenDi = new JLabel();
		anhChuyenDi.setBounds(10, 10, 600, 300);
		add(anhChuyenDi);
		
		tenChuyenDi = new JLabel();
		tenChuyenDi.setBounds(10, 310, 200, 50);
		tenChuyenDi.setFont(new Font(MainScreen.FONT_TEXT, Font.BOLD, 24));
		add(tenChuyenDi);
		
//		dsChuyenDi = cd_DAO.getAllChuyenDi();
//		for (ChuyenDi chuyenDi : dsChuyenDi) {
//			tableModel.addRow(new Object[] {
//					chuyenDi.getMaChuyenDi(),
//					chuyenDi.getTenChuyenDi(),
//					chuyenDi.getNgayKhoiHanh(),
//					chuyenDi.getNgayKetThuc()
//			});
//		}
//		anhChuyenDi.setIcon(new ImageIcon(dsChuyenDi.get(0).getAnh()));
//		tenChuyenDi.setText(dsChuyenDi.get(0).getTenChuyenDi());
	}
}

