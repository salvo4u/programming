package euler;
import java.util.Vector;


public class problem38 {
	public static boolean freq(String number)
	{
		int arr[]={0,0,0,0,0,0,0,0,0};
		
			for(int i=0;i<number.length();i++)
			{
				int pos=number.charAt(i)-48;
				if(pos==0)
					return false;
				arr[pos-1]++;
			}
			for(int i=0;i<9;i++)
			{
				if(arr[i]!=1)
					return false;
			}
		return true;	
	}
	public static void main(String args[])
	{
		//1.generate starting 3 digit distinct numbers
		Vector<String> v=new Vector<String>();
		
		
		for(int i=123;i<987;i++)
		{
			char num1=(i+"").charAt(0);
			char num2=(i+"").charAt(1);
			char num3=(i+"").charAt(2);
			//System.out.println(num1+num2+num3);
			if(num1=='0' || num2=='0' || num3=='0')
				continue;
			if(num1=='9' || num2=='9' || num3=='9')
				continue;
			
			if(num1!=num2  && num2!=num3 && num3!=num1)
			{
				v.add("9"+i);
			}
		}
		System.out.println(v);
		int largest=0;
		for(int i=0;i<v.size();i++)
		{
			int number1=new Integer(v.get(i).toString());
			long number2=number1*2;
			String s=number1+""+number2+"";
			//System.out.println(s);
			if(s.length()==9)
			{
				if(freq(s))
				{
					System.out.println(s+"  "+number1);
					
					int number=new Integer(s);
						if(number>largest)
							largest=number;
				}
			}
			

		}
}
}