package euler;
import java.util.HashMap;
import java.util.Vector;

public class problem62 {
	public static Vector<Integer> v8 = new Vector<Integer>();
	public static int number;
	public static HashMap<Integer, Vector<Integer>> hash = new HashMap<Integer, Vector<Integer>>();
	public static HashMap<Integer, Integer> hash11 = new HashMap<Integer, Integer>();

	public static Vector<Integer> per;

	public static void permuteString(String beginningString, String endingString) {
		if (endingString.length() <= 1) {
			String s = beginningString + endingString;
			int num = new Integer(s);

			if (v8.contains(num) && per.contains(num) == false) {
				per.add(num);
				hash11.put(num, number);
			}
		} else
			for (int i = 0; i < endingString.length(); i++) {
				try {
					String newString = endingString.substring(0, i)
							+ endingString.substring(i + 1);

					permuteString(beginningString + endingString.charAt(i),
							newString);
				} catch (StringIndexOutOfBoundsException exception) {
					exception.printStackTrace();
				}
			}
	}

	public static void main(String args[]) {
		int x = 0;
		for (int i = 464; i <= 1000; i++) {
			x = i * i * i;
			if ((x + "").length() == 9) {
				v8.add(x);
			}
		}
		System.out.println(v8);
		for (int i = 0; i < v8.size(); i++) {
			number = v8.get(i);
			if (hash11.get(number) == null) {
				per = new Vector<Integer>();
				permuteString("", number + "");
				if (hash.get(number) == null)
					hash.put(number, per);
			}
			per = hash.get(hash11.get(number));
			if (per.size() == 3) {
				System.out.println(per);
				System.exit(1);
			}
		}
	}
}
