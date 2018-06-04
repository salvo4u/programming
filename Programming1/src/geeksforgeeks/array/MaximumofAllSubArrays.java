package geeksforgeeks.array;

public class MaximumofAllSubArrays {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 1, 4, 5, 2, 3, 6 };
		int k = 3;
		int max = 3;
		System.out.print(max);
		for (int i = k; i < arr.length; i++) {
			int del = arr[i - k];
			int add = arr[i];
			if (del != max) {
				if (add > max)
					max = add;
			} else {
				// find new max of k elements
				max = Integer.MIN_VALUE;
				for (int j = i - k + 1; j < i+1; j++) {
					if (max < arr[j])
						max = arr[j];
				}
			}
			System.out.print("   "+max);
		}
	}
}
