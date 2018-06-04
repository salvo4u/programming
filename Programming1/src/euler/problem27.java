package euler;
import java.util.HashMap;

public class problem27 {
	public static boolean isPrime(int a, int b, int n) {
		
		int num = n * n + a * n + b;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

public static void main(String args[]) {
	final int c=1000;
	final int arr[]=new int[2000];
	final  HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
		
	
	for(int i=-c+1;i<=c-1;i++){
		
	arr[i+c]=i;
	final int z=arr[i+c];
		
		new Thread(){		
			public void run(){
				int maxn=0,maxa=0,maxb=0;
				int x=z;
				for(int j=-c+1;j<=c-1;j++)
				{
					int n=0;
					while(isPrime(x,j,n)){
						
						n++;
					}
					if(n>maxn){
						maxa=x;
						maxb=j;
						maxn=n;
					}	
				}
				h.put(new Integer(maxn),new Integer(maxa*maxb));
			}
		}.start();
		
	}
	
	new Thread(){
		public void run()
		{
			try {
				sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("\n-----"+h.size());
			System.out.println("\n"+h.keySet()+"  \n"+h.get(1011)+"  "+h.get(1000)+"  "+h.get(40));

		}
	}.start();
	
	
	

}
}
