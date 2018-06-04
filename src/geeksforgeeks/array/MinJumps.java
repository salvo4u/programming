package geeksforgeeks.array;

public class MinJumps {

	public static void main(String args[]) {
		int arr[] = { 1, 3, 1, 1, 1, 2, 6, 7, 6, 8, 9 };
		System.out.println(getMin(arr, 0));
	}

	private static int getMin(int[] a, int i) {
		int min = Integer.MAX_VALUE;

		// When nothing is reachable from the given source
		if (a[i] == 0)
			return min;
		
		for (int j = i + 1; j <= i + a[i]; j++) {
			if(j >= a.length) {
				return 0;
			}
			int jumps = getMin(a, j);
			if (jumps + 1 < min)
				min = jumps + 1;
		}
		return min;
	}
}
