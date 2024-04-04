package atividade3.impl;
import java.util.Vector;

import atividade3.interfaces.TreeInterface;

public class TreeConcrete implements TreeInterface {

	private int value;
	private Vector<TreeInterface> children; 
	
	public TreeConcrete(int value) {
		this.value = value;
		children = new Vector<TreeInterface>();
	}

	public int getValue() {
		return value;
	}

	public int getNumChildren() {
		return children.size();
	}

	public TreeInterface getChild(int i) {
		return children.elementAt(i);
	}
		
	public void addChild(TreeInterface child) {
		children.addElement(child);
	}
	
	public void print(int k) {
		for(int i = 0; i < k; ++i) {
			System.out.print(" ");
		}
		System.out.println(getValue());
		for(int i= 0; i < getNumChildren(); ++i) {
			((TreeConcrete) getChild(i)).print(k+1);
		}
	}

}
