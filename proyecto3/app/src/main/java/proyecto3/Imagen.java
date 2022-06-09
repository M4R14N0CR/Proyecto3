import java.awt.Image;

import javax.swing.ImageIcon;

public class Imagen {
	private Image My;
	private JpanelConImagen panel;

	public Imagen() {
		My = new ImageIcon("C:/Users/Brandon/OneDrive - Estudiantes ITCR/Imágenes/IMG_20220213_174335.jpg").getImage();
		panel = new JpanelConImagen(My);
	}
}
