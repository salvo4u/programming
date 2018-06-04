package careercup;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class SimilarWords {
	public static void main(String[] args) {
		String arr[] = { "plates", "stop", "staple", "pots", "meat", "not",
				"pot", "team" };//read from file
		HashMap<String, TreeSet<String>> hashMap = new HashMap<String, TreeSet<String>>();
		for (int i = 0; i < arr.length; i++) {
			String s = arr[i];
			char charr[] = s.toCharArray();
			Arrays.sort(charr);
			String sorted = new String(charr);
			if (hashMap.containsKey(sorted))
				hashMap.get(sorted).add(s);
			else {
				TreeSet<String> ts = new TreeSet<String>();
				ts.add(s);
				hashMap.put(sorted, ts);
			}
		}
		System.out.println(hashMap);
	}
}
