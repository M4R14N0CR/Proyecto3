import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Screen extends JPanel {

	private int ScreenSize = 620;

	public Screen() {
		this.setLayout(new FlowLayout());

		this.setPreferredSize(new Dimension(835,ScreenSize));
		this.setMaximumSize(new Dimension(835,ScreenSize));
		this.setBackground(Color.white);

	}

	public void addImagen(String Ubicacion) {
		Image My = new ImageIcon(Ubicacion).getImage();
		JpanelConImagen myImagen = new JpanelConImagen(My);
		myImagen.setPreferredSize(new Dimension(200,200));
		this.add(myImagen);

	}

	public void setSize(int largo) {
		this.setPreferredSize(new Dimension(835,largo));
		this.setMaximumSize(new Dimension(835,largo));

	}

	public void setScreenSize(int largo) {
		ScreenSize = largo;
	}

	public int getScreenSize() {
		return ScreenSize;
	}

}
