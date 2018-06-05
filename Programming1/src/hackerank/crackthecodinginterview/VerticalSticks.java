package hackerank.crackthecodinginterview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VerticalSticks {
	// D[i], input
	static double solve(int N) {
		double ans = 1.0;
		for (int pos = 2; pos <= N; pos++) {
			double t1 = 0.0;
			for (int i = 0; i < N; i++) { // choose i in position pos
				int x = C[i][0]; // < D[i]
				int y = C[i][1]; // >= D[i]

				double pre = 1.0;
				int k = 1;
				for (; k <= (pos - 1); k++) {
					double t2 = pre * ((double) y / (double) (x + y));
					t1 += (t2 * k);
					pre *= ((double) x / (double) (x + y));
					if (x-- == 0)
						break;
				}
				if (k == pos)
					t1 += (pre * pos);
			}
			ans += (t1 / N);
		}
		return ans;
	}

	static int C[][];

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		int N = new Integer(s);
		s = br.readLine();
		String arr[] = s.split(" ");
		C = new int[N][N];
		for (int i = 0; i < arr.length; i++) {
			int n = new Integer(arr[i]);
			C[i][0] = i + 1;
			C[i][1] = n;
		}
	System.out.println(solve(N));	
	}
}
