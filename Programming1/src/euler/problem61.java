package euler;
import java.util.Vector;

public class problem61 {
	public static void main(String args[]) {
		int limit = 4000;
		Vector<Integer> v1 = new Vector<Integer>();
		Vector<Integer> v2 = new Vector<Integer>();
		Vector<Integer> v3 = new Vector<Integer>();
		Vector<Integer> v4 = new Vector<Integer>();
		Vector<Integer> v5 = new Vector<Integer>();
		Vector<Integer> v6 = new Vector<Integer>();
		for (int i = 3; i < limit; i++) {
			int x1 = i * (i + 1) / 2;
			String x1s = x1 + "";
			if (x1s.length() == 4) {
				v1.add(x1);
			}

		}
		for (int i = 3; i <limit ; i++) {
			int x1 = i * (i);
			String x1s = x1 + "";
			if (x1s.length() == 4) {
				v2.add(x1);
			}

		}
		for (int i = 3; i < limit; i++) {
			int x1 = i * (3 * i - 1) / 2;
			String x1s = x1 + "";
			if (x1s.length() == 4) {
				v3.add(x1);
			}

		}
		for (int i = 3; i < limit; i++) {
			int x1 = i * (2 * i - 1);
			String x1s = x1 + "";
			if (x1s.length() == 4) {
				v4.add(x1);
			}

		}
		for (int i = 3; i < limit; i++) {
			int x1 = i * (5 * i - 3) / 2;
			String x1s = x1 + "";
			if (x1s.length() == 4) {
				v5.add(x1);
			}

		}
		for (int i = 3; i < limit; i++) {
			int x1 = i * (3 * i - 2);
			String x1s = x1 + "";
			if (x1s.length() == 4) {
				v6.add(x1);
			}
		}
		
		
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);
		System.out.println(v4);
		System.out.println(v5);
		System.out.println(v6);
		for (int i = 0; i < v1.size(); i++) {
			int x1 = v1.get(i);
			for (int j = 0; j < v2.size(); j++) {
				int x2 = v2.get(j);
				if ((x1 % 100) != x2 / 100)
					continue;
				for (int k = 0; k < v3.size(); k++) {

					int x3 = v3.get(k);
					if ((x2 % 100) != x3 / 100)
						continue;
					for (int l = 0; l < v4.size(); l++) {

						int x4 = v4.get(l);
						if ((x3 % 100) != x4 / 100)
							continue;
						for (int m = 0; m < v5.size(); m++) {

							int x5 = v5.get(m);
							if ((x4 % 100) != x5 / 100)
								continue;
							for (int n = 0; n < v6.size(); n++) {

								int x6 = v6.get(n);
								if ((x5 % 100) != x6 / 100)
									continue;
								//System.out.println(x1+" "+x2+" "+x3+" "+x4+" "+x5+" "+x6);

								
								if(x6%100==x1/100)
								{
									System.out.println(x1+"  "+x2+"  "+x3+" "+x4+" "+x5+" "+x6);
									//System.exit(1);
								}
							}
						}
					}
				}
			}
		}
	}

}
