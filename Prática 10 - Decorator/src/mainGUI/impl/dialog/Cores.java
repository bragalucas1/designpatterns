package mainGUI.impl.dialog;

import java.awt.Color;

public class Cores
{
  private static final Color corValores[] = 
    { Color.black, Color.blue, Color.red, Color.green, Color.ORANGE };
  private static final String corNomes[] =
    {"Preto", "Azul", "Vermelho", "Verde", "Laranja"};
  
  public static int getNumCores() {
      return corValores.length;
  }
  
  public static Color getCor(int i) {
      return corValores[i];
  }
  
  public static String getNomeCor(int i) {
      return corNomes[i];
  }
  
  public static int getIndiceCor(Color c) {
      int i;
      for (i = 0; i < corValores.length; ++i)
        if (c.equals(corValores[i]))
          return i;
      return -1;
  }

}
