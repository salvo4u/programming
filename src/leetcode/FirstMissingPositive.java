package leetcode;

import java.util.Arrays;

public class FirstMissingPositive {
	static int frompos = 0;

	public static void arrangeArray(int arr[], int start, int end) {
		int positive = start, negative = end;
		if (start >= end) {
			System.out.println(start + "  " + end);
			frompos = end;
			return;
		}

		for (int i = start; i <= end; i++) {
			if (arr[i] >= 0) {
				positive = i;
				break;
			}
		}
		for (int i = end; i >= 0; i--) {
			if (arr[i] < 0) {
				negative = i;
				break;
			}
		}
		int temp = arr[positive];
		arr[positive] = arr[negative];
		arr[negative] = temp;
		arrangeArray(arr, positive + 1, negative - 1);
	}

	public static void main(String args[]) {
		int arr[] = { 13, -2, -1, 1, -20, -3, -4, 5 };
		// int arr[]={2, 3, 7, 6, 8, -1, -10, 15};
		// int arr[] = { 2, 3, -7, 6, 8, 1, -10, 15 };
		arrangeArray(arr, 0, arr.length - 1);
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + "  ");
		int i;
		System.out.println();
		int size = arr.length - frompos - 1;

		int newarr[] = new int[size];
		for (i = frompos + 1; i < arr.length; i++) {
			newarr[i - frompos - 1] = arr[i];
		}
		Boolean flag = false;
		for (i = 0; i < size; i++) {
			if (Math.abs(newarr[i]) - 1 < size
					&& newarr[Math.abs(newarr[i]) - 1] > 0)
				arr[Math.abs(newarr[i]) - 1] = -arr[Math.abs(newarr[i]) - 1];
		}

		// Return the first index value at which is positive
		for (i = 0; i < size; i++) {
			if (newarr[i] > 0) {
				System.out.println(i + 1); // 1 is added becuase indexes start
											// from 0
				
			}
		}

	}
}
