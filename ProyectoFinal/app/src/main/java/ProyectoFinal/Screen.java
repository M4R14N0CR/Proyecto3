package ProyectoFinal;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Screen extends JPanel {
    
    private int ScreenSize = 620;
    private int largolista=12;
    public  ArrayList<JpanelWithImage> images = new ArrayList<>();
    public  ArrayList<JpanelWithImage> searchResults = new ArrayList<>();
    private JLabel appLabel = new JLabel();

    public Screen() {
      this.setLayout(new FlowLayout());    
      this.setPreferredSize(new Dimension(835,ScreenSize));
      this.setMaximumSize(new Dimension(835,ScreenSize));
      this.setBackground(Color.white);
      this.setLabel("No hay fotografías aún, agrega una presionando el botón 'Nueva foto'");
    }
    
    public void addImagen(String Ubicacion, int Dimensions)throws Exception{
      Image My = new ImageIcon(Ubicacion).getImage();
      JpanelWithImage myImagen = new JpanelWithImage(My, Ubicacion, this);
      myImagen.setPreferredSize(new Dimension(Dimensions,Dimensions));
      this.images.add(myImagen);
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
      if (images.size()==largolista) {
    	  this.setSize(this.getScreenSize()+205);
    	  this.setScreenSize(this.getScreenSize()+205);
    	  largolista+=4;
      }
    }
    
    public void searchSystem(String pSerch) {
      for(int i = 0; i<images.size();i++) {
        if(images.get(i).serchInImage(pSerch)) {
          searchResults.add(images.get(i));
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
    
    public void deleteImage(String pDirection) {
      for(int i = 0; i<images.size();i++) {
        if(pDirection.equals(images.get(i).Ubicacion)) {
          images.remove(i);
        }
      }
      
    }
    
  }