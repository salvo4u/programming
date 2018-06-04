package euler;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
class problem67 {
	static int sumM[][], M[][];
	static void findMaxSum(int x, int y) {
		int lsum = 0, usum = 0;
		if (y - 1 >= 0)
			lsum = sumM[x - 1][y - 1];
		usum = sumM[x - 1][y];
		int max = usum > lsum ? usum : lsum;
		sumM[x][y] = (int) (max + M[x][y]);
	}
	public static void main(String args[]) throws IOException {
		int N = 100;
		M = new int[N][N];
		sumM = new int[N][N];
		BufferedReader reader = new BufferedReader(new FileReader(new File(
				"/home/salvo/input67")));
		String line = null;
		int x = 0;
		while ((line = reader.readLine()) != null) {
			String splitarr[] = line.split(" ");
			for (int i = 0; i < splitarr.length; i++) {
				M[x][i] = new Integer(splitarr[i]);
			}
			x++;
		}
		reader.close();
		sumM[0][0] = M[0][0];
		for (int i = 1; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				sumM[i][j] = 0;
				findMaxSum(i, j);
			}
		}
		for (int i = 0; i < N; i++) {
			System.out.print(sumM[N - 1][i] + " - ");
		}
	}
}