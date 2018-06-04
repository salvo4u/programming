package euler;
import java.util.HashMap;

class problem39 {
	public static void main(String args[]) {
		
		int a, b, c, p;
		
		HashMap h1 = new HashMap();
		int max =0,pmax=0;
		for (p = 2; p <= 1000; p=p+2) {
			int count=0;
			for (b = 1; b < p; b++) {
				for (c = 1; c < b; c++) {
					int a1 = p - (b + c), b1 = b, c1 = c, arr[] = { a1, b1, c1 };
					if (a1 > 0) {
						for (int i = 0; i < 3; i++) {
							for (int j = 0; j < 3; j++) {
								if (arr[i] > arr[j]) {
									int temp = arr[i];
									arr[i] = arr[j];
									arr[j] = temp;
								}
							}
						}
						a1 = arr[2];
						b1 = arr[1];
						c1 = arr[0];
						
						if (h1.get(a1 + "" + b1 + "" + c1 + "") == null) {
							if (a1 + b1 + c1 == p
									&& c1 * c1 == b1 * b1 + a1 * a1) {
								count++;
								h1.put(a1 + "" + b1 + "" + c1 + "", 1 + "");
							}
						}
						
					}
				}
			}
			if(max<count)
			{
				max=count;
				pmax=p;
			}	
			
		}
		System.out.println(pmax+"  "+max);	
		
	}
}