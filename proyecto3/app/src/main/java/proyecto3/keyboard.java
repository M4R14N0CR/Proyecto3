import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class keyboard extends JPanel{
	ArrayList<String> nombres = new ArrayList<>();
	private JButton myButton = new JButton("Nueva Foto");
	private JButton myButtonC = new JButton("X");
	private JTextField textfield1 = new JTextField();
	private ArrayList<String> Ubicaciones = new ArrayList<>();
	private int largolista=12;

	public keyboard() {

		nombres.add("Brandon");
		nombres.add("Fabiana");
		nombres.add("Mariano");
		nombres.add("Nicolle");
		nombres.add("Marta");
		nombres.add("Tommy");
		nombres.add("Maya");

		this.setLayout(new FlowLayout());
		this.setPreferredSize(new Dimension(800,70));
		this.setMaximumSize(new Dimension(850,70));

		this.myButton.setPreferredSize(new Dimension(200,50));
		this.myButton.setMaximumSize(new Dimension(200,50));
		this.myButton.setBackground(Color.BLUE);

		this.myButtonC.setPreferredSize(new Dimension(40,55));
		this.myButtonC.setMaximumSize(new Dimension(40,55));
		this.myButtonC.setBackground(Color.white);
		this.myButtonC.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.myButtonC.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
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
				buscar(((JTextField)e.getSource()).getText());
				textfield1.setText("");

			}
		});

		this.setBackground(Color.white);
		this.add(textfield1);
		this.add(myButtonC);
		this.add(myButton);
	}

	public int buscar(String Nombre) {

		for (int i = 0; i<nombres.size();i++) {
			if (Nombre.equals(nombres.get(i))) {
				System.out.printf("%s El nombre buscado es\n", nombres.get(i));
				return 0;
			}
		}
		System.out.println("Ese nombre no esta");
		return 0;
	}

	public void actionButton(Screen myscreen, String Ubicacion) {
		this.myButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myscreen.addImagen(Ubicacion);
				Ubicaciones.add(Ubicacion);
				if (Ubicaciones.size()==largolista) {
					myscreen.setSize(myscreen.getScreenSize()+205);
					myscreen.setScreenSize(myscreen.getScreenSize()+205);
					largolista+=4;
				}
			}
		});
	}
}
