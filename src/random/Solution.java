package random;

class Solution {
	public int valid(int A[], int k) {
		int i, count = 0;
		for (i = 0; i < A.length; i++) {
			if (A[i] == A[k])
				count++;
		}
		if (count > (A.length) / 2)
			return A[k];
		return -1;
	}

	public int arrLeader(int[] A) {
		int n = A.length;
		if (n == 0)
			return -1;
		if (n == 1)
			return A[0];
		int leader = 0, count = 1;
		for (int i = 1; i < n; i++) {
			if (A[i] == A[leader])
				count++;
			else
				count--;
			if (count == 0) {
				leader = i;
				count = 1;
			}
		}
		return valid(A, leader);
	}

	public static void main(String[] args) {
		// int A[]={4,2,2,3,2,4,2,2,6,4};
		//int A[] = { 100, 1, 1, 1, 2 };
		int A[] = { 2, 1, 1, 2 };
		
		Solution s = new Solution();
		System.out.println(s.arrLeader(A));
	}
}
