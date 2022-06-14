package proyecto3;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
 
    	this.CleanButton.addActionListener(new ActionListener() {
        
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			if(OriginalScreen.images.size()==0) {
    				OriginalScreen.setLabel("No hay fotografías aún, agrega una presionando el botón 'Nueva foto'");
    			}else {
    				OriginalScreen.setLabelVisual();
    			}
    			
    			for (int i=0; i<OriginalScreen.images.size();i++){
    				OriginalScreen.images.get(i).setVisible(true);
    			}
    			textfield.setText("");
    		}
    	});
      
    	
    	this.textfield.addActionListener(new ActionListener() {
    		
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			OriginalScreen.searchSystem(((JTextField)e.getSource()).getText());
    	    	
    			if (OriginalScreen.searchResults.size()==0) {
    				OriginalScreen.setLabel("No hay fotografías que coincidan con la búsqueda. Por favor intenta de nuevo con otra información");
    			}
    			else {
    				OriginalScreen.setLabelVisual();
    			}
    			for (int i=0; i<OriginalScreen.images.size();i++){
    				if(OriginalScreen.searchResults.contains(OriginalScreen.images.get(i))) {
    				}
    				else {
    					OriginalScreen.images.get(i).setVisible(false);
    				}
    			}
    			grid.updateUI();
    			OriginalScreen.searchResults.clear();
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