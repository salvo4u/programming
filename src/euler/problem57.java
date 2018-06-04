package euler;

public class problem57 {
	public final static Fraction fone=new Fraction(1);
	public static Fraction generateSum(int num)
	{
		String s = "1/(2/1", x = "", s1 = "+1/2";
		Fraction fadd =null;		
		for (int i = 0; i < num - 1; i++)
			x = x + "+" + s;
		x = x + s1;

		for (int i = 0; i < num - 1; i++)
			x = x + ")";
		x = "(1/1" + x + ")";
		
		
		
		StringBuffer str = new StringBuffer(x);

		for (int i = 0; i < num - 1; i++) {
			int openindex = str.lastIndexOf("(", str.length() - 1);
			int closeindex = str.indexOf(")");

			String addstring = str.substring(openindex + 1, closeindex);

			String arr[] = addstring.split("[+]");
			String arr1[] = arr[0].split("/");
			String arr2[] = arr[1].split("/");

			Fraction f1 = new Fraction(new Integer(arr1[0]), new Integer(
					arr1[1]));
			Fraction f2 = new Fraction(new Integer(arr2[0]), new Integer(
					arr2[1]));

			fadd = f1.add(f2);
			
			str.replace(openindex - 2, closeindex + 1, fadd.getDenominator()
					+ "/" + fadd.getNumerator());
		}
		Fraction fnew = new Fraction(fadd.getDenominator(), fadd
				.getNumerator());
		Fraction f1=new Fraction(1,1);
		return fnew.add(f1); 
	}
	public static void main(String args[]) {
		int num = 100;
		int count=0;

		long t1=System.currentTimeMillis();
		for(int i=4;i<num;i++)
		{
			Fraction f=generateSum(i);
			System.out.print(f.getNumerator()+"/"+f.getDenominator()+"  "+i+"  ");
			if((f.getNumerator()+"").length()>(f.getDenominator()+"").length())
			{
				count++;
				System.out.print("here");	
			}
			System.out.println();
		}
		long t2=System.currentTimeMillis();
		System.out.println(count+" "+(t2-t1));
	}
}
