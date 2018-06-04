package cramsters;
import javax.swing.JOptionPane;
public class Question4 {
	public static void main(String[] args) {
		String s = JOptionPane.showInputDialog(null, "Enter an Integer: ");
		try {
			int number = new Integer(s);
			int revnumber = 0;
			
			while(number!=0){
				revnumber=(revnumber*10)+number%10;
				number=number/10;
			}
			JOptionPane.showMessageDialog(null, "Reverse Integer = " + revnumber);
			System.exit(0);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Input Number is Not an Integer.");
		}
	}
}