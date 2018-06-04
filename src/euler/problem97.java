package euler;
public class problem97 {
	public static void main(String args[]) {
		long count = 1;
		String num = "";
		long start = 2;
		long a = 28433, b = 7830457, N = 10;
		long t1 = System.currentTimeMillis();
		while (count < b) {
			start = start << 1;
			if ((start + "").length() >= N) {
				num = start + "";
				start = new Long(num.subSequence(num.length() - (int) N,
						num.length()).toString());
			}
			count++;
		}
		start = start * a + 1;
		num = start + "";
		start = new Long(num.subSequence(num.length() - (int) N, num.length())
				.toString());
		System.out.println(start);
		long t2 = System.currentTimeMillis();
		System.out.println("TIME:" + (t2 - t1) + "millisec");
	}
}