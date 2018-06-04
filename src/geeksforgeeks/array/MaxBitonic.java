package geeksforgeeks.array;

public class MaxBitonic {
	public static void main(String[] args) {
		int arr[] = { 51, 41, 51, 21, 1 };
		int lasti = 0;
		int maxSize = Integer.MIN_VALUE;
		boolean up = true, isBitonicInProgress = false;
		for (int i = 0; i < arr.length - 1; i++) {
			if (!isBitonicInProgress) {
				isBitonicInProgress = true;
				lasti = i;
				if (arr[i] <= arr[i + 1])
					up = true;
				else
					up = false;
			}
			if (up) {
				if (arr[i] <= arr[i + 1]) {

				} else {
					up = false;
				}
			}
			if (!up) {
				if (arr[i] <= arr[i + 1]) {
					int size = i - lasti + 1;
					if (size > maxSize) {
						maxSize = size;
					}
					isBitonicInProgress = false;
					i--;
				} else {

				}
			}
		}
		if(isBitonicInProgress) {
			int size = arr.length - lasti;
			if (size > maxSize) {
				maxSize = size;
			}
		}
		System.out.println(maxSize);
	}
}
