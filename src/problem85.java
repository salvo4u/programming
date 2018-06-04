
public class problem85 {
	public static void main(String[] args) {
		int N=2000000;
		int number=1,prevnumber=1;
		int myn = 0,mym = 0;
		long t1=System.currentTimeMillis();
		for(int i=53;i<1415;i++)
		{
			for(int j=1415;j>=1;j--)
			{
				number=i*j*(i+1)*(j+1)/4;
					if(number>prevnumber && number<N)
					{
						prevnumber=number;
						myn=i;
						mym=j;
					}
			}
		}
		long t2=System.currentTimeMillis();
	System.out.println(mym+"  "+myn+"  "+(myn*mym));
	System.out.println("TIME:"+(t2-t1)+" milliseconds");
	}
}
