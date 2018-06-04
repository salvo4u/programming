package euler;
class problem45 {
	public static boolean isInt(double num) {
		if (num - (int) num == 0)
			return true;
		else
			return false;
	}

	public static void main(String args[]) {
		double n = 287;
		double M = Math.sqrt(12 * n * n + 12 * n + 1), P = Math.sqrt(4 * n * n
				+ 4 * n + 1), m, p;

		while (true) {
			p=(n+1)/2;
			M = Math.sqrt(12 * n * n + 12 * n + 1);
			boolean x = isInt(M);
			if(x)
			{
			m = (1 + M) / 6;
				if (isInt(m))
				break;
			}
			n=n+2;
			System.out.println(M+"   "+x);
			
		}
		System.out.println(n*(n+1)/2+"   "+n+"  "+m+"    "+p+"   ");
		

	}
}