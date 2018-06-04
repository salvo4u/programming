package euler;
public class problem30 {
	public static void main(String args[]) {
		long ans=0;
			for(int i=2;i<999999;i++)
			{
				String x=i+"";
				long sum=0;
					for(int j=0;j<x.length();j++)
						sum=sum+(long)Math.pow(x.charAt(j)-'0',5);
				if(sum==i)
					ans+=sum;
				
			}
			System.out.println(ans);
	}
}
