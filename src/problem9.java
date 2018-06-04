public class problem9 {
	public static void main(String args[]) {
		for (int a = 999; a >= 1; a--) {
			double b = (1000000 - 2000 * a) / (double)(2000 - 2 * a);
				if((a*a+b*b)==(1000 - a - b)*(1000 - a - b) && a!=b && (b-(int)b)==0 && b>0)
				System.out.println(a *b *(1000 - a - b));
			}
	}
}
