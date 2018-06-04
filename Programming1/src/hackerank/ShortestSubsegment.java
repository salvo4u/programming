package hackerank;

import java.util.HashMap;

public class ShortestSubsegment {
	public static void getSegment(String para, String search[]) {
		String paraarr[] = para.split(" ");
		HashMap<String, Integer> smap = new HashMap<String, Integer>();
		
		int searchlength = search.length;
		for (int i = 0; i < search.length; i++) {
			if (!smap.containsKey(search[i]))
				smap.put(search[i], 1);
			else {
				int freq = smap.get(search[i]);
				smap.put(search[i], freq + 1);
			}
		}
		int minpos = Integer.MAX_VALUE;
		int maxpos = Integer.MIN_VALUE;
		
		for (int i = 0; i < paraarr.length; i++) {
			String word = paraarr[i];
			if (smap.containsKey(word)) {
				
				int value = smap.get(word);
				if (searchlength == 0 && value == 0) {
					
				} else {
					smap.put(word, value - 1);
					searchlength--;
					
					if (searchlength == search.length)
						minpos = i;

					if (searchlength == 0)
						maxpos = i;

				}
			}
		}
	}

	public static void main(String[] args) {

	}
}
