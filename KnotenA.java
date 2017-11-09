public class KnotenA {
  private KnotenB parent;
  private String segment;

  public KnotenA(int stelle, int length, Baum baum, KnotenB parent) {
    this.parent = parent;
    if (stelle + 1 <= length && !baum.isGefunden()) {
      if (AutoScrabbleMain.isMoeglich(baum.getString().substring(stelle, stelle + 1))) {
        segment = baum.getString().substring(stelle, stelle + 1);
        new KnotenB(stelle + 1, length, baum, this);
      }
    }
    if (stelle + 2 <= length && !baum.isGefunden()) {
      if (AutoScrabbleMain.isMoeglich(baum.getString().substring(stelle, stelle + 2))) {
        segment = baum.getString().substring(stelle, stelle + 2);
        new KnotenB(stelle + 2, length, baum, this);
      }
    }
    if (stelle + 3 <= length && !baum.isGefunden()) {
      if (AutoScrabbleMain.isMoeglich(baum.getString().substring(stelle, stelle + 3))) {
        segment = baum.getString().substring(stelle, stelle + 3);
        new KnotenB(stelle + 3, length, baum, this);
      }
    }
  }

  public void getParent(java.util.ArrayList<String> list) {
    list.add(segment);
    if (parent != null) {
      parent.getParent(list);
    }
  }

}
