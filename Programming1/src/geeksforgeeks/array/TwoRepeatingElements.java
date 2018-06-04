package geeksforgeeks.array;

public class TwoRepeatingElements {
	static int arr[] = { 4, 2, 4, 5, 2, 3, 1 };
	public static void main(String[] args) {
		for (int i = 0; i < arr.length; i++) {
			int index = Math.abs(arr[i]);
			if(arr[index]>0)
				arr[index]=-arr[index];
			else
				System.out.println(index);
		}
	}
}
