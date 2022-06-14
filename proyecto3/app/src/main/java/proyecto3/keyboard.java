package proyecto3;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class keyboard extends JPanel{
	
	private static keyboard myKeyboard = null;

    private Button addButton = new Button(50,200,"Nueva foto",Color.BLUE);
    private Button CleanButton = new Button(55, 40, "X", Color.WHITE);
    private TextField textfield = new TextField();
    private Screen OriginalScreen;
    private Screen newScreen;
    
    
    private keyboard(Grid grid) {
    	this.setBackground(Color.white);
    	this.setLayout(new FlowLayout());
    	
    	this.OriginalScreen=grid.getScreen(); 
 
    	this.CleanButton.addActionListener(new ActionListener() {
        
    		@Override
    		public void actionPerformed(ActionEvent e) {
   
    			grid.setScreen(OriginalScreen);
    			grid.setScroll();
    			textfield.setText("");
    		}
    	});
      
    	
    	this.textfield.addActionListener(new ActionListener() {
    		
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			OriginalScreen.searchSystem(((JTextField)e.getSource()).getText());
    			
    			newScreen= new Screen();
    			newScreen.setLabel("No hay fotograf�as que coincidan con la b�squeda. Por favor intenta de nuevo con otra informaci�n");
    			for (int i=0; i<OriginalScreen.searchResults.size();i++){
    				try {
    					newScreen.addImagen(OriginalScreen.searchResults.get(i).Ubicacion,200);
    					newScreen.redimencion();
    				} catch (Exception e1) {
    					
    					e1.printStackTrace();
    				}
    			}
    			grid.setScreen(newScreen);
    			grid.setScroll();
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