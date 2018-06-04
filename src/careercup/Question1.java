package careercup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Question1 {

	public static void printPaths(int mat[][], int s, int t, int n,
			ArrayList<Integer> list) {
		
		if (list.contains(new Integer(t + ""))) {
			System.out.println(list);
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (mat[s][i] == 1) {
				list.add(new Integer(i));
				mat[s][i] = 0;
				mat[i][s]=0;
				printPaths(mat, i, t, n, list);
				list.remove((Object) i);
				mat[s][i] = 1;
				mat[i][s]=1;
			}
		}
	}
	HashMap<Integer, Long> hmap=new HashMap<Integer, Long>();
	 long power(int a, int b) {
		if (b == 0)
			return 1;
		if (b == 1)
			return a;
		if(hmap.containsKey(b))
			return hmap.get(b);
		long p = power(a, b / 2) * power(a, b / 2);
		if (b % 2 == 1)
			 p=p*a;
		hmap.put(b, p);
		return p;
	}
	public static void main(String args[]) throws IOException {
/*		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int n = new Integer(s);
		int mat[][] = new int[n][n];

		for (int i = 0; i < n; i++) {
			s = br.readLine();
			String arr[] = s.split(" ");
			for (int j = 0; j < n; j++)
				mat[i][j] = new Integer(arr[j]);
		}
		Integer s1=1,t1=0;
		ArrayList list=new ArrayList<Integer>();
		list.add(s1);
		printPaths(mat, s1, t1, n, list);*/
		System.out.println(new Question1().power(0, 3));
	}

}
