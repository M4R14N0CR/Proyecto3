package UI;
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


public class keyboard extends JPanel{

	private static keyboard myKeyboard = null;

    private Button addButton = new Button(50,200,"Nueva foto",Color.BLUE);
    private Button CleanButton = new Button(55, 40, "X", Color.WHITE);
    private TextField textfield = new TextField();
    private Screen OriginalScreen;
    
    
    private keyboard(Grid grid) {
    	
    	this.setBackground(Color.white);
    	this.setLayout(new FlowLayout());
    	
    	this.OriginalScreen=grid.getScreen(); 
    	this.addButton.setForeground(Color.white);
    	this.CleanButton.addActionListener(new ActionListener() {
        
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			
    			if(OriginalScreen.getImages().size()==0) {
    				OriginalScreen.setLabel("No hay fotografías aún, agrega una presionando el botón 'Nueva foto'");
    			}else {
    				OriginalScreen.setLabelVisual();
    			}
    			
    			for (int i=0; i<OriginalScreen.getImages().size();i++){
    				OriginalScreen.getImages().get(i).setVisible(true);
    			}
    			textfield.setEditable(true);
    			textfield.setText("");
    		}
    	});
      
    	
    	this.textfield.addActionListener(new ActionListener() {
    		
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			
    			if(((JTextField)e.getSource()).getText().length()>=3) {
    				
    			
    			
    				OriginalScreen.searchSystem(((JTextField)e.getSource()).getText());
    	    	
    				if (OriginalScreen.getSearchResults().size()==0) {
    					OriginalScreen.setLabel("No hay fotografías que coincidan con la búsqueda. Por favor intenta de nuevo con otra información");
    				}
    				else {
    					OriginalScreen.setLabelVisual();
    				}
    			
    				for (int i=0; i<OriginalScreen.getImages().size();i++){
    					if(OriginalScreen.getSearchResults().contains(OriginalScreen.getImages().get(i))) {
    					}
    					else {
    						OriginalScreen.getImages().get(i).setVisible(false);
    					}
    				}
    			
    				textfield.setEditable(false);
    				grid.updateUI();
    				OriginalScreen.getSearchResults().clear();
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
    
    
    public static keyboard getKeyboard(Grid grid) {
    	if(myKeyboard==null) {
    		myKeyboard = new keyboard(grid);
    	}
    	
    	return myKeyboard;
    }
    
    
}


