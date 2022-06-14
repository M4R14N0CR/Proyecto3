package proyecto3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {
	
	private JPanel PrincipalPanel = new JPanel();
	
	public Frame(String Title) {
		this.setTitle(Title);
		this.setSize(new Dimension(800,390));
		this.setPreferredSize(new Dimension(800,390));
		this.setResizable(false);
		this.pack();  
		this.setVisible(true);
		this.setLayout(new FlowLayout());
		
		this.PrincipalPanel.setBackground(Color.white);
		this.PrincipalPanel.setPreferredSize(new Dimension(800,390));
	}
	
	public void addElement(Screen newScreen) {
		PrincipalPanel.add(newScreen);
	}
	
	public void addElement(JPanel info) {
		PrincipalPanel.add(info);
	}
	
	public void addElement() {
		this.add(PrincipalPanel);
	}

}
