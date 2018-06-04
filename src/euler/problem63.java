package euler;
import java.util.Arrays;

public class problem63 {
	public static void main(String args[]) {
		final long time = System.currentTimeMillis();

		double[] logs = new double[10];
		for (int i = 1; i < logs.length; i++)
			logs[i] = Math.log10(i);

		int count = 0;
		for (double n = 1.0; n < 22.0; n++) {
			double limit = (n - 1.0) / n;
			int pos = Arrays.binarySearch(logs, limit);
			count += pos > 0 ? 10 - pos : 11 + pos;
		}
		System.out.println(count + " in " + (System.currentTimeMillis() - time)
				+ "ms");
	}
}
