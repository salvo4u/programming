package euler;
import java.util.HashMap;

class problem32{
	static HashMap m ;

	static int digitCount(int num)
	{
		
		int count=0;
		while(num!=0)
		{
			if(num%10==0)
				return -9;
			if(m.get(num%10)==null)
				m.put(num%10,new Integer(1));
			
			num=num/10;
			count++;
		}
		return count;
	}
	
	public static void main(String args[])
	{
		int sum=0;
		for(int i=1234;i<5000;i++)
		{
			for(int j=1;j<10;j++)
			{
				m=new HashMap();
				if(digitCount(i)+digitCount(j)+digitCount(i*j)==9)
				{
					int flag=1;
					for(int i1=1;i1<10;i1++)
					{
						if(m.get(i1)==null){
							flag=0;
							break;
						}
					}
				if(flag==1)
					{System.out.println(i+" * "+j+" = "+i*j);sum+=i*j;}
				}
			}		
		}
		
		for(int i=123;i<=987;i++)
		{
			for(int j=1;j<=99;j++)
			{
				m=new HashMap();
				if(digitCount(i)+digitCount(j)+digitCount(i*j)==9)
				{
					int flag=1;
					for(int i1=1;i1<10;i1++)
					{
						if(m.get(i1)==null){
							flag=0;
							break;
						}
					}
				if(flag==1)
					{System.out.println(i+" * "+j+" = "+i*j);sum+=i*j;}
				}
			}		
		}

		System.out.print(sum);
	}
}