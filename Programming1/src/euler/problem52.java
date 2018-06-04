package euler;
import java.util.HashSet;

public class problem52 {
	public static HashSet<Integer> getSet(String number) {
		HashSet<Integer> s = new HashSet<Integer>();
		for (int i = 0; i < (number).length(); i++) {
			char ch = (number).charAt(i);
			s.add(ch - 48);
		}
		return s;
	}

	public static void main(String args[]) {
		int x = 0;
		for (;;) {
			x++;
			int x6 = 6 * x;
			int x5 = 5 * x;
			HashSet<Integer> s6 = getSet(x6 + "");
			HashSet<Integer> s5 = getSet(x5 + "");
			s6.removeAll(s5);
			
			if (s6.size() == 0) {
				int x4 = 4 * x;
				HashSet<Integer> s4 = getSet(x4 + "");
				s5.removeAll(s4);
				
				if ( s5.size() == 0) {
					int x3 = 3 * x;
					HashSet<Integer> s3 = getSet(x3 + "");
					s4.removeAll(s3);
					
					if (s4.size() == 0) {
						int x2 = 2 * x;
						HashSet<Integer> s2 = getSet(x2 + "");
						s3.removeAll(s2);
						
						if (s3.size() == 0) {
							int x1 =  x;
							HashSet<Integer> s1 = getSet(x1 + "");
							s2.removeAll(s1);
							
								if(s2.size()==0)
								{
									System.out.println(x);
									break;
								}
						}

					}
				}
			}

		}
	}
}
