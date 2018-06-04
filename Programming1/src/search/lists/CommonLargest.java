package search.lists;

import java.util.ArrayList;
import java.util.List;

public class CommonLargest {
	public  void mergeSort(Integer array[], int lo, int n) {
		int low = lo;
		int high = n;
		if (low >= high) {
			return;
		}
		int middle = (low + high) / 2;
		mergeSort(array, low, middle);
		mergeSort(array, middle + 1, high);
		int end_low = middle;
		int start_high = middle + 1;
		while ((lo <= end_low) && (start_high <= high)) {
			if (array[low] < array[start_high]) {
				low++;
			} else {
				int temp = array[start_high];
				for (int k = start_high - 1; k >= low; k--) {
					array[k + 1] = array[k];
				}
				array[low] = temp;
				low++;
				end_low++;
				start_high++;
			}
		}
	}

	 boolean binarySearch(Integer[] a, int b) {
		if (a.length == 0) {
			return false;
		}
		int low = 0;
		int high = a.length - 1;
		while (low <= high) {
			int middle = (low + high) / 2;
			if (b > a[middle]) {
				low = middle + 1;
			} else if (b < a[middle]) {
				high = middle - 1;
			} else { // The element has been found
				return true;
			}
		}
		return false;
	}
	
	public int largetCommonInteger(List<Integer> l1, List<Integer> l2) {
		int MAX = Integer.MIN_VALUE;
		List<Integer> longer, smaller;
		if (l1.size() > l2.size()) {
			longer = l1;
			smaller = l2;
		} else {
			longer = l2;
			smaller = l1;
		}

		Integer smallerarr[] = new Integer[smaller.size()];
		for (int i = 0; i < smaller.size(); i++)
			smallerarr[i] = smaller.get(i);
		mergeSort(smallerarr, 0, smaller.size() - 1);
		smaller.clear();

		for (int i = 0; i < smallerarr.length; i++)
			smaller.add(smallerarr[i]);

		for (int i = 0; i < longer.size(); i++) {
			int ele = longer.get(i);
			boolean found = binarySearch(smallerarr, ele);
			if (found && MAX < ele )
				MAX = ele;
		}
		
		if(MAX==Integer.MIN_VALUE)
			System.out.println("No Common element found");
		
		return MAX;

	}

	public static void main(String[] args) {
		CommonLargest cl = new CommonLargest();
		List<Integer> l1 = new ArrayList<Integer>();
		List<Integer> l2 = new ArrayList<Integer>();
		
		l1.add(12);
		l1.add(11);
		l1.add(13);
		l1.add(10);
		l1.add(14);

		l2.add(10);
		l2.add(11);
		l2.add(12);
		l2.add(13);

		int ele = cl.largetCommonInteger(l1, l2);
		System.out.println(ele);

	}
}
