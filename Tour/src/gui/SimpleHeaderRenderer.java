package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
 
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.TableCellRenderer;
 
/**
 * A simple renderer class for JTable component.
 * @author www.codejava.net
 *
 */
public class SimpleHeaderRenderer extends JLabel implements TableCellRenderer {
 
    public SimpleHeaderRenderer() {
    	setFont(new Font(MainScreen.FONT_TEXT, Font.BOLD, 14));
        setOpaque(true);
        setHorizontalAlignment(JLabel.LEADING);
        setForeground(Color.WHITE);
        setBackground(MainScreen.COLOR_MAIN);
    }
     
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        setText(value.toString());
        return this;
    }
}
