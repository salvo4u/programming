package euler;

public class problem31 {
	public static int count=0;
	public static void Combinations(int amount)
	{
		if(amount == 0)
			{count++;return;}
		
		if(amount<0)
			return;
		System.out.print("\n"+amount+" --->  ");
		
		Combinations(amount-1);
		System.out.print(amount-1+" ");
		Combinations(amount-2);
		System.out.print(amount-2+" ");
		Combinations(amount-5);
		System.out.print(amount-5+" ");
		
		if(amount>=10)
		{
			Combinations(amount-10);
			System.out.print(amount-10+" ");	
		}
		if(amount>=20){
		Combinations(amount-20);
		System.out.print(amount-20+" ");
		}
		if(amount>=50)
		Combinations(amount-50);
		
		if(amount>=100)
		Combinations(amount-100);
		
		if(amount>=200)
		Combinations(amount-200);		
	}
	public static void main(String args[])
	{
		long time1=System.currentTimeMillis();
		Combinations(5);
		long time2=System.currentTimeMillis();
		System.out.println(count+"  "+(time2-time1));
	}
}
