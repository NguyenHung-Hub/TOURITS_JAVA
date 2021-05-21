package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class CaiDat_Pane extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CaiDat_Pane() {
		setLayout(null);
		setOpaque(false);
		buidCaiDat();
	}
	
	private void buidCaiDat() {
		JPanel panelLeft = new JPanel() { 
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				super.paintComponent(g);
				super.paintComponent(g);
		        Dimension arcs = new Dimension(15,15); //Border corners arcs {width,height}, change this to whatever you want
		        int width = getWidth();
		        int height = getHeight();
		        Graphics2D graphics = (Graphics2D) g;
		        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


		        //Draws the rounded panel with borders.
		        graphics.setColor(getBackground()); 
		        graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);//paint background
		        graphics.setColor(MainScreen.COLOR_TEXT);
		        graphics.drawRoundRect(0, 0, width - 2, height - 2, arcs.width, arcs.height);//paint border
		     }
		};
		panelLeft.setBackground(MainScreen.BACKGROUND_COLOR);
		panelLeft.setOpaque(false);
		panelLeft.setBounds(0, 40, 200, 650);
		add(panelLeft);
//		
//		JPanel panelRight = new RoundedPanel(50);
//		panelRight.setBackground(Color.white);
//		panelRight.setOpaque(false);
////		panelRight.setBounds(0, 0, 200, 680);
//		add(panelRight);
		
	}
}
