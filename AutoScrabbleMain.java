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
		System.out.println("istMöglich(Tobias)="+istMöglich("Tobias"));
		schreibeWort("Niklas");
	}

	private static boolean istMöglich(String s) {
		s = s.toUpperCase();
		s = s.replaceAll("Ä", "AE");
		s = s.replaceAll("Ü", "UE");
		s = s.replaceAll("Ö", "OE");
		boolean gefunden = false;
		List<List<Integer>> listeAllerKennzeichenMöglichkeiten = Werkzeuge
				.wirklichAlleKennzeichenMöglichkeiten(s.length());
		List<List<String>> listeAllerKennzeichenBuchstaben = new ArrayList<List<String>>();
		for (List<Integer> Kennzeichen : listeAllerKennzeichenMöglichkeiten) {
			List<String> KennzeichenBuchstaben = new ArrayList<String>();
			int i = 0;
			int kennzeichenNummer = 0;
			while (i < s.length()) {
				KennzeichenBuchstaben.add(s.substring(i, i + Kennzeichen.get(kennzeichenNummer)));
				i += Kennzeichen.get(kennzeichenNummer);
				kennzeichenNummer++;
			}
			listeAllerKennzeichenBuchstaben.add(KennzeichenBuchstaben);
		}
		for (List<String> list : listeAllerKennzeichenBuchstaben) {
			String[] strings = new String[list.size()];
			for (int i = 0; i < list.size(); i++) {
				strings[i] = list.get(i);
			}
			if(prüfeKennzeichen(strings)) {
				gefunden = true;
			}
		}
		return gefunden;
	}
	
	private static boolean schreibeWort(String s) {
		s = s.toUpperCase();
		s = s.replaceAll("Ä", "AE");
		s = s.replaceAll("Ü", "UE");
		s = s.replaceAll("Ö", "OE");
		boolean gefunden = false;
		List<List<Integer>> listeAllerKennzeichenMöglichkeiten = Werkzeuge
				.wirklichAlleKennzeichenMöglichkeiten(s.length());
		List<List<String>> listeAllerKennzeichenBuchstaben = new ArrayList<List<String>>();
		for (List<Integer> Kennzeichen : listeAllerKennzeichenMöglichkeiten) {
			List<String> KennzeichenBuchstaben = new ArrayList<String>();
			int i = 0;
			int kennzeichenNummer = 0;
			while (i < s.length()) {
				KennzeichenBuchstaben.add(s.substring(i, i + Kennzeichen.get(kennzeichenNummer)));
				i += Kennzeichen.get(kennzeichenNummer);
				kennzeichenNummer++;
			}
			listeAllerKennzeichenBuchstaben.add(KennzeichenBuchstaben);
		}
		for (List<String> list : listeAllerKennzeichenBuchstaben) {
			String[] strings = new String[list.size()];
			for (int i = 0; i < list.size(); i++) {
				strings[i] = list.get(i);
			}
			if(prüfeKennzeichen(strings)) {
				gefunden = true;
				for (int i = 0; i < strings.length; i++) {
					System.out.print(strings[i]+"-");
				}
				System.out.println("");
			}
		}
		return gefunden;
	}

	private static boolean prüfeKennzeichen(String[] kennzeichen) {
		boolean antwort = true;
		for (int i = 0; i < kennzeichen.length; i++) {
			boolean aktuelleAntwort = false;
			if (kennzeichen[i].length() == 2) {
				aktuelleAntwort = prüfeKürzel(kennzeichen[i].substring(0, 1));
			} else if (kennzeichen[i].length() == 3) {
				aktuelleAntwort = prüfeKürzel(kennzeichen[i].substring(0, 1))
						|| prüfeKürzel(kennzeichen[i].substring(0, 2));
			} else if (kennzeichen[i].length() == 4) {
				aktuelleAntwort = prüfeKürzel(kennzeichen[i].substring(0, 2))
						|| prüfeKürzel(kennzeichen[i].substring(0, 3));
			} else if (kennzeichen[i].length() == 5) {
				aktuelleAntwort = prüfeKürzel(kennzeichen[i].substring(0, 3));
			}
			if (!aktuelleAntwort) {
				antwort = false;
				break;
			} else {
				continue;
			}
		}

		return antwort;
	}

	private static boolean prüfeKürzel(String kürzel) {
		return kuerzel.contains(kürzel);
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
