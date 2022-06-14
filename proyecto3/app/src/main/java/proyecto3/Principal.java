package proyecto3;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Principal {
    
    public static void main(String[] args) {
    	JFrame appFrame = new JFrame("AppGalery");
      
    	Grid appGrid = new Grid();
    	appGrid.setScroll();
    	appFrame.add(appGrid);
      
    	appFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	appFrame.setSize(new Dimension(870,750));
      
    	appFrame.setPreferredSize(new Dimension(870,750));
    	appFrame.setResizable(true);
    	appFrame.pack();  
    	appFrame.setVisible(true);

    }
 }