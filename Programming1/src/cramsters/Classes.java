package cramsters;

import java.util.Scanner;

public class Classes {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int mm,dd,yy;
		System.out.println("Enter Month(in number):");
		mm=in.nextInt();
		System.out.println("Enter Day(in number):");
		dd=in.nextInt();
		System.out.println("Enter Year(last 2 digits only):");
		yy=in.nextInt();
		
		if(dd<=0 || dd>31)
		{
			System.out.println("Wrong Day");
			System.exit(1);
		}
		if (mm <= 0 || mm > 12) {
			System.out.println("Wrong Month");
			System.exit(1);
		}
		if (mm * dd == yy)
			System.out.println("Magic Date");
		else
			System.out.println("Not a magic date");
	}
}
