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
		System.out.println(istMöglich("NIKLAS"));
	}

	private static boolean istMöglich(String string) {
		boolean antwort;
		string.toUpperCase();
		//TODO
		
		antwort = kuerzel.contains(string.substring(0, 2)) && kuerzel.contains(string.substring(2, 4));
		return antwort;
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
