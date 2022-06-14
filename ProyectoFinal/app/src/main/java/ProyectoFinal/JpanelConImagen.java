package ProyectoFinal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

 
public class JpanelConImagen extends JPanel {
   
    private Image imagen;
    private Features feature;
    public String Ubicacion;
    private  ArrayList<String> caracteristicas = new ArrayList<>();
    private Screen appScreen;
 
    public JpanelConImagen(Image imagenInicial, String Ubicacion, Screen pAppScreen) throws Exception {
      this.Ubicacion = Ubicacion;
      this.appScreen = pAppScreen;
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
            	JFrame appFrame = new JFrame("AppGallery");
            	appFrame.setSize(new Dimension(600,250));
		        appFrame.setPreferredSize(new Dimension(600,250));
		        appFrame.setResizable(false);
		        appFrame.pack();  
		        appFrame.setVisible(true);
		        appFrame.setLayout(new FlowLayout());
		        appFrame.setBackground(Color.WHITE);
		        Screen newScreen = new Screen();
		        newScreen.setPreferredSize(new Dimension(200,200));
		        JPanel info = new JPanel();
		        info.setPreferredSize(new Dimension(350,200));
		        info.setLayout(new FlowLayout());
		        JButton deleteButton = new JButton("Eliminar foto");
		        deleteButton.setBackground(Color.red);
		        deleteButton.setForeground(Color.white);
		        deleteButton.addActionListener(new ActionListener() {
		      
		      @Override
		      public void actionPerformed(ActionEvent e) {
		        appScreen.deleteImage(Ubicacion);
		        setVisible();
		        appFrame.setVisible(false);
		        appFrame.dispose();
		        if(appScreen.images.size() == 0) {
		          appScreen.setLabel("Ingrese una fotografia");
		        }
		      }
		    });
	          
	            try {
	          newScreen.addImagen(Ubicacion);
	        } catch (Exception e) {
	          
	          e.printStackTrace();
	        }
	            
	            JLabel path = new JLabel(Ubicacion);
	            JLabel textPath = new JLabel("Ruta: ");
	            textPath.setPreferredSize(new Dimension(75,30));
	            textPath.setMaximumSize(new Dimension(75,30));
	            info.add(textPath);
	            info.add(path);
	            
	            JLabel textFeature = new JLabel("Etiquetas: ");
	            textFeature.setPreferredSize(new Dimension(180,30));
	            textFeature.setMaximumSize(new Dimension(180,30));
	            info.add(textFeature);
	            
	            for (int i=0;i<5;i++) {
	              JLabel text = new JLabel(caracteristicas.get(i));
	              text.setOpaque(true);
	              text.setPreferredSize(new Dimension(100,30));
	              text.setMaximumSize(new Dimension(100,30));
	              text.setBackground(Color.LIGHT_GRAY);
	              info.add(text);
	            }
	            info.add(deleteButton);
	            appFrame.add(newScreen);
	            appFrame.add(info);
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
	    
	    public void setVisible() {
      
      this.setVisible(false);
    }
}