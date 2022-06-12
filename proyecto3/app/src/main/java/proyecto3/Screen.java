package proyecto3;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Screen extends JPanel {
	
	private int ScreenSize = 620;
	private ArrayList<String> Ubicaciones = new ArrayList<>();
	private int largolista=12;

	public Screen() {
		this.setLayout(new FlowLayout());		

		this.setPreferredSize(new Dimension(835,ScreenSize));
		this.setMaximumSize(new Dimension(835,ScreenSize));
		this.setBackground(Color.white);
		
	}
	
	public void addImagen(String Ubicacion) {
		Image My = new ImageIcon(Ubicacion).getImage();
		JpanelConImagen myImagen = new JpanelConImagen(My, Ubicacion);
		myImagen.setPreferredSize(new Dimension(200,200));
		this.add(myImagen);
		this.updateUI();
		JOptionPane.showMessageDialog(null, "La imagen ha sido agregada exitosamente");
		
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
	
	public void redimencion(String texto, Screen myscreen) {
		
		Ubicaciones.add(texto); 
		System.out.println(Ubicaciones.size());
		
		if (Ubicaciones.size()==largolista) {
			myscreen.setSize(myscreen.getScreenSize()+205);
			myscreen.setScreenSize(myscreen.getScreenSize()+205);
			largolista+=4;
		}

	}
	
}

