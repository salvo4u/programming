public class problem71 {
	static double constantfrac=(double) (3.0/7.0);
	public static void main(String args[])
	{
		double frac=1,lastfrac=(double) (3.0/8.0);
		int count=0;
		double lastn=0,lastd=0;
		float limit=1000000;
		for(double n=limit;n>=1;n--)
		{
			for(double d=limit;d>=1;d--)
			{
				frac=(double)(n/d);
				if(frac>=lastfrac && frac<=constantfrac)
				{
					lastn=n;
					lastd=d;
					lastfrac=frac;
					count++;
						if(count>100000)
						{
							System.out.println(lastn+"  "+lastd+"  "+lastfrac+"  "+constantfrac+"  "+count);
							System.exit(0);
						}
				}
				else
					break;
			}
		}
		
		System.out.println(lastfrac+" "+count+"  "+lastn+"  "+lastd);
		
	System.out.println((float)(428570.0 / 999997)+"  "+constantfrac);
	}
}
