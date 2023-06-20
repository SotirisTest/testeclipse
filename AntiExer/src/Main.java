import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


// "static void main" must be defined in a public class.
public class Main {
	public static void main(String[] args) {

		String[] words = {"bats","tabs","in","cat","act"};
		String[] sentences = {"cat the bats", "in the act", "act tabs in"};
		int[] count = new int[sentences.length];

		HashMap<String, ArrayList<String>> map = new HashMap<>();
		HashMap<String, ArrayList<String>> mapToUse = new HashMap<>();
		for (String word : words) {
			char[] charArr = word.toCharArray();
			Arrays.sort(charArr);
			String sorted = new String(charArr);

			if (map.get(sorted) != null) {
				ArrayList<String> list = map.get(sorted);
				list.add(word);
				map.put(sorted, list);
				mapToUse.put(word, list);
			} else {
				ArrayList<String> list = new ArrayList<String>();
				list.add(word);
				map.put(sorted, list);
				mapToUse.put(word, list);
			}

		}
		int index = 0;
		for (String sentence : sentences) {
			int c = 1;
			String[] strArr = sentence.trim().split(" ");
			for (String str : strArr) {
				if (mapToUse.get(str) != null) {
					ArrayList<String> list = mapToUse.get(str);
					c = c * list.size();
				}
			}
			count[index++] = c;
		}

		for (int i = 0; i < count.length; i++) {
			System.out.println(count[i] + " ");
		}
	}

}