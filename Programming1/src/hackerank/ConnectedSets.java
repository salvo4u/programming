package hackerank;

import java.util.Scanner;

public class ConnectedSets {
	// static int mat[][] = { { 0, 0, 1, 0 }, { 1, 0, 1, 0 }, { 0, 1, 0, 0 },{
	// 1, 1, 1, 1 } };
	// static int mat[][] = { { 1, 0, 0, 1, 1 }, { 0, 0, 1, 0, 0 },{ 0, 0, 0, 0,
	// 0 }, { 1, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0 } };

	//static int mat[][] = { { 1, 0, 0, 1 }, { 0, 0, 0, 0 }, { 0, 1, 1, 0 },{ 1, 0, 0, 1 } };
	//static int n = mat.length;
	static int mat[][],n;
	static void colorPath(int i, int j, int color) {
		if (mat[i][j] <= 0)
			return;
		mat[i][j] = color;

		if (i + 1 != n)// south
			colorPath(i + 1, j, color);

		if (j + 1 != n)// east
			colorPath(i, j + 1, color);

		if (i - 1 >= 0)// north
			colorPath(i - 1, j, color);

		if (j - 1 >= 0)// west
			colorPath(i, j - 1, color);

		if (i + 1 != n && j + 1 != n)// south east
			colorPath(i + 1, j + 1, color);

		if (i - 1 >= 0 && j - 1 >= 0)// noth west
			colorPath(i - 1, j - 1, color);

		if (i + 1 != n && j - 1 >= 0)// south west
			colorPath(i + 1, j - 1, color);

		if (i - 1 >= 0 && j + 1 != n)// north east
			colorPath(i - 1, j + 1, color);

	}

	static int getConnected(int n) {
		int count = -1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == 1) {
					colorPath(i, j, count);
					count--;
				}

			}
		}
		return -count - 1;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		for (int i = 0; i < num; i++) {
			n = in.nextInt();
			mat = new int[n][n];
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++){
						mat[j][k] = in.nextInt();
				}
			}
			System.out.println(getConnected(n));
		}
	}
}
