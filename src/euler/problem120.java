package euler;
public class problem120 {
	public static void main(String args[])
	{
		int sum=0;
		for(int a=3;a<=1000;a++)
		{
			int r=2*a*((a-1)/2);
			sum+=r;
		}
	System.out.println(sum);
	}	
}