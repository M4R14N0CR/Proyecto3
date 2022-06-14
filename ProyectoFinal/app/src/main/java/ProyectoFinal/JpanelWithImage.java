package ProyectoFinal;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

 
public class JpanelWithImage extends JPanel {
   
    private Image imagen;
    private Features feature;
    public String Ubicacion;
    private  ArrayList<String> caracteristicas = new ArrayList<>();
    private Screen appScreen;
 
    public JpanelWithImage(Image imagenInicial, String Ubicacion, Screen pAppScreen) throws Exception {
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
            	Frame appFrame = new Frame("Image");
            	
		        Screen newScreen = new Screen();
		        newScreen.setPreferredSize(new Dimension(250,250));
		        newScreen.setMaximumSize(new Dimension(250,250));
		        
		        JPanel info = new JPanel();
				info.setPreferredSize(new Dimension(420,280));
				info.setPreferredSize(new Dimension(420,300));
				info.setLayout(new FlowLayout());
				info.setBackground(Color.white);

				Button deleteButton = new Button(35,100,"Eliminar foto",Color.red);
				deleteButton.setForeground(Color.white);
		        deleteButton.addActionListener(new ActionListener() {
		      
				      @Override
				      public void actionPerformed(ActionEvent e) {
				        appScreen.deleteImage(Ubicacion);
				        setVisible();
				        appFrame.setVisible(false);
				        appFrame.dispose();
				        if(appScreen.images.size() == 0) {
				        	appScreen.setLabel("No hay fotografías aún, agrega una presionando el botón 'Nueva foto'");
				        }
				      }
				    });
	          
	            try {
	            	newScreen.addImagen(Ubicacion,250);
	            } catch (Exception e) {
	          
	            	e.printStackTrace();
	            }
	            
	            JLabel SubTitle1 = new JLabel("Ruta:");
				SubTitle1.setFont(new Font("Arial", Font.CENTER_BASELINE,15));
				SubTitle1.setPreferredSize(new Dimension(400,60));
				info.add(SubTitle1);

				JLabel path = new JLabel(Ubicacion);
				path.setPreferredSize(new Dimension(400,20));
				info.add(path);

				JLabel SubTitle2 = new JLabel("Etiquetas:");
				SubTitle2.setPreferredSize(new Dimension(400,75));
				SubTitle2.setFont(new Font("Arial", Font.CENTER_BASELINE,15));
				info.add(SubTitle2);
	            
	            for (int i=0;i<5;i++) {
	              JLabel text = new JLabel(caracteristicas.get(i));
	              text.setOpaque(true);
	              text.setPreferredSize(new Dimension(100,50));
	              text.setMaximumSize(new Dimension(100,50));
	              text.setBackground(Color.LIGHT_GRAY);
	              info.add(text);
	            }
	            info.add(deleteButton);
	            appFrame.addElement(newScreen);
				appFrame.addElement(info);
				appFrame.addElement();
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