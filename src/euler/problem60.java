package euler;
import java.util.Vector;

public class problem60 {
	public static boolean isPrime(long num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	public static boolean checkConcat(int num1, int num2) {
		String s1 = num1 + "" + num2 + "";
		String s2 = num2 + "" + num1 + "";

		if (isPrime(new Integer(s1)) && isPrime(new Integer(s2)))
			return true;
		else
			return false;
	}

	public static void main(String args[]) {
		int n = 5;
		int arr[] = new int[n];
		Vector<Integer> p = new Vector<Integer>();
		p.add(2);
		for (int i = 3; i < 9000; i = i + 2) {
			if (isPrime(i))
				p.add(i);
		}
		int flag = 1;
		long t1=System.currentTimeMillis();
		for (int i1 = 0; i1 < p.size(); i1++) {
			arr[0] = p.get(i1);
			flag = 1;
			for (int i2 = i1 + 1; i2 < p.size(); i2++) {
				arr[1] = p.get(i2);
				if (checkConcat(arr[0], arr[1]) == false)
					continue;

				for (int i3 = i2 + 1; i3 < p.size(); i3++) {
					arr[2] = p.get(i3);

					if (checkConcat(arr[0], arr[2]) == false
							|| checkConcat(arr[1], arr[2]) == false)
						continue;

					for (int i4 = i3 + 1; i4 < p.size(); i4++) {
						arr[3] = p.get(i4);
						if (checkConcat(arr[0], arr[3]) == false
								|| checkConcat(arr[1], arr[3]) == false||checkConcat(arr[2], arr[3]) == false)
							continue;

						
						for (int i5 = i4 + 1; i5 < p.size(); i5++) {
							arr[4] = p.get(i5);

							flag = 1;
							for (int j = 0; j < n - 1; j++) {
								for (int k = j + 1; k < n; k++) {

									boolean val = checkConcat(arr[j], arr[k]);
									if (val == false) {
										flag = 0;
										break;
									}
								}
								if (flag == 0)
									break;
							}
							if (flag == 1) {
								System.out.println(arr);
								System.out.println(arr[0]  + arr[1] + 
										+ arr[2] + arr[3] +arr[4]);

								long t2=System.currentTimeMillis();
								System.out.println("time:"+(t2-t1));

								System.exit(1);
							}
						}
					}
				}
			}
		}

	}
}