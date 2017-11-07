



public class KnotenA {
  private KnotenB parent;
  private String segment;

  public KnotenA(int stelle, int length, Baum baum, KnotenB parent) {
    this.parent = parent;
    if (!baum.isGefunden()) {
      if (stelle + 1  < length) {
      }
      if (AutoScrabbleMain.isMoeglich(baum.getString().substring(stelle, stelle + 1))) {
        new KnotenB(stelle + 1, length, baum, this);
        segment = baum.getString().substring(stelle, stelle + 1);
      }

      if (stelle + 2  < length) {
        if (AutoScrabbleMain.isMoeglich(baum.getString().substring(stelle, stelle + 2))) {
          new KnotenB(stelle + 2, length, baum, this);
          segment = baum.getString().substring(stelle, stelle + 2);
        }
      }

      if (stelle + 3  < length) {
        if (AutoScrabbleMain.isMoeglich(baum.getString().substring(stelle, stelle + 3))) {
          new KnotenB(stelle + 3, length, baum, this);
          segment = baum.getString().substring(stelle, stelle + 3);
        }
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
