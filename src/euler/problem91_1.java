package euler;

public class problem91_1 {
	public static int getDistance(int x1, int y1, int x2, int y2) {
		return ((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}
	public static void main(String args[]) {
		int sum = 0, n = 50;
		int x3 = 0, y3 = 0;
		long time1 = System.currentTimeMillis();
		for (int x1 = 0; x1 <= n; x1++) {
			for (int y1 = 0; y1 <= n; y1++) {
				for (int x2 = 0; x2 <= n; x2++) {
					for (int y2 = 0; y2 <= n; y2++) {
						int a = getDistance(x1, y1, x2, y2);
						int b = getDistance(x1, y1, x3, y3);
						int c = getDistance(x2, y2, x3, y3);
						int min = x1 < x2 ? x1 : x2;
						int max = x1 + x2 - min;
						String key = min + " " + max + " ";
						min = y1 < y2 ? y1 : y2;
						max = y1 + y2 - min;
						key += min + " " + max;
						if (a != 0 && b != 0 && c != 0) {
							if ((c == (a + b)) || (b == (a + c))
									|| (a == (b + c)))
								sum++;
						}
					}
				}
			}
		}
		long time2 = System.currentTimeMillis();
		System.out.println(sum / 2);
		System.out.println("TIME:"+(time2 - time1)+"millisec");
	}
}
