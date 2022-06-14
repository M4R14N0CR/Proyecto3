package ProyectoFinal;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooser extends JFrame {
  
  private FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG Images", "jpg", "png");
  String selectPath = "";
  
  public FileChooser(Screen myscreen) {
    JFileChooser dlg = new JFileChooser();
    dlg.setFileFilter(filter);
    int option = dlg.showOpenDialog(dlg);
    this.selectPath = dlg.getSelectedFile().getPath();
    try {
      myscreen.addImagen(selectPath,200);
    } catch (Exception e1) {
      e1.printStackTrace();
    }
    
    myscreen.redimencion();
    JOptionPane.showMessageDialog(null, "La imagen ha sido agregada exitosamente");
  }
  
}