package autoScrabble;

import java.util.ArrayList;

public class Baum {

	private String string;
	private boolean gefunden = false;
	private KnotenB gefundenerKnoten;

	public Baum(String string) {
		this.string = string;
		new KnotenA(0, string.length(), this, null);
	}

	public String getString() {
		return string;
	}

	@Override
	public String toString() {

		return "Baum[" + string + "]";
	}

	public boolean isGefunden() {
		return gefunden;
	}

	public void setGefunden(KnotenB knoten) {
		this.gefunden = true;
		gefundenerKnoten = knoten;
	}
	public void print() {
		if(gefunden) {
			ArrayList<String> list = new ArrayList<String>();
			gefundenerKnoten.getParent(list);
			list.trimToSize();
			for (int i = 0; i < list.size(); i+=2) {
				System.out.print(list.get(list.size()-i-1)+"-"+list.get(list.size()-i-2)+" ");
			}
			System.out.println(" ");
			System.out.println(" ");
		}else {
			System.out.println("nicht Darstellbar");
			System.out.println(" ");
		}
	}

}
