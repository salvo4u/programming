package cramsters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class TestScores {
	int arr[];

	public TestScores(int arr[]) {
		this.arr = arr;
	}

	public float getAverage() throws IllegalArgumentException {
		float avg = 0;
		if (arr.length == 0)// if the array is empty
			return 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 100 || arr[i] < 0)
				throw new IllegalArgumentException();
			avg = avg + arr[i];
		}
		return avg / arr.length;
	}
}

public class Question5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter space seperated integer array:");
		String s = br.readLine();
		String arr[] = s.split(" ");
		int[] intarr = new int[arr.length];

		for (int i = 0; i < arr.length; i++)
			intarr[i] = new Integer(arr[i]);
		try {
			TestScores ts = new TestScores(intarr);
			System.out.println(ts.getAverage());
		} catch (IllegalArgumentException e) {
			System.out.println("Exception caught");
		}
	}
}