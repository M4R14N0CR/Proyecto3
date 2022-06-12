package proyecto3;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Grid extends JPanel{
	private Screen myscreen;
	private keyboard mykey;
	private JScrollPane scroll;
	
	public Grid() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.scroll = new JScrollPane();

		
		this.myscreen = new Screen();
		this.mykey = new keyboard(myscreen);
		this.mykey.actionButton(this.myscreen);
		this.scroll.add(myscreen);
		
		this.scroll.setViewportView(myscreen);
		
		this.add(this.mykey);
		this.add(this.scroll);
		
	}	
}
