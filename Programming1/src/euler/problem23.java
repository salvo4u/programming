package euler;

public class problem23 {
	public static void main(String args[])
	{
		for(int i=12;i<100;i++)
		{
			int sum=1;
			for(int j=2;j<=i/2;j++)
			{
				if(i%j==0)
					sum=sum+j;
				
			}
			if(sum>i)
			{
				System.out.println(i);
			}
		}
	}
}
