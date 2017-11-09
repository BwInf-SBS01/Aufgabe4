public class KnotenA {
  private KnotenB parent;
  private String segment;

  public KnotenA(int stelle, int length, Baum baum, KnotenB parent) {
    this.parent = parent;
    if (stelle + 1 <= length && !baum.isGefunden()) {// repräsentiert den ersten Teil
                              // eines Kennzeichens mit der
                              // Länge 1
      if (AutoScrabbleMain.istVorhanden(baum.getSubstring(stelle, stelle + 1))) {
        segment = baum.getSubstring(stelle, stelle + 1);
        new KnotenB(stelle + 1, length, baum, this);
      }
    }
    if (stelle + 2 <= length && !baum.isGefunden()) {// repräsentiert den ersten Teil
                              // eines Kennzeichens mit der
                              // Länge 2
      if (AutoScrabbleMain.istVorhanden(baum.getSubstring(stelle, stelle + 2))) {
        segment = baum.getSubstring(stelle, stelle + 2);
        new KnotenB(stelle + 2, length, baum, this);
      }
    }
    if (stelle + 3 <= length && !baum.isGefunden()) {// repräsentiert den ersten Teil
                              // eines Kennzeichens mit der
                              // Länge 3
      if (AutoScrabbleMain.istVorhanden(baum.getSubstring(stelle, stelle + 3))) {
        segment = baum.getSubstring(stelle, stelle + 3);
        new KnotenB(stelle + 3, length, baum, this);
      }
    }
  }

  public void getParent(java.util.ArrayList<String> list) { // wird zu schrieben benötigt siehe Baum.print();
    list.add(segment);
    if (parent != null) {
      parent.getParent(list);
    }
  }
}
