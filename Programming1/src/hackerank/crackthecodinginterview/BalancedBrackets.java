package hackerank.crackthecodinginterview;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
    static Stack<Character> s = new Stack<Character>();    
    public static boolean isBalanced(String expression) {
        for(int i=0;i<expression.length();i++){
            Character ch = expression.charAt(i),ch1 = null;
            if(ch == '(' || ch == '{' || ch == '[')
                s.push(ch);
            else{
            	if(!s.empty())
            		ch1 = s.pop();
            	else 
            		ch1 = null;
            }
            if(ch1==null)
                continue;
            if(!(ch==')' && ch1=='(' ||   ch=='}' && ch1=='{' || ch==']' && ch1=='['))
            	return false;
                
        }
        System.out.println(s);
        return s.empty();
        
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}
