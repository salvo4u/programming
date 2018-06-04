package hackerank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class StringReduction {

	static int minLength = Integer.MAX_VALUE;
	static HashMap<String, String> replacemap = new HashMap<String, String>();
	static HashMap<String, Integer> countmap = new HashMap<String, Integer>();

	public static StringBuffer reduced(StringBuffer nargs,int i) {
		StringBuffer args = new StringBuffer(nargs);
		char ch1 = args.charAt(i);
		char ch2 = args.charAt(i + 1);
		
		if (ch1 == ch2)
			return nargs;

		if (ch1 > ch2) {
			char ch = ch1;
			ch1 = ch2;
			ch2 = ch;
		}

		String replaceCh = replacemap.get(ch1 + "" + ch2 + "");
		args.deleteCharAt(i);
		args.deleteCharAt(i);
		args.insert(i, replaceCh);
		int len = args.length();
		if (len < minLength)
			minLength = len;
		return args;
	}

	public static void reduceString(StringBuffer args) {
		
		if (args.length() == 1) {
			minLength = 1;
			return;
		}
		if(countmap.get(args)!=null)
			return;
		ArrayList<StringBuffer> list = new ArrayList<StringBuffer>();
		
		for (int i = 0; i < args.length() - 1; i++) {
			StringBuffer tempargs = reduced(args, i);
			if(!tempargs.toString().equals(args.toString()))
				list.add(tempargs);
		}
		for (int i = 0; i < list.size(); i++)
			{
				StringBuffer key = list.get(i);
				reduceString(key);
				countmap.put(key.toString(), minLength);
			}
	}

	public static void main(String args[]) throws IOException {
		replacemap.put("bc", "a");
		replacemap.put("ac", "b");
		replacemap.put("ab", "c");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		Integer N = new Integer(s);
		for (int i = 0; i < N; i++) {
			s = br.readLine().trim();
			minLength = s.length();
			countmap.clear();
			reduceString(new StringBuffer(s));
			System.out.println(minLength);
		}
	}
}