package mainGUI.impl.dialog;

import java.awt.*;
import javax.swing.*;

public class DialogoCirculo extends DialogoBase {

  private int x, y, raio, cor;
  private JTextField tx, ty, traio;
  private JRadioButton corItems[];
    
  public int getX() { return x;}
  public int getY() { return y;}
  public int getRaio() { return raio;}
  public int getCor() { return cor;}

  public DialogoCirculo (Frame f) {
    super(f);
    setTitle ("CIRCULO");

    JPanel p4 = new JPanel();
    p4.setLayout (new GridLayout(1,2));
    JPanel p2 = new JPanel();
    p2.setLayout (new GridLayout(Cores.getNumCores(),1));
	corItems = new JRadioButton[Cores.getNumCores()];
	ButtonGroup corGroup = new ButtonGroup();
	for (int i = 0; i < Cores.getNumCores(); i++) {
	  corItems[i] =  new JRadioButton(Cores.getNomeCor(i));
	  corGroup.add(corItems[i]);
	  p2.add(corItems[i]);
	}
	corItems[0].setSelected(true);
	p4.add (new JLabel("Cor:"));
	p4.add (p2);

    JPanel p = new JPanel();
    p.setLayout (new GridLayout(3,2));
    p.add (new JLabel("Posição Horizontal:"));
    tx = new JTextField();
    p.add (tx);
    p.add (new JLabel("Posição Vertical:"));
    ty = new JTextField();
    p.add (ty);
    p.add (new JLabel("Raio:"));
    traio = new JTextField();
    p.add (traio);
    
    JPanel p3 = new JPanel();
    p3.setLayout (new GridLayout(2,1));
    p3.add (p4);
    p3.add (p);
	
    Adiciona (p3);
    pack();
  }

  public void limpa() {
	corItems[0].setSelected(true);
    tx.setText("");
    ty.setText("");
    traio.setText("");
  }

  public void inicializa (int aCor, int aX, int aY, int aRaio) {
    cor = aCor; x = aX; y = aY; raio = aRaio;
	corItems[cor].setSelected(true);
    tx.setText(Integer.toString(x));
    ty.setText(Integer.toString(y));
    traio.setText(Integer.toString(raio));
  }

  public int showModal() {
    int resp;
    while (true) {
      resp = super.showModal();
      if (resp == DialogoBase.OK) {
        try {
          x = Integer.parseInt(tx.getText());
          y = Integer.parseInt(ty.getText());
          raio = Integer.parseInt(traio.getText());
          for (int i = 0; i < corItems.length; ++i)
            if (corItems[i].isSelected())
              cor = i;
          break;
        }
        catch (NumberFormatException e) {
          JOptionPane.showMessageDialog (this,
            "Erro no formato de numero inteiro",
            "ERRO", JOptionPane.PLAIN_MESSAGE);
        }
      }
      else
        break;
    }
    return resp;
  }
}
