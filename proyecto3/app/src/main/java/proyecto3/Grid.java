import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class Grid extends JPanel{
	private Screen myscreen;
	private keyboard mykey;

	public Grid() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		this.myscreen = new Screen();
		this.mykey = new keyboard();

		this.add(this.mykey);
		this.add(this.myscreen);


	}
}
