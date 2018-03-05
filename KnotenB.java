public class KnotenB {
  private KnotenA parent;
  private String segment;

  public KnotenB(int stelle, int length, Baum baum, KnotenA parent) {
    this.parent = parent;

    if (stelle + 0 == length && !baum.isGefunden()) { // prüft, ob die Länge des Wortes genau erreicht wurde; wobei
                              // der hintere Teil des Kennzeichens ein Buchstabe lang ist
                              // und setzt ggf. die Gefunden-Markierung
      segment = baum.getSubstring(stelle, stelle + 1);
      baum.setGefunden(this);
      return;
    }
    if (stelle + 1 == length && !baum.isGefunden()) { // prüft, ob die Länge des Wortes genau erreicht wurde; wobei
                              // der hintere Teil des Kennzeichens zwei Buchstaben lang
                              // ist und setzt ggf. die Gefunden-Markierung
      segment = baum.getSubstring(stelle, stelle + 2);
      baum.setGefunden(this);
      return;
    }
    if (stelle + 1 < length && !baum.isGefunden()) { // wenn die Länge mit einem hinteren Buchstaben noch nicht
                              // erreicht ist, wird ein weiterer Knoten erstellt
      segment = baum.getSubstring(stelle, stelle + 1);
      new KnotenA(stelle + 1, length, baum, this);
    }
    if (stelle + 2 < length && !baum.isGefunden()) {
      segment = baum.getSubstring(stelle, stelle + 2); // wenn die Länge mit zwei hinteren Buchstaben noch nicht
                                // erreicht ist, wird ein weiterer Knoten erstellt
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
