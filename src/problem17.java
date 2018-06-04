import java.util.HashMap;

public class problem17 {
	public static void main(String[] args) {

		String myten = "ten";

		String arr1[] = { "one", "two", "three", "four", "five", "six",
				"seven", "eight", "nine" };

		String arr2[] = { "eleven", "twelve", "thirteen", "fourteen",
				"fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };

		String arr3[] = { "twenty", "thirty", "forty", "fifty", "sixty",
				"seventy", "eighty", "ninety" };

		HashMap<Integer, String> hmap = new HashMap<Integer, String>();
		HashMap<Integer, String> hnmap = new HashMap<Integer, String>();

		int key = 1;
		int total = 0;
		for (int i = 0; i < arr1.length; i++) {
			hmap.put(key++, arr1[i]);
			System.out.println(arr1[i]);
			total = total + arr1[i].length();
		}

		hmap.put(key++, myten);
		System.out.println(myten);
		total = total + myten.length();

		for (int i = 0; i < arr2.length; i++) {
			hmap.put(key++, arr2[i]);
			System.out.println(arr2[i]);
			total = total + arr2[i].length();

		}

		for (int i = 0; i < arr3.length; i++) {
			hmap.put(key++, arr3[i]);
			total = total + arr3[i].length();

			System.out.println(arr3[i]);
			for (int j = 0; j < arr1.length; j++) {
				System.out.println(arr3[i] + " " + arr1[j]);
				hmap.put(key++, arr3[i] + " " + arr1[j]);
				total = total + (arr3[i] + arr1[j]).length();
			}
		}
		key = 0;
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i] + " hundred");
			hnmap.put(key++, arr1[i] + " hundred");
			total+=(arr1[i] + " hundred").length();
			for (int j = 1; j < 100; j++) {
				String value = (String) hmap.get(j);
				System.out.println(arr1[i] + " hundred and " + value);
				hnmap.put(key++, arr1[i] + " hundred and " + value);

				total+=(arr1[i] + "hundredand" + value).length();
			}
		}
		total+=("One Thousand").length();
		System.out.println("One Thousand");
		//System.out.println(total);
	}
}
