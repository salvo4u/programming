import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class problem91 {
	public static double getDistance(float x1, float y1, float x2, float y2) {
		return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}

	public static void main(String args[]) {
		float n = 2;
		int count = 0;
		int x3 = 0, y3 = 0;
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();

		List<Object> arrlist = new ArrayList<Object>();

		for (float x1 = 0; x1 <= n; x1++) {
			for (float y1 = 0; y1 <= n; y1++) {
				for (float x2 = 0; x2 <= n; x2++) {
					for (float y2 = 0; y2 <= n; y2++) {

						float mpq, mpo, mqo;
						double a = getDistance(x1, y1, x2, y2);
						double b = getDistance(x1, y1, x3, y3);
						double c = getDistance(x2, y2, x3, y3);

						if ((a + b > c && b + c > a && a + c > b)) {
							float minx, maxx, miny, maxy;
							
							minx = x1 < x2 ? x1 : x2;
							maxx = x1 + x2 - minx;

							miny = y1 < y2 ? y1 : y2;
							maxy = y1 + y2 - miny;

							String key = minx + " " + maxx + " " + miny + " "
									+ maxy;
							arrlist.add(key);

							if (map.get(key) != null)
								continue;
							map.put(key, true);
							
							if (x2 == 0)
								mpo = Integer.MAX_VALUE;
							else
								mpo = y2 / x2;

							if (x1 == 0)
								mqo = Integer.MAX_VALUE;
							else
								mqo = y1 / x1;

							if (x1 != x2)
								mpq = (y2 - y1) / (x2 - x1);
							else
								mpq = Integer.MAX_VALUE;

							if ((mpq == Integer.MAX_VALUE && mpo == 0)
									|| (mpq == Integer.MAX_VALUE && mqo == 0)
									|| (mpo == Integer.MAX_VALUE && mqo == 0)
									|| (mpo == Integer.MAX_VALUE && mpq == 0)
									|| (mqo == Integer.MAX_VALUE && mpo == 0)
									|| (mqo == Integer.MAX_VALUE && mpq == 0)) {
								count++;

								  System.out.println(x1 + "," + y1 + "  " + x2
								  + "," + y2 + "  0,0  pq:" + mpq + "  po:" +
								  mpo + "  qo:" + mqo);
								
								continue;
							}
							if (mpq * mpo == -1 || mpq * mqo == -1
									|| mqo * mpo == -1) {
								count++;
								
								  System.out.println(x1 + "," + y1 + "  " + x2
								  + "," + y2 + "  0,0  pq:" + mpq + "  po:" +
								  mpo + "  qo:" + mqo);
								 
							}
						}
					}
				}
			}
		}
		Object[] arr = arrlist.toArray();
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println(count+"  "+arr.length);
		arrlist = Arrays.asList(arr);
	}
}
