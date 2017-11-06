package autoScrabble;

public class KnotenB {
	private KnotenA child1 = null;
	private KnotenA child2 = null;
	public boolean gefunden = false;

	public KnotenB(int stelle, int length, Baum baum) throws Exception {
		if (stelle + 1 == length) {
			//System.out.println("gefunden");
			gefunden = true;
			throw new Exception("gef:"+baum.getString());
		}
		if (stelle + 2 == length) {
			//System.out.println("gefunden");
			gefunden = true;
			throw new Exception("gef:"+baum.getString());
		}
		if (stelle + 1 < length) {
			child1 = new KnotenA(stelle + 1, length, baum);
		}
		if (stelle + 2 < length) {
			child2 = new KnotenA(stelle + 2, length, baum);
		}

	}

	public KnotenA getChild1() {
		return child1;
	}

	public KnotenA getChild2() {
		return child2;
	}
}
