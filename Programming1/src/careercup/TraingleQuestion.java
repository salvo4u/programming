package careercup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TraingleQuestion {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			String s = br.readLine();
			String arr[] = s.split(" ");
			int A[] = new int[arr.length];
			for (int i = 0; i < arr.length; i++) {
				A[i] = new Integer(arr[i]);
			}
			Arrays.sort(A);
			for (int i = 0; i < A.length; i++) {
				for (int j = i + 1; j < A.length - 1; j++) {
					if (A[i] + A[j] > A[j + 1]) {
						if (A[j + 1] + A[j] > A[i]) {
							if (A[j + 1] + A[i] > A[j]) {
								System.out.println(1);
								System.out.println(A[i] +" "+ A[j] +" "+ A[j + 1]);
								System.exit(1);
							}
						}
					}
				}
			}
			System.out.println(0);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
