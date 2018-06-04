package random;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RandomQuestions {
	public static void main(String args[]) {
		int i = 0;
		try {
			String s = "aaaaa";
			Matcher m = Pattern.compile("$").matcher(s);
			m.find();
			int length = m.end();
			System.out.println(length);
		
			while (true) {
				s.charAt(i++);
			}
		} catch (Exception e) {
			System.out.println(i-1);
		}
	}
}
