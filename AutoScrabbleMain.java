import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AutoScrabbleMain {
  private static List<String> kuerzel = importiereKennzeichen();
  private static BufferedWriter writer = null;
  public static void main(String[] args) {
    
    
    write("\n");
    istMoeglich("DONAUDAMPFSCHIFFFAHRTSKAPITÄNSMÜTZE");
    istMoeglich("BIBER");
    istMoeglich("CLINTON");
    istMoeglich("ETHERNET");
    istMoeglich("INFORMATIK");
    istMoeglich("LLANFAIRPWLLGWYNGYLLGOGERYCHWYRNDROBWLLLLANTYSILIOGOGOGOCH");
    istMoeglich("BUNDESWETTBEWERB");
    istMoeglich("RINDFLEISCHETIKETTIERUNGSÜBERWACHUNGSAUFGABENÜBERTRAGUNGSGESETZ");
    istMoeglich("SOFTWARE");
    istMoeglich("TRUMP");
    istMoeglich("TSCHÜSS");
    istMoeglich("VERKEHRSWEGEPLANUNGSBESCHLEUNIGUNGSGESETZ");
    
    write("\n");
    
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
    
    write("\n");
    try {
      writer.close();
    } catch(IOException e) {
      System.err.println("Error writing File");
    } 
    
    
  }
  
  private static void istMoeglich(String string) { // erstellt einen neuen Baum, und gibt aus, ob das Kennzeichen
    // darstellbar ist
    string = string.toUpperCase();
    string = string.replace("Ä", "AE");
    string = string.replace("Ö", "OE");
    string = string.replace("Ü", "UE");
    Baum baum;
    baum = new Baum(string);
    write(baum.toString());
    
    if (baum.isGefunden()) {
      write(" ist möglich");
    } else {
      write(" ist nicht möglich");
    }
    write("");
    baum = null;
  }
  
  private static void schreibeWort(String string) { // erstellt einen neuen Baum, und gibt die einzelnen Kennzeichen
    // mit der Baum.print() Methode aus
    string = string.toUpperCase();
    string = string.replace("Ä", "AE");
    string = string.replace("Ö", "OE");
    string = string.replace("Ü", "UE");
    Baum baum;
    baum = new Baum(string);
    write(baum.toString());
    baum.print();
    baum = null;
    
  }
  
  public static boolean istVorhanden(String string) { // gibt einen Wahrheitswert zurück, ob das Kürzel in der Liste
    // gespeichert ist
    return kuerzel.contains(string);
  }
  
  private static List<String> importiereKennzeichen() { // ließt die Kürzelliste ein
    List<String> kuerzel = new ArrayList<String>(683);
    try {
      @SuppressWarnings("resource")
      BufferedReader reader = new BufferedReader(new FileReader(new File("kuerzel.list")));
      String line;
      while ((line = reader.readLine()) != null) {
        kuerzel.add(line.trim());
      }
    } catch (IOException e) {
      System.err.println("Liste: 'kuerzel.list' konnte nicht geladen werden !!!");
    }
    return kuerzel;
  }
  
  public static void write(String string){
    try {
      if(writer == null){
        File out = new File("ergebnis.txt");
        out.delete();
        writer = new BufferedWriter(new FileWriter(out));
        
      }
      writer.newLine();
      writer.write(string);
      System.out.println(string);
    } catch (IOException e) {
      System.err.println("Error writing File!");
    }
    
  }   
}
  
