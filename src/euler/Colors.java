package euler;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Colors {
	static char mat[][];
	static int n, m;

	static void fillcolors(int i, int j) {
		mat[i][j] = '1';
		
		if (i != n - 1 && j != m - 1 && mat[i + 1][j + 1] == '0') {
			fillcolors(i + 1, j + 1);
			// printmat();
		}
		if (i != n - 1 && mat[i + 1][j] == '0') {
			fillcolors(i + 1, j);
			// printmat();
		}
		if (i != n - 1 && j != 0 && mat[i + 1][j - 1] == '0') {
			fillcolors(i + 1, j - 1);
			// printmat();
		}
		if (j != m - 1 && mat[i][j + 1] == '0') {
			fillcolors(i, j + 1);
			// printmat();
		}

		if (j != 0 && mat[i][j - 1] == '0') {
			fillcolors(i, j - 1);
			// printmat();
		}
		if (i != 0 && j != 0 && mat[i - 1][j - 1] == '0') {
			fillcolors(i - 1, j - 1);
			// printmat();
		}
		if (i != 0 && mat[i - 1][j] == '0') {
			fillcolors(i - 1, j);
			// printmat();
		}
		if (i != 0 && j != m - 1 && mat[i - 1][j + 1] == '0') {
			fillcolors(i - 1, j + 1);
			// printmat();
		}

	}

	public static void main(String args[]) throws IOException {
		FileInputStream fstream = new FileInputStream(
				"/home/salvo/Desktop/c1.in");
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String str = br.readLine();
		System.out.println(str);
		String line[] = str.split(" ");
		n = new Integer(line[0]);
		m = new Integer(line[1]);
		mat = new char[n][m];
		for (int i = 0; i < n; i++) {
			str = br.readLine();
			mat[i] = str.toCharArray();
		}

		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (mat[i][j] == '0') {
					fillcolors(i, j);
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
