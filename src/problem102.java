import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class problem102 {

	public static double getSign(int x1, int y1, int x2, int y2, int x3, int y3) {
		double m;

		if (x1 == x2)
			m = Integer.MAX_VALUE;
		else
			m = (double) (y1 - y2) / (double) (x1 - x2);
		return y3 - y1 - m * (x3 - x1);

	}

	public static void main(String args[]) {
		try {
			FileInputStream fstream = new FileInputStream("/home/salvo/Desktop/in102.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			int count = 0;
			while ((strLine = br.readLine()) != null) {
				String arr[] = strLine.split(",");
				int x1 = new Integer(arr[0]);
				int y1 = new Integer(arr[1]);
				int x2 = new Integer(arr[2]);
				int y2 = new Integer(arr[3]);
				int x3 = new Integer(arr[4]);
				int y3 = new Integer(arr[5]);

				double s1 = getSign(x1, y1, x2, y2, 0, 0);
				double s2 = getSign(x1, y1, x2, y2, x3, y3);

				double s3 = getSign(x1, y1, x3, y3, 0, 0);
				double s4 = getSign(x1, y1, x3, y3, x2, y2);

				double s5 = getSign(x2, y2, x3, y3, 0, 0);
				double s6 = getSign(x2, y2, x3, y3, x1, y1);

				if (s5 * s6 > 0 && s3 * s4 > 0 && s2 * s1 > 0)
					count++;
			}
			in.close();
			System.out.println(count);
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
}