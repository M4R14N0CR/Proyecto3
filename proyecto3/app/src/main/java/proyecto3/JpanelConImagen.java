package proyecto3;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

 
public class JpanelConImagen extends JPanel {
 
    private Image imagen;
    private Features feature;
    public String Ubicacion;
    private  ArrayList<String> caracteristicas = new ArrayList<>();
 
    public JpanelConImagen(Image imagenInicial, String Ubicacion) throws Exception {
    	this.Ubicacion = Ubicacion;
    	feature = new Features();
    	feature.setFeatures(Ubicacion);
    	
    	for (int i=0; i<feature.getFeatures().size();i++) {
    		caracteristicas.add(feature.getFeatures().get(i));
    	}
    	
    	this.setPreferredSize(new Dimension(200,20));
		this.setMaximumSize(new Dimension(200,200));
		
        if (imagenInicial != null) {
            imagen = imagenInicial;
        }
        
        this.addMouseListener((MouseListener) new MouseAdapter() { 
            public void mousePressed(MouseEvent me) { 
            	JFrame appFrame = new JFrame("Image");
	      		appFrame.setSize(new Dimension(870,750));
	      		appFrame.setPreferredSize(new Dimension(500,500));
	      		appFrame.setResizable(true);
	      		appFrame.pack();	
	      		appFrame.setVisible(true);
	      		Screen newScreen = new Screen();
	      		try {
					newScreen.addImagen(Ubicacion);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
	      		
	      		for (int i=0;i<5;i++) {
	      			JLabel text = new JLabel(caracteristicas.get(i));
	      			text.setPreferredSize(new Dimension(100,50));
	      			text.setMaximumSize(new Dimension(100,50));
	      			text.setBackground(Color.LIGHT_GRAY);
	      			newScreen.add(text);
	      		}
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
    
    public boolean serchInImage(String pSearch) {
    	for(int i = 0; i<caracteristicas.size();i++) {
    		if(pSearch.equals(caracteristicas.get(i))) {
    			return true;
    		}
    	
    	}
    	return false;
    }
}
