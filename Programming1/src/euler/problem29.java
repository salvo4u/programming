package euler;
import java.util.HashMap;
import java.util.Iterator;

class problem29 {
	static HashMap<Integer, Integer> getMap(HashMap<Integer, Integer> h, int b) {
		Iterator<Integer> it = h.keySet().iterator();
		while (it.hasNext()) {
			int key = new Integer(it.next().toString());
			int value = new Integer(h.get(key).toString());
			h.put(key, value * b);
		}
		return h;
	}

	static HashMap<Integer, Integer> calcPower(int a, int b) {
		int mod = 2;
		HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
		while (a != 1) {
			if (a % mod == 0) {
				a = a / mod;
				if (freq.get(mod) == null)
					freq.put(mod, 1);
				else {
					Integer x = new Integer(freq.get(mod).toString());
					freq.put(mod, x + 1);
				}
				mod = 1;
			}
			mod++;
		}
		return getMap(freq, b);
	}

	public static void main(String args[]) {
		HashMap<String, Integer> hfinal1 = new HashMap<String, Integer>();
		int N = 100;
		long t1 = System.currentTimeMillis();
		for (int i = 2; i <= N; i++) {
			for (int j = 2; j <= N; j++) {
				HashMap<Integer, Integer> h = calcPower(i, j);
				Iterator<Integer> it = h.keySet().iterator();
				String s = "";
				while (it.hasNext()) {
					int key = new Integer(it.next().toString());
					int value = new Integer(h.get(key).toString());
					s = s + key + "^" + value + "*";
				}
				if (hfinal1.get(s) == null)
					hfinal1.put(s, 1);
			}
		}
		System.out.println(hfinal1.size());
		long t2 = System.currentTimeMillis();
		System.out.println("TIME: " + (t2 - t1) + " millisec");

	}
}