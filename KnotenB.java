public class KnotenB {
	private KnotenA parent;
	private String segment;

	public KnotenB(int stelle, int length, Baum baum, KnotenA parent) {
		this.parent = parent;

		if (stelle + 0 == length && !baum.isGefunden()) { //
			segment = baum.getSubstring(stelle, stelle + 1);
			baum.setGefunden(this);
			return;
		}
		if (stelle + 1 == length && !baum.isGefunden()) {
			segment = baum.getSubstring(stelle, stelle + 2);
			baum.setGefunden(this);
			return;
		}
		if (stelle + 1 < length && !baum.isGefunden()) {
			segment = baum.getSubstring(stelle, stelle + 1);
			new KnotenA(stelle + 1, length, baum, this);
		}
		if (stelle + 2 < length && !baum.isGefunden()) {
			segment = baum.getSubstring(stelle, stelle + 2);
			new KnotenA(stelle + 2, length, baum, this);
		}
	}

	public void getParent(java.util.ArrayList<String> list) {
		list.add(segment);
		if (parent != null) {
			parent.getParent(list);
		}
	}
}
