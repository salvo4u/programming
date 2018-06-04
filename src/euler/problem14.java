package euler;
import java.util.HashMap;

public class problem14 {
	static HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();

	public static int countChain(int n)  {
		
		if (n == 2) {
			h.put(2, 1);
			return 2;
		}
		if(h.get(n)!=null){
		if(new Integer(h.get(n).toString())>1)
			return new Integer(h.get(n).toString());
		}
		
		if (n % 2==1) {
			int x = countChain(3 * n + 1);
			h.put(3 * n + 1, x);
			return 1 + x;
		} else {
			int x = countChain(n / 2);
			h.put(n / 2, x);
			return 1 + x;
		}
	}

	public static void main(String args[]) {
		
		for(int i=1;i<=33;i++)
		{
		
				int count=countChain(i);
				System.out.println(i+"    "+count);
			
		}
	}
}
