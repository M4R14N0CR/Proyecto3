package proyecto3;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class Button extends JButton {
	
	public Button(int pHeigth, int pWigth, String pText, Color pColor) {
		new Dimension();
		this.setText(pText);
		this.setPreferredSize(new Dimension(pWigth,pHeigth));
		this.setMaximumSize(new Dimension(pWigth,pHeigth));
		this.setBackground(pColor);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
}
