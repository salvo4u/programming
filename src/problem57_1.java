
public class problem57_1 {
	public static String add(String a, String b) {
		String sum = "";
		int carry = 0;
		if (a.length() > b.length()) {
			String temp = a;
			a = b;
			b = temp;
		}
		for (int i = 0; i < a.length(); i++) {
			int s = a.charAt(a.length() - 1 - i) + b.charAt(b.length() - 1 - i)
					- 96 + carry;
			if (s > 9) {
				carry = (s - s % 10) / 10;
				s = s % 10;
			} else {
				carry = 0;
			}
			sum = s + sum;
		}

		for (int i = 0; i < b.length() - a.length(); i++) {
			int s = b.charAt(b.length() - a.length() - 1 - i) + carry - 48;

			if (s > 9) {
				carry = (s - s % 10) / 10;
				s = s % 10;
			} else {
				carry = 0;
			}
			sum = s + sum;

		}
		if (carry != 0)
			return carry + sum;
		else
			return sum;
	}
	public static void main(String args[])
	{
		String n1=3+"",n2=7+"";
		String d1=2+"",d2=5+"";
		int count=0;
			for(int i=3;i<=1000;i++)
			{
				String n3temp=add(n2+"",n2+"");
				String n3=add(n3temp,n1);
				
				String d3temp=add(d2+"",d2+"");
				String d3=add(d3temp,d1);
			
				n1=n2;
				n2=n3;
				d1=d2;
				d2=d3;
				
					if(n3.length()>d3.length())
						count++;
				
			}
			System.out.println(count);
	}
}
