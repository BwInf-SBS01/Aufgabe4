import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AutoScrabbleMain {
  private static List<String> kuerzel = importiereKennzeichen();

  public static void main(String[] args) {

    schreibeWort("DONAUDAMPFSCHIFFFAHRTSKAPITÄNSMÜTZE");
    schreibeWort("BIBER");
    schreibeWort("CLINTON");
    schreibeWort("ETHERNET");
    schreibeWort("INFORMATIK");
    schreibeWort("LLANFAIRPWLLGWYNGYLLGOGERYCHWYRNDROBWLLLLANTYSILIOGOGOGOCH");
    schreibeWort("BUNDESWETTBEWERB");
    schreibeWort("RINDFLEISCHETIKETTIERUNGSÜBERWACHUNGSAUFGABENÜBERTRAGUNGSGESETZ");
    schreibeWort("SOFTWARE");
    schreibeWort("TRUMP");
    schreibeWort("TSCHÜSS");
    schreibeWort("VERKEHRSWEGEPLANUNGSBESCHLEUNIGUNGSGESETZ");
    
    System.out.println("fertig");
  }

  private static void istMoeglich(String string) {
    string = string.toUpperCase();
    string = string.replace("Ä", "AE");
    string = string.replace("Ö", "OE");
    string = string.replace("Ü", "UE");
    Baum baum;
    baum = new Baum(string);
    System.out.print(baum);
    if (baum.isGefunden()) {
      System.out.print(" ist möglich");
    } else {
      System.out.print(" ist nicht möglich");
    }
    System.out.println("");
    baum = null;
  }

  private static void schreibeWort(String string) {
    string = string.toUpperCase();
    string = string.replace("Ä", "AE");
    string = string.replace("Ö", "OE");
    string = string.replace("Ü", "UE");
    Baum baum;
    baum = new Baum(string);
    System.out.println(baum);
    baum.print();
    baum = null;

  }

  public static boolean isMoeglich(String string) {
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