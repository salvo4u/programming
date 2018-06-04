package geeksforgeeks.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dhuper1 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		for (int i = 1; i < s.length(); i++) {
			for (int j = 0; j <= s.length() - i - i; j++) {
				String sub1 = s.substring(j, j + i);
				String sub2 = s.substring(j + i, j + 2 * i);
				System.out.println(sub1+"  "+sub2+"   length="+i+"  index="+j);
				if(sub1.equals(sub2)){
					System.out.println("WRONG");
					System.exit(1);
				}
			}
		}
		System.out.println("CORRECT");
	}
}
