package proyecto3;
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

    private JButton myButton = new JButton("Nueva Foto");
    private JButton myButtonC = new JButton("X");
    private JTextField textfield1 = new JTextField();
    private Screen OriginalScreen;
    private Screen newScreen;
    
    
    public keyboard(Grid grid) {
      this.OriginalScreen=grid.getScreen();
     

      
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
          newScreen.setLabel("No hay fotografias");
          for (int i=0; i<OriginalScreen.searchResults.size();i++){
            try {
        newScreen.addImagen(OriginalScreen.searchResults.get(i).Ubicacion);
        newScreen.redimencion(newScreen);
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
      this.add(myButtonC);
      this.add(myButton);
    }
    

    
    public void actionButton(Screen myscreen) {
      this.myButton.addActionListener(new ActionListener() {
        
        @Override
        public void actionPerformed(ActionEvent e) {
          FileChooser fc = new FileChooser(myscreen);
        }
      });
    }
    
    
  }
