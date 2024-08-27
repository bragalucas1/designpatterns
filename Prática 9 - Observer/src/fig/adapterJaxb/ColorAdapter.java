package fig.adapterJaxb;

import java.awt.Color;

public class ColorAdapter {

	public static Color stringToColor(String color) {
		String s1 = color.substring(0, 2);
		String s2 = color.substring(2, 4);
		String s3 = color.substring(4, 6);
		int c1 = Integer.parseInt(s1, 16);
		int c2 = Integer.parseInt(s2, 16);
		int c3 = Integer.parseInt(s3, 16);
		return new Color(c1, c2, c3);
	}
	
	public static String colorToString(Color color) {
		int r = color.getRed();
		int g = color.getGreen();
		int b = color.getBlue();
		String r1 = Integer.toString(r, 16);
		if (r < 16) { r1 = "0" + r1; }
		String g1 = Integer.toString(g, 16);
		if (g < 16) { g1 = "0" + g1; }
		String b1 = Integer.toString(b, 16);
		if (b < 16) { b1 = "0" + b1; }
		return r1 + g1 + b1;
	}



}
