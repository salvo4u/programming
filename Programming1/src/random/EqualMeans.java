package random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EqualMeans {
	public static void allPermutations(String s, int i, int mainarr[]) {
		if (i == s.length()) {
			String perm = s + "";
			int arr[] = new int[perm.length()];
			for (int j = 0; j < perm.length(); j++) {
				arr[j] = mainarr[(perm.charAt(j) - 65)];
				System.out.print(arr[j] + " ");
			}
			System.out.println();
			for (int k = 1; k < arr.length - 1; k++) {
				int sum1 = 0;
				for (int l = 0; l < k; l++)
					sum1 += arr[l];
				int sum2 = ARRSUM - sum1;
				float mean1 = sum1 / (float) k;
				float mean2 = sum2 / (float) (arr.length - k);
				if (mean1 == mean2) {
					System.out.println("--------------");
					for (int l = 0; l < k; l++)
						System.out.print(arr[l]);

					System.out.println();

					for (int l = k; l < arr.length; l++)
						System.out.print(arr[l]);
					System.out.println();
					System.exit(1);
				}
			}
			return;
		}
		for (int j = i; j < s.length(); j++) {
			char arr[] = s.toString().toCharArray();
			char temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			s = Arrays.toString(arr);
			allPermutations(s, i + 1, mainarr);
			char arr1[] = s.toString().toCharArray();
			temp = arr1[i];
			arr1[i] = arr1[j];
			arr1[j] = temp;
			s = Arrays.toString(arr);
		}
	}

	public static int ARRSUM = 0;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String arr[] = s.split(" ");
		int[] intarr = new int[arr.
		                       length];
		intarr[0] = new Integer(arr[0]);

		for (int i = 1; i < arr.length; i++) {
			intarr[i] = new Integer(arr[i]);
			ARRSUM += intarr[i];
		}
		s = "";
		for (int i = 65; i < 65 + arr.length; i++)
			s += (char) i;
		allPermutations(s + "", 0, intarr);

	}
}
