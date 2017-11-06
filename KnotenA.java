package autoScrabble;

public class KnotenA {
	private KnotenB child1 = null;
	private KnotenB child2 = null;
	private KnotenB child3 = null;

	public KnotenA(int stelle, int length, Baum baum) throws Exception {
		if (stelle + 1 + 1 <= length) {
			if (AutoScrabbleMain.isMoeglich(baum.getString().substring(stelle, stelle + 1))) {
				child1 = new KnotenB(stelle + 1, length, baum);
			}
		}
		if (child1 != null && child1.gefunden) {
			return;
		}
		if (stelle + 2 + 1 <= length) {
			if (AutoScrabbleMain.isMoeglich(baum.getString().substring(stelle, stelle + 2))) {
				child2 = new KnotenB(stelle + 2, length, baum);
			}
		}
		if (child2 != null && child2.gefunden) {
			return;
		}
		if (stelle + 3 + 1 <= length) {
			if (AutoScrabbleMain.isMoeglich(baum.getString().substring(stelle, stelle + 3))) {
				child3 = new KnotenB(stelle + 3, length, baum);
			}
		}
	}

	public KnotenB getChild1() {
		return child1;
	}

	public KnotenB getChild2() {
		return child2;
	}

	public KnotenB getChild3() {
		return child3;
	}

}
