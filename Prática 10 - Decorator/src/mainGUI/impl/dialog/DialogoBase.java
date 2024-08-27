package mainGUI.impl.dialog;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

public class DialogoBase extends JDialog {

  public static final int CANCELAR = 0;
  public static final int OK = 1;

  private JPanel p0;
  private int retorno;

  public int showModal() {
    retorno = CANCELAR;
    setVisible(true);
    return retorno;
  }
  
  public void Adiciona (Component c) {
    p0.add (c);
  }
  
  public DialogoBase (Frame f) {
    super(f);
    setModal (true);
    
    Container c = getContentPane();
    c.setLayout (new BorderLayout(5,5));    
    
    JPanel p1 = new JPanel();
    p1.setLayout (new FlowLayout());
    JButton botOK = new JButton("OK");
    JButton botCANCEL = new JButton("CANCELAR");
    p1.add (botOK);
    p1.add (botCANCEL);
    c.add (p1, BorderLayout.SOUTH);
    
    botOK.addActionListener (
      new ActionListener() {
        public void actionPerformed (ActionEvent evento) {
          retorno = OK;
          setVisible(false);
        }
      }
    );
    botCANCEL.addActionListener (
      new ActionListener() {
        public void actionPerformed (ActionEvent evento) {
          retorno = CANCELAR;
          setVisible(false);
        }
      }
    );

    p0 = new JPanel();
    Border borda1 = BorderFactory.createCompoundBorder (
      BorderFactory.createBevelBorder (BevelBorder.LOWERED),
      BorderFactory.createEmptyBorder (5,5,5,5));
    p0.setBorder(borda1);
    c.add (p0, BorderLayout.CENTER);

    setSize (300, 160);
  }
  
  public DialogoBase() {
    this(null);
  }
}
