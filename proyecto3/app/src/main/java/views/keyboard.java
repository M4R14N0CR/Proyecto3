package views;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Engine.FindWord;
import controllers.AppGaleryController;

public class keyboard extends JPanel{

	private static keyboard myKeyboard = null;
    private Button addButton = new Button(50,200,"Nueva foto",Color.BLUE);
    private Button CleanButton = new Button(55, 40, "X", Color.WHITE);
    private TextField textfield = new TextField();
    private Screen OriginalScreen;
    private AppGaleryController appController;
    
    
    private keyboard(Grid grid, AppGaleryController appController) {
    	
    	this.appController = appController;
    	this.setBackground(Color.white);
    	this.setLayout(new FlowLayout());
    	
    	this.OriginalScreen=grid.getScreen(); 
 
    	this.CleanButton.addActionListener(new ActionListener() {
        
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			
    			if(OriginalScreen.getController().getImages().size()==0) {
    				OriginalScreen.setLabel("No hay fotografías aún, agrega una presionando el botón 'Nueva foto'");
    			}else {
    				OriginalScreen.setLabelVisual();
    			}
    			
    			for (int i=0; i<OriginalScreen.getController().getImages().size();i++){
    				OriginalScreen.getController().getImages().get(i).setVisible(true);
    			}
    			textfield.setText("");
    		}
    	});
      
    	
    	this.textfield.addActionListener(new ActionListener() {
    		
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			
    			
    			if(((JTextField)e.getSource()).getText().length() >= 3) {
    				
    			OriginalScreen.searchSystem(((JTextField)e.getSource()).getText());

    			if(OriginalScreen.getController().getResults().size() == 0) {
    				
    				OriginalScreen.setLabel("No hay fotografías que coincidan con la búsqueda. Por favor intenta de nuevo con otra información");
    			}
    			
    			else {
    				
    				OriginalScreen.setLabelVisual();
    			}
    			
    			for(int i = 0; i<OriginalScreen.getController().getImages().size();i++) {
    				
    				
    				if(OriginalScreen.getController().getResults().contains(OriginalScreen.getController().getImages().get(i))) {
    					
    				}
    				else {
    					OriginalScreen.getController().getImages().get(i).setVisible(false);
    				}
    			}
    			
    			grid.updateUI();
    			OriginalScreen.getController().getResults().clear();
    			
    		}
    		}
    	});

    	this.add(textfield);
    	this.add(CleanButton);
    	this.add(addButton);
    }
    
    
    public void actionButton(Screen myscreen) {
    	this.addButton.addActionListener(new ActionListener() {
        
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			FileChooser fc = new FileChooser(myscreen);
    		}
    	});
    }
    
    public static keyboard getKeyboard(Grid grid,AppGaleryController appController ) {
    	if(myKeyboard==null) {
    		myKeyboard = new keyboard(grid, appController);
    	}
    	
    	return myKeyboard;
    }
    
}


