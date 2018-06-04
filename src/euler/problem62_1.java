package euler;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Vector;


public class problem62_1 {
	public static HashMap<String, Vector<Long>> hash = new HashMap<String, Vector<Long>>();

	public static void main(String args[])
	{
		for(long i=0;i<9000;i++)
		{
			Long cube=i*i*i;
			char[] arr = cube.toString().toCharArray();
			Arrays.sort(arr);
			String key=new String(arr);
			System.out.println(key+"  "+i+"  "+hash.get(key));
				if(hash.get(key)==null)
				{
					Vector<Long> v=new Vector<Long>();
					v.add(i);
					hash.put(key, v);
				}
				else
				{
					Vector<Long> v=hash.get(key);
						if(v.size()==4)
						{
							System.out.println(Math.pow(v.get(0),3));
							System.out.println(v);
							System.exit(1);
						}
					v.add(i);
					hash.put(key, v);
				}
		}
	}
}
