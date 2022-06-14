package views;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controllers.AppGaleryController;

public class Screen extends JPanel {
    
	private int ScreenSize = 620;
    private int largolista=12;
    private JLabel appLabel = new JLabel();
    private AppGaleryController appController;

    public Screen(AppGaleryController appController) {
    	this.appController = appController;
    	this.setLayout(new FlowLayout());    
    	this.setPreferredSize(new Dimension(835,ScreenSize));
    	this.setMaximumSize(new Dimension(835,ScreenSize));
    	this.setBackground(Color.white);
    	this.setLabel("No hay fotograf�as a�n, agrega una presionando el bot�n 'Nueva foto'");
    }
    
  
    
    public void addImagen(String Ubicacion,int Dimensions)throws Exception{
    	Image myImage = new ImageIcon(Ubicacion).getImage();
    	JpanelWithImage myImagen = new JpanelWithImage(myImage, Ubicacion,this);
    	myImagen.setPreferredSize(new Dimension(Dimensions,Dimensions));
    	this.appController.addImage(myImagen);
    	this.appLabel.setVisible(false);
    	this.add(myImagen);
    	this.updateUI();
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
    
    public void redimencion() {
    	if (this.appController.getImages().size()==largolista) {
    		this.setSize(this.getScreenSize()+205);
    		this.setScreenSize(this.getScreenSize()+205);
    		largolista+=4;
    	}
    }
    
    public void searchSystem(String pSerch) {
    	for(int i = 0; i<this.appController.getImages().size();i++) {
    		if(this.appController.getImages().get(i).serchInImage(pSerch)) {
    			this.appController.getResults().add(this.appController.getImages().get(i));
    		}
    	}
    }

    public void setLabel(String pMessage) {  
    	this.appLabel.setText("<html><p style=\"width:320px\">"+pMessage+"</p></html>");
    	this.appLabel.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
    	this.appLabel.setPreferredSize(new Dimension(380,550));
    	this.appLabel.setVisible(true);
    	this.add(appLabel);
    }
    
    public void setLabelVisual() {  
    	this.appLabel.setVisible(false);
    }

    public void deleteImage(String pDirection) {
    	this.appController.deleteImage(pDirection);
    }  
    
    public AppGaleryController getController() {
    	
    	return this.appController;
    }
    
    
}

