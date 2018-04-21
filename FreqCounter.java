import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Frequency counter for a vigenere cipher for CYBR171
 * @author Hayden Andersen
 */

public class FreqCounter {
	private FreqCounter() {
		splitToFour("WIEVHSMYRSMCVBPROJEFWPCQPQUVHSSEDNEHUPMLRINDUVNPHSSUFJEPFFFKFUIQQDL\n" +
				"CVTIEWIEUKPCMZBVGUJDGUUHGQPVGOEEUFSIDHEHQZBRGEFLERNPWWFRRUPGTDNMG\n" +
				"UDRGDUEFDQRQJSAOFBLNHETCSFWQUNWJLDHYDTRGOFAUHEIPWPAPRNNKSPTGQUCQP\n" +
				"QUVHSNGWXOTNVSGGCYCQBUVRDRCWJCIRWETQNEPWUOEROTTRMIVVQEQSMEVKFGQY\n" +
				"FRPPFNVKBDVRUUTQPFHWIEERNPWWFRPHUWQULTJXTDGVURQBJNILUSEROTTRMIPRSD\n" +
				"GUUOGUBDKFBTGWIEYRSMDUVNPHSSDRPKKVBBQXUAUFMOUHBSORTTXPTCQPQUVHSN\n" +
				"GWXOTNNAPDHETVXOWOEEXHSHCYFCQPFTQDSECOSOIXFWQUNUPWJLVKFLCWFSYRSM\n" +
				"UZFRGRCSEXSEVKJNIVNOTHBSURDICWFDYLUHTHTECUDHKQBCQPQUVHSLCEPRCWPRAI\n" +
				"PRGABMROFAHHXBGQFVQOFNVZPROVXETHEEXHMORHEBAAFRQASEUHBREKFRUZIOYDO\n" +
				"TGGUOODLEORSEGIGIELFNVXTEQIDOOSVTGUGAELMIVLFSVKFYFHWENRQEFDUOYQDRK\n" +
				"HSWQUNWJLDHORWEFWIRQXHHCQFTYRSKUHODKQHOWWJMRRSTCQUAPQPUPFFMGQUS\n" +
				"VKFITGJAIQPSVLDWQUNANVPCQQTTCQULAZFAXHETJUPUIKUHGQFTYRSKDXUTJLT\n");
	}

	private void splitToFour(String s) {
		char[] phrase = s.toCharArray();
		int counter = 0;
		ArrayList<Character> one = new ArrayList<>();
		ArrayList<Character> two = new ArrayList<>();
		ArrayList<Character> three = new ArrayList<>();
		ArrayList<Character> four = new ArrayList<>();
		for (char c: phrase) {
			if (c == '\n') continue;
			switch (counter) {
				case 0: one.add(c); break;
				case 1: two.add(c); break;
				case 2: three.add(c); break;
				case 3: four.add(c); break;
			}
			counter = (counter + 1)%4;
		}
		System.out.print("First: ");
		countLetters(one);
		System.out.print("Second: ");
		countLetters(two);
		System.out.print("Third: ");
		countLetters(three);
		System.out.print("Fourth: ");
		countLetters(four);

	}

	private void countLetters(ArrayList<Character> letters) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (Character c: letters) {
			if (map.containsKey(c)) map.put(c, map.get(c) + 1);
			else map.put(c, 1);
		}
		System.out.println(map);
		findBiggest(map);
		System.out.println();
	}

	private void findBiggest(HashMap<Character, Integer> map) {
		char c = ' ';
		int value = 0;
		for (Map.Entry<Character, Integer> e: map.entrySet()) {
			if (e.getValue() > value) {
				c = e.getKey();
				value = e.getValue();
			}
		}
		System.out.println("Biggest is " + c + " with " + value);
	}

	public static void main(String[] args) {
		new FreqCounter();
	}
}
