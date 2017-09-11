package autoScrabble;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Werkzeuge {
	public static List<List<Integer>> wirklichAlleKennzeichenMöglichkeiten(int target) {
		List<List<Integer>> fastAlleKennzeichenMöglichkeiten = getAllPossiblePartitions(target);
		List<List<Integer>> wirklichAlleKennzeichenMöglichkeiten = new ArrayList<List<Integer>>();
		for (List<Integer> listfastAlleKennzeichenMöglichkeiten : fastAlleKennzeichenMöglichkeiten) {
			List<List<Integer>> alleMöglichkeiten = getAllPermutations(listfastAlleKennzeichenMöglichkeiten);
			for (List<Integer> listalleMöglichkeiten : alleMöglichkeiten) {
				wirklichAlleKennzeichenMöglichkeiten.add(listalleMöglichkeiten);
			}
		}

		//for (List<Integer> kennzeichenKombo : wirklichAlleKennzeichenMöglichkeiten) 
			//System.out.println(kennzeichenKombo);
		return wirklichAlleKennzeichenMöglichkeiten;
	}

	private static <X> List<List<X>> getAllPermutations(List<X> sequence) {
		return getAllPermutationsRecursion(sequence, new boolean[sequence.size()], sequence.size());
	}

	@SuppressWarnings("hiding")
	private static <Integer> List<List<Integer>> getAllPermutationsRecursion(List<Integer> sequence, boolean[] used,
			int available) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		if (available != 0) {
			int usedIndex = 0;
			for (Iterator<Integer> i = sequence.iterator(); i.hasNext(); usedIndex++) {
				Integer currentElement = i.next();
				if (used[usedIndex]) {
					continue;
				} else {
					used[usedIndex] = true;
					for (List<Integer> permutation : getAllPermutationsRecursion(sequence, used, available - 1)) {
						permutation.add(currentElement);
						result.add(permutation);
					}
					used[usedIndex] = false;
				}
			}
		} else {
			result.add(new LinkedList<Integer>());
		}
		return result;
	}

	private static List<List<Integer>> getAllPossiblePartitions(int target) {
		List<String> data = makePartitions(target);
		List<List<Integer>> list = new LinkedList<List<Integer>>();
		for (String string : data) {
			String[] split = string.split("/");
			LinkedList<Integer> kennzeichenmöglichkeiten = new LinkedList<Integer>();
			boolean wahreKennzeichen = true;
			for (int i = 0; i < split.length; i++) {
				int zahl = Integer.parseInt(split[i]);
				if (zahl >= 2 && zahl <= 5) {
					kennzeichenmöglichkeiten.add(zahl);
				} else {
					wahreKennzeichen = false;
				}
			}
			if (wahreKennzeichen) {
				list.add(kennzeichenmöglichkeiten);
			}
		}
		return list;
	}

	private static List<String> makePartitions(int target) {
		List<String> list = new ArrayList<String>();
		makePartitions(target, target, "", list);
		return list;
	}

	private static void makePartitions(int target, int maxValue, String suffix, List<String> list) {
		if (target == 0) {
			list.add(suffix);
		} else {
			if (maxValue > 1)
				makePartitions(target, maxValue - 1, suffix, list);
			if (maxValue <= target)
				makePartitions(target - maxValue, maxValue, maxValue + "/" + suffix, list);
		}
	}
}
