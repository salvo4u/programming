package euler;

public class problem31_1 {
	public static void main(String args[])
	{
		int arr[]=new int[8];
		arr[0]=1;
		arr[1]=2;
		arr[2]=5;
		arr[3]=10;
		arr[4]=20;
		arr[5]=50;
		arr[6]=100;
		arr[7]=200;
		
		int total[]=new int[201];
		total[0]=1;
			for(int i=0;i<arr.length;i++)
			{
				for(int j=arr[i];j<201;j++)
				{
					total[j]+=total[j-arr[i]];
				}
			}
		
		System.out.println(total[200]);
	}
}
