@SuppressWarnings("unused")
public class Baum {

	private String string; // Speichert den übergebenen String, der Dargetellt werden
							// soll.
	private boolean gefunden = false; // Markierung, ob schon eine Möglichkeit der
										// darstllung gefunden wurde.
	private KnotenA rootKnoten; // Speichert den ersten/root Knoten.
	private KnotenB gefundenerKnoten; // Speichert den letzten B-Konten der für das
										// Schreiben wichtig ist.

	public Baum(String string) {
		this.string = string;
		rootKnoten = new KnotenA(0, string.length() - 1, this, null); // Ersellt denersten Knoten (stelle = 0, länge
																		// =stringlänge,die Speicheradresse des Baums,
																		// null -> keinübergeordneterKnoten)
	}

	public String getSubstring(int stelle1, int stelle2) { // Funktion für die Knoten;
															// gibt einen Teil, des
		return this.string.substring(stelle1, stelle2);// darzustellenden Wortes, damit
														// der Knoten ihn dann
														// überprüfen kann.
	}

	public boolean isGefunden() { // Funktion für die Knoten; gibt Auskunft, ob weiter
									// gesucht werden soll.
		return this.gefunden;
	}

	public void setGefunden(KnotenB knoten) {// Setzen der Markierung; wird vom letzten
												// Konten aufgerufen, der sich
												// selbst übergibt und dann gespeichtert
												// wird.
		this.gefunden = true;
		this.gefundenerKnoten = knoten;
	}

	public void print() {// schreibt die Kennzeichen, indem eine Liste erstellt und von
							// dem unersten
							// Konten immer zum nächst höheren gegeben wird und dabei
							// ergänzt wird
		if (gefunden) {
			java.util.ArrayList<String> list = new java.util.ArrayList<String>();
			this.gefundenerKnoten.getParent(list);
			list.trimToSize();
			for (int i = 0; i < list.size(); i += 2) {
				System.out.print(list.get(list.size() - i - 1) + "-" + list.get(list.size() - i - 2) + " ");
			}
		} else {
			System.out.print("nicht Darstellbar");
		}
		System.out.println("");
	}

	@Override
	public String toString() {
		return "[" + string + "]";
	}

}
