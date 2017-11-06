package autoScrabble;

public class KnotenB {
	private KnotenA parent;
	private String segment;

	public KnotenB(int stelle, int length, Baum baum, KnotenA parent) {
		this.parent = parent;
		if (!baum.isGefunden()) {
			if (stelle + 1 == length) {
				segment = baum.getString().substring(stelle, stelle + 1);
				System.out.print("gefunden:");
				baum.setGefunden(this);
			}
			if (stelle + 2 == length) {
				segment = baum.getString().substring(stelle, stelle + 2);
				System.out.print("gefunden:");
				baum.setGefunden(this);
			}
			if (stelle + 1 < length) {
				segment = baum.getString().substring(stelle, stelle + 1);
				new KnotenA(stelle + 1, length, baum, this);
			}
			if (stelle + 2 < length) {
				segment = baum.getString().substring(stelle, stelle + 2);
				new KnotenA(stelle + 2, length, baum, this);
			}
		}
	}

	public void getParent(java.util.ArrayList<String> list) {
		list.add(segment);
		if(parent!=null) {
			parent.getParent(list);
		}
	}
}
