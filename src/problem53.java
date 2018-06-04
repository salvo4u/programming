import java.util.HashMap;

class problem53 {
	static 	HashMap h=new HashMap();
	
	static public double fact(int n)
	{
		if(h.get(n)!=null)
			return new Double(h.get(n).toString());
		
		if (n==1)
			return 1;
		double x= fact(n-1)*n;
		h.put(n, new Double(x));
		return x;
	}
	
	public static void main(String args[]) {
		int n = 1,count=0;
		double ncr=1;
		for (n = 1; n <= 100; n++) {
				for(int r=2;r<=n-2;r++)
				{
					ncr=(fact(n)/fact(n-r))/fact(r);
					if(ncr>1000000)
						count++;
				}
		}
		System.out.println(count);
	}
}