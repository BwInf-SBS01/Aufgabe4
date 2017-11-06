package autoScrabble;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AutoScrabbleMain {
	private static List<String> kuerzel = importiereKennzeichen();

	public static void main(String[] args) {
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
		

	}

	private static void schreibeWort(String string) {
		string = string.toUpperCase();
		string = string.replace("�", "AE");
		string = string.replace("�", "OE");
		string = string.replace("�", "UE");
		Baum baum;
		try {
			baum = new Baum(string);
			System.out.println(baum);
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			baum = null;
		}
		

	}

	public static boolean isMoeglich(String string) {
		return kuerzel.contains(string);
	}

	private static List<String> importiereKennzeichen() {
		List<String> kuerzel = new ArrayList<String>(684);
		try {
			@SuppressWarnings("resource")
			BufferedReader reader = new BufferedReader(new FileReader(new File("src/autoScrabble/" + "kuerzel.list")));
			String line;
			while ((line = reader.readLine()) != null) {
				kuerzel.add(line);
			}

		} catch (IOException e) {
			System.err.println("Couldn't load file!");
		}
		return kuerzel;
	}
}