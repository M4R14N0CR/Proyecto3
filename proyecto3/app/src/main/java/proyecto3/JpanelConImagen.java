package proyecto3;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

 
public class JpanelConImagen extends JPanel {
 
    private Image imagen;
    private Keyboard mykey;
    private Screen myscreen;
 
    public JpanelConImagen(Image imagenInicial) {
    	this.setPreferredSize(new Dimension(200,20));
		this.setMaximumSize(new Dimension(200,200));
		
        if (imagenInicial != null) {
            imagen = imagenInicial;
        }
        
        this.addMouseListener((MouseListener) new MouseAdapter() { 
            public void mousePressed(MouseEvent me) { 
            	System.out.println("Hola"); 
            	JFrame appFrame = new JFrame("Image");
	  		
	      		appFrame.setSize(new Dimension(870,750));
	      		
	      		appFrame.setPreferredSize(new Dimension(870,750));
	      		appFrame.setResizable(true);
	      		appFrame.pack();	
	      		appFrame.setVisible(true);
	      		
	      		Screen newScreen = new Screen();
	      		newScreen.addImagen("C:/Users/fabia/Downloads/foto.jpg");
	      		appFrame.add(newScreen);
            } 
          });
    }
 
    @Override
    public void paint(Graphics g) {
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
 
        setOpaque(false);
        super.paint(g);
    }
    
    
    
 
}