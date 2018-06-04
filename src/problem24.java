import java.util.ArrayList;
import java.util.List;

public class problem24 {
	public static List<Integer> list = new ArrayList<Integer>();
	
	public static long getFactorial(int limit) {
		long factorial = 1;
		for (int i = 1; i <= limit; i++)
			factorial = factorial * i;
		return factorial;
	}

	public static void main(String chars[]) {
		long count = 1000000;
		int num = 9;
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		
		String s = "";
		while (count != 0) {
			long fact = getFactorial(num--);
			int p1 = (int) (count / fact);
			s=s+""+list.get(p1);
			list.remove(p1);
			count = count - fact * p1;
		}
	System.out.println(s+list.get(0));
	}
}
