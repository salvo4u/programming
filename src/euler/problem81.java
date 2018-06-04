package euler;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class problem81 {
	static String A[][] = new String[80][80];
	static int M[][] = new int[80][80];
	public static void main(String args[]) throws FileNotFoundException {
		Scanner in = new Scanner(new File("/home/salvo/Desktop/in81.txt"));
		int pos = 0;
		while (in.hasNext()) {
			String s = in.nextLine();
			A[pos++] = s.split(",");
		}		
		M[0][0]=new Integer(A[0][0]);
		for (int i = 1; i < A[0].length; i++) {
			M[0][i] = M[0][i-1] + new Integer(A[0][i]);
			M[i][0] = M[i-1][0] + new Integer(A[i][0]);
		}
		for (int i = 1; i < A[0].length; i++) 
			for (int j = 1; j < A[0].length; j++) 
				M[i][j]=(M[i-1][j]<M[i][j-1]?M[i-1][j]:M[i][j-1])+new Integer(A[i][j]);
		System.out.println(M[pos-1][pos-1]);
	}
}