package views;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import controllers.AppGaleryController;

public class PrincipalFrame {

	public PrincipalFrame() {
		
		
		JFrame appFrame = new JFrame("AppGalery");
		
		AppGaleryController appController = new AppGaleryController();  
    	Grid appGrid = new Grid(appController);
    	appController.setGrid(appGrid);
    	
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
