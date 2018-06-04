
import java.util.Vector;
 
 
public class problem74_1 {
 
	public static void main(String args[])
	{
 
		int fin=0;
 
		int count=0;
		Vector a = null;
		for(int i=1;i<1000000;i++)
		{
			 a=new Vector();
			if(i%10000==0)
			{
			//System.out.println(i+ " "+fin);
			}
 
			int counter=1;
			count++;
 
			int temp=count;
		    a.add(temp);
			while(!(a.contains(dfact(temp))))
			{
 
 
				temp=dfact(temp);
 
				counter++;
 
				a.add(temp);
 
 
				if(counter>60)
					break;
			}
			if(counter==60)
			{
				fin++;
				System.out.println(temp);
			}
 
 
		}
		System.out.println(fin);
		System.out.println(a);
	}
 
	public static int fact(int a)
	{
		if(a==0)
			return 1;
		int sum=1;
		for(int i=1; i<=a; i++)
		{
			sum=sum*i;
		}
 
		return sum;
	}
 
	public static int dfact(int a)
	{
		int sum=0;
		String f=Integer.toString(a);
		for(int i=0; i<f.length();i++)
		{
			int y=Integer.valueOf(f.substring(i,i+1));
 
			sum=sum+fact(y);
		}
		return sum;
	}
 
}