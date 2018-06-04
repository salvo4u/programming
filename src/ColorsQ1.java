import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Point {
	int x, y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class ColorsQ1 {
	static char mat[][];
	static int n, m;
	static Queue<Point> q;

	static char TARGET = '0';

	static char REPLACEMENT = '1';

	static int fillcolors(int i1, int j1) {
		if (mat[i1][j1] == REPLACEMENT)
			return REPLACEMENT;
		Point p = new Point(i1, j1);
		q.add(p);
		while (!q.isEmpty()) {
			p = q.peek();
			int i = p.x;
			int j = p.y;

			if (mat[i][j] == TARGET)
				mat[i][j] = REPLACEMENT;

			if (i != n - 1 && j != m - 1 && mat[i + 1][j + 1] == TARGET)
				q.add(new Point(i + 1, j + 1));

			if (i != n - 1 && mat[i + 1][j] == TARGET)
				q.add(new Point(i + 1, j));

			if (i != n - 1 && j != 0 && mat[i + 1][j - 1] == TARGET)
				q.add(new Point(i + 1, j - 1));

			if (j != m - 1 && mat[i][j + 1] == TARGET)
				q.add(new Point(i, j + 1));

			if (j != 0 && mat[i][j - 1] == TARGET)
				q.add(new Point(i, j - 1));

			if (i != 0 && j != 0 && mat[i - 1][j - 1] == TARGET)
				q.add(new Point(i - 1, j - 1));

			if (i != 0 && mat[i - 1][j] == TARGET)
				q.add(new Point(i - 1, j));

			if (i != 0 && j != m - 1 && mat[i - 1][j + 1] == TARGET)
				q.add(new Point(i - 1, j + 1));

			q.remove();
		}
		return TARGET;
	}

	public static void main(String args[]) throws IOException {
		FileInputStream fstream = new FileInputStream(
				"/home/salvo/Desktop/d1.in");
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String str = br.readLine();
		String line[] = str.split(" ");
		n = new Integer(line[0]);
		m = new Integer(line[1]);
		mat = new char[n][m];
		for (int i = 0; i < n; i++) {
			str = br.readLine();
			mat[i] = str.toCharArray();
			System.out.println(str);
		}
		q = new LinkedList<Point>();
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (fillcolors(i, j) == TARGET)
					count++;
			}
		}
		System.out.println(count);
	}
}
