package mainGUI.impl.dialog;

import java.awt.*;
import javax.swing.*;

public class DialogoRetangulo extends DialogoBase {

  private int x, y, largura, altura, cor;
  private JTextField tx, ty, tlargura, taltura;
  private JRadioButton corItems[];
    
  public int getX() { return x;}
  public int getY() { return y;}
  public int getLargura() { return largura; }
  public int getAltura() { return altura; }
  public int getCor() { return cor;}

  public DialogoRetangulo (Frame f) {
    super(f);
    setTitle ("RETANGULO");

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
    p.setLayout (new GridLayout(4,2));
    p.add (new JLabel("Posição horizontal:"));
    tx = new JTextField();
    p.add (tx);
    p.add (new JLabel("Posição vertical:"));
    ty = new JTextField();
    p.add (ty);
    p.add (new JLabel("Largura:"));
    tlargura = new JTextField();
    p.add (tlargura);
    p.add (new JLabel("Altura:"));
    taltura = new JTextField();
    p.add (taltura);
    
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
    tlargura.setText("");
    taltura.setText("");
  }

  public void inicializa (int cor, int x, int y, int largura, int altura) {
    this.cor = cor; this.x = x; this.y = y;
    this.largura = largura; this.altura = altura;
	corItems[cor].setSelected(true);
    tx.setText(Integer.toString(x));
    ty.setText(Integer.toString(y));
    tlargura.setText(Integer.toString(largura));
    taltura.setText(Integer.toString(altura));
  }

  public int showModal() {
    int resp;
    while (true) {
      resp = super.showModal();
      if (resp == DialogoBase.OK) {
        try {
          x = Integer.parseInt(tx.getText());
          y = Integer.parseInt(ty.getText());
          largura = Integer.parseInt(tlargura.getText());
          altura = Integer.parseInt(taltura.getText());
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
