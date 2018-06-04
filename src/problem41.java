

import java.util.Vector;

public class problem41 {
	public static Vector<Integer> v = new Vector<Integer>();
	public static boolean isPrime(int n1) {
		int num = n1;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
	public static void permuteString(String beginningString, String endingString) {
		if (endingString.length() <= 1) {
			String s = beginningString + endingString;
			int num = new Integer(s);
			if (num % 2 != 0 && num % 3 != 0 && num % 5 != 0)
				v.add(num);
		}

		else
			for (int i = 0; i < endingString.length(); i++) {
				try {
					String newString = endingString.substring(0, i)
							+ endingString.substring(i + 1);

					permuteString(beginningString + endingString.charAt(i),
							newString);
				} catch (StringIndexOutOfBoundsException exception) {
					exception.printStackTrace();
				}
			}
	}

	public static void main(String args[]) {
		permuteString("", "1234567");
		long t1=System.currentTimeMillis();
		for(int i=v.size()-1;i>=0;i--)
		{
			if(isPrime(v.get(i)))
			{

				System.out.println(v.get(i));
				break;
			}
		}
		long t2=System.currentTimeMillis();
		System.out.println("TIME: "+(t2-t1)+"millisec");
	}

}
