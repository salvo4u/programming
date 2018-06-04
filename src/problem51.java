import java.util.HashMap;
import java.util.Vector;

public class problem51 {
	public static boolean isPrime(int n1) {
		int num = n1;
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String args[]) {
		Vector<Integer> v = new Vector<Integer>();
		Vector<Integer> v1 = new Vector<Integer>();

		HashMap<Integer, String> h = new HashMap<Integer, String>();
		for (int i = 100001; i < 1000000; i = i + 2) {
			if (isPrime(i))
				v.add(i);
		}
		System.out.println(v.size());

		// 1.break the prime vector into frequencies of each digit in the number
		for (int i = 0; i < v.size(); i++) {
			String number = v.get(i) + "";
			char ch = number.charAt(number.length() - 1);
			int arr[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			for (int j = 0; j < number.length(); j++) {
				arr[number.charAt(j) - 48]++;
			}

			if (arr[ch - 48] > 1)
				continue;
			else {
				for (int k = 0; k < 10; k++) {
					if (arr[k] > 2) {
						v1.add(v.get(i));

						break;
					}
				}
			}

		}
		for (int i = 0; i < v1.size(); i++) {
			String number = v1.get(i) + "";
			int arr[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

			for (int j = 0; j < number.length(); j++) {
				arr[number.charAt(j) - 48]++;
			}		
			
			for (int j = 0; j < 10; j++) {
				if (arr[j] == 3) {
					System.out.println(number+"  "+arr[j]);
					int count = 0;
					String b = "";
					for (int k = 0; k < 10; k++) {
						b = "";
						for (int x = 0; x < number.length(); x++) {
							if (number.charAt(x) - 48 == j) {
								b = b + (k + "");
								continue;
							}
							b = b + number.charAt(x);
						}
						if(v1.contains(b)){
							count++;
							System.out.println(b);
						}
					}
				}
			}
		}
		System.out.println(v1.size());
		System.out.println(v1);
	}
}
