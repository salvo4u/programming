package geeksforgeeks.array;

//http://www.geeksforgeeks.org/archives/7897
public class SwapEvenOdd {
	public static void main(String[] args) {
		int arr[] = {12, 34, 450, 90, 8, 90, 30};
		int odd = 0, even = arr.length - 1;
		while (odd <= even) {
			if (arr[odd] % 2 == 0) {
				int temp = arr[odd];
				arr[odd] = arr[even];
				arr[even] = temp;
				even--;
			} else
				odd++;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"  ");
		}
	}
}
