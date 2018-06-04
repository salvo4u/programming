package euler;
public class problem34 {
	public static void main(String args[])
	{
		int arr[]={1,1,2,6,24,120,720,5040,40320,362880};
		long total=0;
		double ninearr[]={9999,99999,999999,9999999,99999999};	
		for(int i=3;i<10000000;i++)
		{
			int num=i;
			long sum=0;
			while(num!=0)
			{
				int mod=num%10;
				sum+=arr[mod];
				num=num/10;
			}
			if(sum==i)
				total+=i;
		}
	System.out.println(total);
	}
	
}
