
public class problem69_1 {
	public static void main(String args[])
	{
		int p[]={2,3,5,7,11,13,17,19,23,29,31,37,41};
		Double d=new Double(1);
			for(int i=0;i<p.length;i++)
			{
				d=d*p[i];
					if(d>1000000)
						break;
					
			}
			System.out.println(d);
	}
}
