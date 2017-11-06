package autoScrabble;



public class Baum {
	private KnotenA superKnoten;
	private String string;

	public Baum(String string) throws Exception {
		this.string = string;
		superKnoten = new KnotenA(0, string.length(), this);
	}
	
	
	public String getString() {
		return string;
	}


	public boolean check(int stelle1, int stelle2) {
		
		return false;
	}

	public KnotenA getSuperKnoten() {
		return superKnoten;
	}

	public void printAllKonten() {
		
	}
	@Override
	public String toString() {
		
		return "Baum[length="+string.length()+";string="+string+"]";
	}
}
