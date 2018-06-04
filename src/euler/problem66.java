package euler;
public class problem66 {
	public static boolean isPerfect(int num) {
		double x;
		x = Math.sqrt(num);
		if (x - (int) x == 0)
			return true;
		else
			return false;
	}
	public static void main(String args[]) {
		int max=Integer.MIN_VALUE,minD=0;
		for (int D = 1; D <= 1000; D++) {
			int y = 1;
			if(isPerfect(D))
				continue;
			int x;
			while (true) {
				x = 1 + D * y * y;
				if (isPerfect(x))
					break;
				y++;
			}
			if(Math.sqrt(x)>=max)
			{
				max=(int)Math.sqrt(x);
				minD=D;
			}
		System.out.println(D + "  " +(int)Math.sqrt(x));
			
		}

		System.out.println(minD + "  " +max);
	}
}
