package proyecto3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
import Engine.Features;
import Engine.FindWord;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JLabel;

 
public class JpanelWithImage extends JPanel {
   
    private Image imagen;
    private Features feature;
    private String Location;
    private  ArrayList<String> Characteristics = new ArrayList<>();
    private Screen appScreen;
    private FindWord findWord = new FindWord();
    
    public JpanelWithImage(Image imagenInicial, String pLocation, Screen pAppScreen) throws Exception {
    	this.Location = pLocation;
    	this.appScreen = pAppScreen;
    	feature = new Features();
    	feature.setFeatures(pLocation);
      
    	for (int i=0; i<feature.getFeatures().size();i++) {
    		Characteristics.add(feature.getFeatures().get(i));
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
    				newScreen.setPreferredSize(new Dimension(300,300));
    				newScreen.setMaximumSize(new Dimension(300,300));
    				
    				JPanel info = new JPanel();
    				info.setPreferredSize(new Dimension(420,380));
    				info.setLayout(new FlowLayout());
    				info.setBackground(Color.white);
   
    				Button deleteButton = new Button(40,100,"Eliminar foto",Color.red);
    				deleteButton.setForeground(Color.white);
    				deleteButton.addActionListener(new ActionListener() {
          
    					@Override
    					public void actionPerformed(ActionEvent e) {
    						appScreen.deleteImage(pLocation);
    						setVisible(false);
    						appFrame.setVisible(false);
    						appFrame.dispose();
    						if(appScreen.getImages().size()==0) {
    							appScreen.setLabel("No hay fotografías aún, agrega una presionando el botón 'Nueva foto'");
    						}
    					}
    				});
          
    				try {
    					newScreen.addImagen(pLocation,290);
    				} catch (Exception e) {
    					
    					e.printStackTrace();
    				}

            
    				JLabel SubTitle1 = new JLabel("Ruta:");
    				SubTitle1.setFont(new Font("Arial", Font.CENTER_BASELINE,15));
    				SubTitle1.setPreferredSize(new Dimension(400,40));
    				info.add(SubTitle1);
    				
    				JLabel path = new JLabel(pLocation);
    				path.setPreferredSize(new Dimension(400,20));
    				info.add(path);
    				
    				JLabel SubTitle2 = new JLabel("Etiquetas:");
    				SubTitle2.setPreferredSize(new Dimension(400,75));
    				SubTitle2.setFont(new Font("Arial", Font.CENTER_BASELINE,15));
    				info.add(SubTitle2);
            
    				for (int i=0;i<5;i++) {
    					JLabel text = new JLabel("       " + Characteristics.get(i));
    					text.setOpaque(true);
    					text.setPreferredSize(new Dimension(100,50));
    					text.setMaximumSize(new Dimension(100,50));
    					text.setBackground(Color.LIGHT_GRAY);
    					info.add(text);
    				}
    				
    				JLabel whiteLabel = new JLabel();
    				whiteLabel.setPreferredSize(new Dimension(310,50));
    				
    				JLabel whiteLabel2 = new JLabel();
    				whiteLabel2.setPreferredSize(new Dimension(310,50));
    				
    				info.add(whiteLabel);
    				info.add(deleteButton);
    				info.add(whiteLabel2);
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
   		for(int i = 0; i<Characteristics.size();i++) {
   			if(this.findWord.findWord(Characteristics.get(i), pSearch)) {
   				return true;
   			}
    	}
    	return false;
   	}
    
    public void setVisible(Boolean b) {
   		this.setVisible(b);
    }

    public String getMyLocation() {
    	return this.Location;
    }
}