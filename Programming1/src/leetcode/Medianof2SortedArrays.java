package leetcode;

public class Medianof2SortedArrays {
	int getMedian(int arr1[], int start1, int end1, int arr2[], int start2,
			int end2) {
		int mid1 = start1 + (end1 - start1) / 2;
		int mid2 = start2 + (end2 - start2) / 2;
		int median1 = arr1[mid1];
		int median2 = arr2[mid2];

		int len1 = end1 - start1;
		int len2 = end2 - start2;
		if(len1==1)
		{
			if(median1<)
		}
		
		if (median1 <= median2) {
			return getMedian(arr1, mid1, end1, arr2, start2, mid2);
		} else {
			return getMedian(arr1, start1, mid1, arr2, mid2, end2);
		}
	}

	public static void main(String args[]) {
		int arr1[] = { 1, 2 }, target = 2;
		int arr2[] = { 2, 3, 4, 5, 6 };
	}
}
