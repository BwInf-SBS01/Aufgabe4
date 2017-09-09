package autoScrabble;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AutoScrabbleMain {

	private static List<String> kuerzel = new ArrayList<String>();

	public static void main(String[] args) {
		importiereKennzeichen("kuerzelliste.txt");
		System.out.println(istMöglich(""));
	}

	private static boolean istMöglich(String s) {
		s = s.toUpperCase();
		char[] buchstaben = s.toCharArray();
		int laenge = s.length();
		boolean gefunden = false; 
		int i = 0;
		do {
			
		}while(i<laenge);
		/*
		 * TODO Möglichkeiten: kennz-egal 1-1 1-2 2-1 2-2 3-1 3-2
		 */

		return gefunden;
	}

	private boolean check(String kennzeichen) {
		return kuerzel.contains(kennzeichen);
	}

	private static void importiereKennzeichen(String file) {
		FileReader fr = null;
		try {
			fr = new FileReader(new File("src/autoScrabble/" + file));
			@SuppressWarnings("resource")
			BufferedReader reader = new BufferedReader(fr);
			
			String line;
			do {
				line = reader.readLine();
				kuerzel.add(line);
			} while (line != null);
			kuerzel.remove(kuerzel.size() - 1);
		} catch (IOException e) {
			System.err.println("Couldn't load file!");
		}
	}

}
