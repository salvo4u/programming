package careercup;

public class ArrayQuestion {
	public static boolean bsearch(int start, int end, int ele) {
		int mid = start + (end - start) / 2;
		if (start > end)
			return false;
		if (ele == mid)
			return true;
		if (ele < mid)
			return bsearch(start, mid - 1, ele);
		else
			return bsearch(mid + 1, end, ele);
	}

	public static void main(String[] args) {
		//int arr[] = {1,2,3,4,5,6,7,8,9,10,11,12,13};
		int arr[] = {100,99};
		int m = arr[0];
		int k=99;
		for (int i = 1; i < arr.length; i++) {
			boolean found=bsearch(m-i,m+i,k);
			if(found)
			{
				System.out.println("element at index "+i+" = "+k);
				System.exit(1);
			}
		}
		System.out.println("Not Found");
	}
}
