package threads;

import java.util.WeakHashMap;

public class ReaderWriter {
	public static void main(String[] args) {
		     WeakHashMap map=new WeakHashMap();

		     String s1=new String("java");
		     map.put(s1, "good");
		     String s2=new String("java");
		     map.put(s2,"ok");

		    //Since s1.equals(s2) is true and hash is same, the earlier value against key s1 ("good") in the map is replaced by the new one. ("ok")

		     s1=null;

		     System.gc();
		    System.out.println(map);
		  }
}
