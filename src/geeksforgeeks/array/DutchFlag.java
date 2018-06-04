package geeksforgeeks.array;

public class DutchFlag {
	private static void swap(int p1, int p2) {
		int temp = arr[p1];
		arr[p1] = arr[p2];
		arr[p2] = temp;
	}
	static int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
	public static void main(String[] args) {
		
		int lo = 0;
		int mid = 0;
		int hi = arr.length - 1;
		while (mid <= hi) {
			switch (arr[mid]) {
			case 0:
				swap(mid, lo);
				mid++;
				lo++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				swap(mid, hi);
				hi--;
				break;
			}
		}
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + "  ");
	}
}
