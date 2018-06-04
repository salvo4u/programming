package euler;
import java.util.HashMap;

public class problem86 {
	public static void main(String[] args) {
		int M = 99;
		int sum = 0,sum1=0;
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		for (int l = 1; l <= M; l++) {
			for (int b = 1; b <= M; b++) {
				for (int h = 1; h <= M; h++) {
					double D = Math.sqrt((b + h) * (b + h) + l * l);
					if (D - (int) D == 0) {
						sum++;
					}

				}
			}
		}
		System.out.println(sum%3+"  "+sum/3);
		System.out.println(sum1);
	}
}
