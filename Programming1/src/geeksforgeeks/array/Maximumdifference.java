package geeksforgeeks.array;
//http://www.geeksforgeeks.org/archives/6463
public class Maximumdifference {
	public static void main(String[] args) {
		int arr[] = {10,2,12};
		int max = arr[0], min = arr[0], diff = 0;
		for (int i = 1; i < arr.length; i++) {
			max=arr[i];
			if (arr[i] < min)
				min = arr[i];
			if (max - min > diff)
				diff = max - min;
		}
		System.out.println(diff);
	}
}
