import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class addWindow extends JFrame{
	private JTextField textfield1 = new JTextField();
	private JLabel text = new JLabel("Ingrese la ubicacion de la fotografia");
	private JButton boton = new JButton("Enviar");
	public String Ubicacion;

	public addWindow(Screen myscreen) {

		this.setTitle("Select an Option");
		this.setBounds(20, 300, 400, 200);
		this.setResizable(false);
		this.setVisible(true);
		textfield1.setPreferredSize(new Dimension(200,50));
		textfield1.setMaximumSize(new Dimension(200,50));

		this.boton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myscreen.addImagen(textfield1.getText());
				myscreen.redimencion(textfield1.getText(), myscreen);
				textfield1.setText("");
				Quitar();

			}
		});

		JPanel myPanel = new JPanel();
		myPanel.setLayout(new FlowLayout());
		myPanel.add(text);
		myPanel.add(textfield1);
		myPanel.add(boton);
		this.add(myPanel);

	}

	public void Quitar() {
		this.setVisible(false);;
}

	public void setUbicacion(String Ubi) {
		this.Ubicacion= Ubi;
}

	public String getUbicacion() {
		if (this.Ubicacion==null) {
			setUbicacion(textfield1.getText());
		}
		return this.Ubicacion;
	}


}
