package mainGUI.impl.dialog;

import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class DialogoLinha extends DialogoBase {

	private int x, y, x2, y2, cor;
	private JTextField tx, ty, tx2, ty2;
	private JRadioButton corItems[];

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getX2() {
		return x2;
	}

	public int getY2() {
		return y2;
	}

	public int getCor() {
		return cor;
	}

	public DialogoLinha(Frame f) {
		super(f);
		setTitle("LINHA");

		JPanel p4 = new JPanel();
		p4.setLayout(new GridLayout(1, 2));
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(Cores.getNumCores(), 1));
		corItems = new JRadioButton[Cores.getNumCores()];
		ButtonGroup corGroup = new ButtonGroup();
		for (int i = 0; i < Cores.getNumCores(); i++) {
			corItems[i] = new JRadioButton(Cores.getNomeCor(i));
			corGroup.add(corItems[i]);
			p2.add(corItems[i]);
		}
		corItems[0].setSelected(true);
		p4.add(new JLabel("Cor:"));
		p4.add(p2);

		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4, 3));
		p.add(new JLabel("PX:"));
		tx = new JTextField();
		p.add(tx);
		p.add(new JLabel("PY:"));
		ty = new JTextField();
		p.add(ty);
		p.add(new JLabel("PX2:"));
		tx2 = new JTextField();
		p.add(tx2);
		p.add(new JLabel("PY2:"));
		ty2 = new JTextField();
		p.add(ty2);

		JPanel p3 = new JPanel();
		p3.setLayout(new GridLayout(2, 1));
		p3.add(p4);
		p3.add(p);

		Adiciona(p3);
		pack();
	}

	public void limpa() {
		corItems[0].setSelected(true);
		tx.setText("");
		ty.setText("");
		tx2.setText("");
		ty2.setText("");
	}

	public void inicializa(int aCor, int aX, int aY, int aX2, int aY2) {
		cor = aCor;
		x = aX;
		y = aY;
		x2 = aX2;
		y2 = aY2;
		corItems[cor].setSelected(true);
		tx.setText(Integer.toString(x));
		ty.setText(Integer.toString(y));
		tx2.setText(Integer.toString(x2));
		ty2.setText(Integer.toString(y2));
	}

	public int showModal() {
		int resp;
		while (true) {
			resp = super.showModal();
			if (resp == DialogoBase.OK) {
				try {
					x = Integer.parseInt(tx.getText());
					y = Integer.parseInt(ty.getText());
					x2 = Integer.parseInt(tx2.getText());
					y2 = Integer.parseInt(ty2.getText());
					for (int i = 0; i < corItems.length; ++i)
						if (corItems[i].isSelected())
							cor = i;
					break;
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(this, "Erro no formato de numero inteiro", "ERRO",
							JOptionPane.PLAIN_MESSAGE);
				}
			} else
				break;
		}
		return resp;
	}
}
