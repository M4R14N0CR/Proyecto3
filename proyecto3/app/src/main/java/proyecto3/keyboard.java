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

    private Button addButton = new Button(50,200,"Nueva foto",Color.BLUE);
    private Button CleanButton = new Button(55, 40, "X", Color.WHITE);
    private JTextField textfield1 = new JTextField();
    private Screen OriginalScreen;
    private Screen newScreen;
    
    
    public keyboard(Grid grid) {
    	
    	this.OriginalScreen=grid.getScreen(); 
    	this.setLayout(new FlowLayout());
 
    	this.CleanButton.addActionListener(new ActionListener() {
        
    		@Override
    		public void actionPerformed(ActionEvent e) {
   
    			grid.setScreen(OriginalScreen);
    			grid.setScroll();
    			textfield1.setText("");
    		}
    	});
      
    	this.textfield1.setPreferredSize(new Dimension(350,55));
    	this.textfield1.setMaximumSize(new Dimension(350,55));
    	this.textfield1.setBackground(Color.white);
    	this.textfield1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    	this.textfield1.addActionListener(new ActionListener() {
    		
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			OriginalScreen.searchSystem(((JTextField)e.getSource()).getText());
    			newScreen = new Screen();
    			newScreen.setLabel("No hay fotografías que coincidan con la búsqueda. Por favor intenta de nuevo con otra información");
    			for (int i=0; i<OriginalScreen.searchResults.size();i++){
    				try {
    					newScreen.addImagen(OriginalScreen.searchResults.get(i).Ubicacion);
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

    	this.setBackground(Color.white);
    	this.add(textfield1);
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
    
  	}