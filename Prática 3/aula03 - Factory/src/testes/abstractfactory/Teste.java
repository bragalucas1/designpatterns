package testes.abstractfactory;

import draw.impl.FigDrawableFactory;
import draw.impl.FigDrawableFactory_FEIA;
import fig.impl.FigFactory;

public class Teste {

	InterfaceGrafica g;
	
	public static void main(String args[]) {
		Teste t1 = new Teste();
		t1.g = new InterfaceGrafica(new FigDrawableFactory(new FigFactory()));
	}
	
}
