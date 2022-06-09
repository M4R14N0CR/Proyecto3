import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;


public class JpanelConImagen extends JPanel {

    private Image imagen;

    public JpanelConImagen(Image imagenInicial) {
    	this.setPreferredSize(new Dimension(200,20));
		this.setMaximumSize(new Dimension(200,200));

        if (imagenInicial != null) {
            imagen = imagenInicial;
        }
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

        setOpaque(false);
        super.paint(g);
    }



}
