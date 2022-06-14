package proyecto3;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Grid extends JPanel{
    private Screen myscreen;
    private keyboard mykey;
    private JScrollPane scroll;
    
    public Grid() {
    	
    	myscreen= new Screen();
    	mykey = keyboard.getKeyboard(this);
    	
    	this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    	this.mykey.actionButton(this.myscreen); 
    	this.scroll = new JScrollPane();
    	this.add(this.mykey);

    }  

    public void setScroll() {
    	this.scroll.add(myscreen);
    	this.scroll.setViewportView(myscreen);
    	this.add(this.scroll);
    }
    
    public Screen getScreen() {
    	return this.myscreen;
    }
}