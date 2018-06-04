package euler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class problem75 {
	public static void main(String args[]) {
		long CONSTANTL = 1500000;
		ArrayList<Integer> hm = new ArrayList<Integer>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for (int L = 1; L <= CONSTANTL; L++) {
			int count = 0;
			int flag1 = 0;
			for (int a = 1; a <= L / 2; a++) {
				for (int b = L / 2 - a + 1; b <= L / 2; b++) {
					if(b==0 || a==b)
						continue;
					
					int c = L - a - b;
					
					if(c==0)
						continue;
					
					int arr[] = { a, b, c };
					Arrays.sort(arr);
					String key = arr[0] + "" + arr[1] + "" + arr[2];
			//		System.out.println("key=" + key + " a=" + a + " b=" + b	+ " c=" + c + "  L=" + L+" "+map.get(key));
					int flag2=0;
					if (map.get(key) == null) {			
						if (a * a + b * b == c * c) {
							count++;
							map.put(key, 1);
							flag2=1;
						}
						if (c * c + b * b == a * a) {
							count++;
							map.put(key, 1);
							flag2=1;
						}
						if (a * a + c * c == b * b) {
							count++;
							map.put(key, 1);
							flag2=1;
						}	
					}

				//	System.out.println(key+"  "+count);
					if (count > 1) {
						flag1 = 1;
						break;
					}
					if(flag2==1)
						break;
				}
				if (flag1 == 1)
					break;
			}
			//System.out.println(L+"  "+count);
			if(count==1)
				hm.add(L);
		}
		System.out.println(hm.size());
	}
}
