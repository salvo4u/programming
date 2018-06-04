package euler;
import java.math.BigInteger;
import java.util.*;

public class problem68 {
	private static Vector<String> allPerms(String a) {
		Vector<String> v = new Vector<String>();
		if (a.length() <= 1)
			v.add(a);
		else {
			String allButLastChar = a.substring(0, a.length() - 1);
			String lastChar = a.substring(a.length() - 1, a.length());
			Vector<String> permsSoFar = allPerms(allButLastChar);
			for (int i = 0; i < permsSoFar.size(); i++) {
				String curr = (String) permsSoFar.elementAt(i);
				for (int j = 0; j < a.length(); j++)
					v.add(generateSimplePerm(curr, lastChar, j));
			}
		}
		return v;
	}

	private static String generateSimplePerm(String s, String c, int position) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < position; i++)
			sb.append(s.charAt(i));
		sb.append(c);
		for (int i = position; i < s.length(); i++)
			sb.append(s.charAt(i));
		return sb.toString();
	}

	public static void main(String[] args) {
		String s = "ABCDEFGHIJ";
		long t1 = System.currentTimeMillis();
		Vector<String> v = allPerms(s);
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		map.put("A", 1);
		map.put("B", 2);
		map.put("C", 3);
		map.put("D", 4);
		map.put("E", 5);
		map.put("F", 6);
		map.put("G", 7);
		map.put("H", 8);
		map.put("I", 9);
		map.put("J", 10);
		BigInteger maxval = new BigInteger("0");
		for (int x = 0; x < v.size(); x++) {
			String str = v.get(x).toString();
			int arr[] = new int[10];
			for (int y = 0; y < 10; y++)
				arr[y] = map.get(str.charAt(y) + "");

			int sum = arr[0] + arr[1] + arr[5];
			int z = 0, flag = 0;
			for (z = 1; z < 5; z++) {
				if ((arr[z] + arr[(z + 1) % 5] + arr[z + 5]) != sum) {
					flag = 1;
					break;
				}
			}
			if (flag == 0) {
				HashMap<String, String> hm = new HashMap<String, String>();
				int arrsort[] = new int[5];
				if (arr[5] == 10 || arr[6] == 10 || arr[7] == 10
						|| arr[8] == 10 || arr[9] == 10) {
					String str1 = "";
					for (z = 0; z < 5; z++) {
						str1 = "";
						str1 = str1 + arr[z + 5];
						str1 = str1 + arr[z];
						str1 = str1 + arr[(z + 1) % 5];
						hm.put(arr[z + 5] + "", str1);
						arrsort[z] = arr[z + 5];
					}
					int min = arrsort[0], minpos = 0;
					str1 = "";

					for (z = 1; z < 5; z++) {
						if (min > arrsort[z]) {
							min = arrsort[z];
							minpos = z;
						}
					}
					for (z = minpos; z < minpos + 5; z++) {
						str1 = str1 + hm.get(arrsort[z % 5] + "");
					}

					BigInteger num = new BigInteger(str1);
					if (num.compareTo(maxval) == 1 && str1.length() == 16) {
						maxval = num;
					}
				}
			}

		}
		long t2 = System.currentTimeMillis();
		System.out.println(maxval);
		System.out.println("TIME:" + (t2 - t1) + " millisec");

	}
}
