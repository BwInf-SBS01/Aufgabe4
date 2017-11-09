import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AutoScrabbleMain {
  private static List<String> kuerzel = importiereKennzeichen();

  public static void main(String[] args) {
    System.out.println("\n");
    istMoeglich("DONAUDAMPFSCHIFFFAHRTSKAPIT�NSM�TZE");
    istMoeglich("BIBER");
    istMoeglich("CLINTON");
    istMoeglich("ETHERNET");
    istMoeglich("INFORMATIK");
    istMoeglich("LLANFAIRPWLLGWYNGYLLGOGERYCHWYRNDROBWLLLLANTYSILIOGOGOGOCH");
    istMoeglich("BUNDESWETTBEWERB");
    istMoeglich("RINDFLEISCHETIKETTIERUNGS�BERWACHUNGSAUFGABEN�BERTRAGUNGSGESETZ");
    istMoeglich("SOFTWARE");
    istMoeglich("TRUMP");
    istMoeglich("TSCH�SS");
    istMoeglich("VERKEHRSWEGEPLANUNGSBESCHLEUNIGUNGSGESETZ");

    System.out.println("\n");
    
    schreibeWort("DONAUDAMPFSCHIFFFAHRTSKAPIT�NSM�TZE");
    schreibeWort("BIBER");
    schreibeWort("CLINTON");
    schreibeWort("ETHERNET");
    schreibeWort("INFORMATIK");
    schreibeWort("LLANFAIRPWLLGWYNGYLLGOGERYCHWYRNDROBWLLLLANTYSILIOGOGOGOCH");
    schreibeWort("BUNDESWETTBEWERB");
    schreibeWort("RINDFLEISCHETIKETTIERUNGS�BERWACHUNGSAUFGABEN�BERTRAGUNGSGESETZ");
    schreibeWort("SOFTWARE");
    schreibeWort("TRUMP");
    schreibeWort("TSCH�SS");
    schreibeWort("VERKEHRSWEGEPLANUNGSBESCHLEUNIGUNGSGESETZ");
    
    System.out.println("\n");
  }

  private static void istMoeglich(String string) {
    string = string.toUpperCase();
    string = string.replace("�", "AE");
    string = string.replace("�", "OE");
    string = string.replace("�", "UE");
    Baum baum;
    baum = new Baum(string);
    System.out.print(baum);
    if (baum.isGefunden()) {
      System.out.print(" ist m�glich");
    } else {
      System.out.print(" ist nicht m�glich");
    }
    System.out.println("");
    baum = null;
  }

  private static void schreibeWort(String string) {
    string = string.toUpperCase();
    string = string.replace("�", "AE");
    string = string.replace("�", "OE");
    string = string.replace("�", "UE");
    Baum baum;
    baum = new Baum(string);
    System.out.println(baum);
    baum.print();
    baum = null;

  }

  public static boolean istVorhanden(String string) {
    return kuerzel.contains(string);
  }

  private static List<String> importiereKennzeichen() {
    List<String> kuerzel = new ArrayList<String>(684);
    try {
      @SuppressWarnings("resource")
      BufferedReader reader = new BufferedReader(new FileReader(new File("kuerzel.list")));
      String line;
      while ((line = reader.readLine()) != null) {
        kuerzel.add(line.trim());
      }
    } catch (IOException e) {
      System.err.println("Couldn't load file!");
    }
    return kuerzel;
  }
}