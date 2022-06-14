package proyecto3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {
	JPanel PrincipalPanel = new JPanel();
	
	public Frame(String Title) {
		this.setTitle(Title);
		this.setSize(new Dimension(700,300));
		this.setPreferredSize(new Dimension(700,300));
		this.setResizable(false);
		this.pack();  
		this.setVisible(true);
		this.setLayout(new FlowLayout());
		
		this.PrincipalPanel.setPreferredSize(new Dimension(700,300));
		this.PrincipalPanel.setBackground(Color.white);;
		
		this.add(PrincipalPanel);
	}
	
	public void addElement(Screen newScreen) {
		PrincipalPanel.add(newScreen);
	}
	
	public void addElement(JPanel info) {
		PrincipalPanel.add(info);
	}

}
