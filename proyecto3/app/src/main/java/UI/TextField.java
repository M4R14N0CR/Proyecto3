package UI;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class TextField extends JTextField {
	
	public TextField() {
		this.setPreferredSize(new Dimension(350,55));
    	this.setMaximumSize(new Dimension(350,55));
    	this.setBackground(Color.white);
    	this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}

}
