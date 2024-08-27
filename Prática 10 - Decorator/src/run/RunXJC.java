package run;

import com.sun.tools.xjc.Driver;

public class RunXJC {

	public static void main(String[] args) throws Exception {
		String s[] = new String[5];
		s[0] = "src/xsd/fig.xsd";
		s[1] = "-d";
		s[2] = "src";
		s[3] = "-p";
		s[4] = "fig.xmlclasses";
		Driver.run(s, null, System.out);
	}

}
