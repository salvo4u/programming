package euler;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class problem82 {
	static String A[][] = new String[80][80];

	public static void main(String args[]) throws FileNotFoundException {
		Scanner in = new Scanner(new File(
				"C:\\Users\\agupta\\workspace\\euler\\src\\input82.txt"));
		int pos = 0;
		while (in.hasNext()) {
			String s = in.nextLine();
			System.out.println(s);
			A[pos++] = s.split(" ");
		}
		System.out.println("***************");

		int globalmin = Integer.MAX_VALUE;
		for (int k = 0; k < A[0].length; k++) {

			int M[][] = new int[80][80];
			M[k][0] = new Integer(A[k][0]);

			for (int l = 0; l < A[0].length; l++) {
				if (l > k)
					M[l][0] = M[l-1][0] + new Integer(A[l][0]);
				if (l < k)
					M[l][0] = M[l+1][0] + new Integer(A[l][0]);
			}

			for (int i = 0; i < A[0].length; i++) {
				for (int j = 1; j < A[0].length; j++) {
					int arr[] = new int[3];
					if (i - 1 >= 0)
						arr[0] = M[i - 1][j];
					if (i + 1 < A[0].length)
						arr[1] = M[i + 1][j];
					if (j - 1 >= 0)
						arr[2] = M[i][j - 1];

					System.out.println(i+","+j+" -- "+arr[0]+" , "+arr[1]+" ,  "+arr[2]);
					Arrays.sort(arr);
					M[i][j] = arr[0] + new Integer(A[i][j]);
				}
			}
			System.out.println("-----------------");
			for (int i = 0; i < A[0].length; i++) {
				for (int j = 0; j < A[0].length; j++)
					System.out.print(M[i][j]+"   ");
				System.out.println();
			}
			
			int min = M[0][A[0].length-1];
			for (int i = 0; i < A[0].length; i++) {
				if (M[A[0].length - 1][i] < min)
					min = M[0][A[0].length-1];
			}
			if (min < globalmin)
				globalmin = min;
		}
		System.out.println(globalmin);
	}

}
