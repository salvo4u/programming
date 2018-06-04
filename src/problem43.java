import java.util.Vector;

public class problem43 {
	public boolean isPresent(String x,String y)
	{
		return x.contains(y);
	}
	public static int divisble17(String number) {
		if (new Integer(number) % 17 == 0) {
			String x = number + "";
			char d1 = x.charAt(0);
			char d2 = x.charAt(1);
			char d3 = x.charAt(2);
			if (d1 != d2 && d2 != d3 && d3 != d1)
				return 1;
			else
				return 0;
		} else
			return 0;

	}

	public static void main(String args[]) {
		Vector<String> v17 = new Vector<String>();
		// 1.calculate the last three digits they must be divisble by 17
		for (int i = 17; i < 1000; i++) {
			if (i >= 100) {
				if (divisble17(i+"") == 1) {
					v17.add(i + "");
				}
			}
			if (i < 100) {
				if (divisble17("0"+i) == 1) {
					v17.add("0" + i);
				}
			}
		}

		//2.from v17 pick out all numbers having first two digits divisble by 13
		Vector<String> v13 = new Vector<String>();

		for (int i = 0; i < v17.size(); i++) {
			String number = v17.get(i) + "";

			int d1 = number.charAt(0) - 48;
			int d2 = number.charAt(1) - 48;
			int d3 = number.charAt(2) - 48;

			for (int j = 0; j < 10; j++) {
				if (number.contains(j+""))
					continue;

				int number2 = j * 100 + d1 * 10 + d2;
				if (number2 % 13 == 0 && j != d1 && j != d2)
					v13.add(j + "" + d1 + "" + d2 + "" + d3);
			}
		}

		Vector<String> v11 = new Vector<String>();
		for (int i = 0; i < v13.size(); i++) {
			String number = v13.get(i) + "";

			int d1 = number.charAt(0) - 48;
			int d2 = number.charAt(1) - 48;

			for (int j = 0; j < 10; j++) {
				if (number.contains(j+""))
					continue;

				int number2 = j * 100 + d1 * 10 + d2;
				if (number2 % 11 == 0 && j != d1 && j != d2)
					v11.add(j + "" + number);
			}
		}

		Vector<String> v7 = new Vector<String>();
		for (int i = 0; i < v11.size(); i++) {
			String number = v11.get(i) + "";

			int d1 = number.charAt(0) - 48;
			int d2 = number.charAt(1) - 48;

			for (int j = 0; j < 10; j++) {
				if (number.contains(j+""))
					continue;

				int number2 = j * 100 + d1 * 10 + d2;
				if (number2 % 7 == 0 && j != d1 && j != d2)
					v7.add(j + "" + number);
			}
		}
		
		Vector<String> v5 = new Vector<String>();
		for (int i = 0; i < v7.size(); i++) {
			String number = v7.get(i) + "";

			int d1 = number.charAt(0) - 48;
			int d2 = number.charAt(1) - 48;

			for (int j = 0; j < 10; j++) {
				if (number.contains(j+""))
					continue;

				int number2 = j * 100 + d1 * 10 + d2;
				if (number2 % 5 == 0 && j != d1 && j != d2)
					v5.add(j + "" + number);
			}
		}
		Vector<String> v3 = new Vector<String>();
		for (int i = 0; i < v5.size(); i++) {
			String number = v5.get(i) + "";

			int d1 = number.charAt(0) - 48;
			int d2 = number.charAt(1) - 48;

			for (int j = 0; j < 10; j++) {
				if (number.contains(j+""))
					continue;

				int number2 = j * 100 + d1 * 10 + d2;
				if (number2 % 3 == 0 && j != d1 && j != d2)
					v3.add(j + "" + number);
			}
		}
		System.out.println(v3);
		Vector<String> v2 = new Vector<String>();
		for (int i = 0; i < v3.size(); i++) {
			String number = v3.get(i) + "";

			int d1 = number.charAt(0) - 48;
			int d2 = number.charAt(1) - 48;

			for (int j = 0; j < 10; j++) {
				if (number.contains(j+""))
					continue;

				int number2 = j * 100 + d1 * 10 + d2;
				if (number2 % 2 == 0 && j != d1 && j != d2)
					v2.add(j + "" + number);
			}
		}
		System.out.println(v2);
		Vector<String> v = new Vector<String>();
		long bigsum=0;
		for (int i = 0; i < v2.size(); i++) {
			String number = v2.get(i) + "";
			int sum=0;
				for(int j=0;j<number.length();j++)
				sum+=number.charAt(j)-48;
			int missingdigit=45-sum;
			v.add(missingdigit+number);
			bigsum+=new Long(missingdigit+number);
		}
		System.out.println(v);
		System.out.println(bigsum);
		
	}
}
