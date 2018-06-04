package hackerank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;
import java.util.TreeMap;

public class Transmissions {
	public static int arr[];
	public static ArrayList<String> list = new ArrayList<String>();
	public static ArrayList<String> oplist = new ArrayList<String>();
	public static HashMap<String, String> chmap = new HashMap<String, String>();
	public static TreeMap<Integer, String> calcmap = new TreeMap<Integer, String>();
	private static String x;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int N = new Integer(s);
		arr = new int[N];
		String s1 = "";
		int pos = 0;
		long MAXNUMBER = 1;
		for (char x = 'a'; x < 'a' + N; x++) {
			s1 = s1 + x;
			s = br.readLine();
			arr[pos++] = new Integer(s);
			if(arr[pos-1]!=0)
			MAXNUMBER = MAXNUMBER * arr[pos - 1];
		}
		chmap.put(0 + "", "+");
		chmap.put(1 + "", "-");
		chmap.put(2 + "", "*");
		chmap.put(3 + "", "/");

		permuteOperations(N);
		permuteString("", s1);
		//System.out.println(list);
		Iterator<Integer> iterator = calcmap.keySet().iterator();
		Integer lastval = iterator.next();
		boolean flag=false;
		for (; iterator.hasNext();) {
			//System.out.println(calcmap.get(lastval)+" = "+lastval);
			Integer val = iterator.next();
			if (val - lastval != 1) {
				System.out.println(lastval + 1);
				flag=true;
				break;
			}
			lastval = val;
		}
		if(flag==false)
			System.out.println(MAXNUMBER+1);
		
}

	public static void permuteOperations(int N) {
		int add[] = new int[N - 1];
		int pos = 0;
		int MAXPOWER = (int) Math.pow(4, N - 1);
		while (true) {

			if (pos++ >= MAXPOWER)
				break;

			int j = 0;
			add[j]++;

			while (add[j] > 3 && j != N - 1) {
				add[j] = 0;
				j++;
				if (j == N - 1)
					break;
				add[j]++;
			}

			String s = "";
			for (int i = 0; i < add.length; i++) {
				s = s + (String) chmap.get(add[i] + "") + "";
			}
			// System.out.println(s);
			oplist.add(s);
		}
	}

	public static void permuteString(String beginningString, String endingString) {
		if (endingString.length() <= 1) {
			list.add(beginningString + endingString);
			String s = beginningString + endingString;

			// compue the whole string to be evaluated
			for (int j = 0; j < oplist.size(); j++) {
				String oper = oplist.get(j);
				x = "";
				x = arr[s.charAt(0) - 'a'] + "";
				for (int i = 1; i < s.length(); i++) {
					x = x + oper.charAt(i - 1) + "" + arr[s.charAt(i) - 'a'];
				}

				Integer answer = evaluatePostfix(convert2Postfix(x));
				if (answer > 0)
					calcmap.put(answer, x);

			}
		} else
			for (int i = 0; i < endingString.length(); i++) {
				try {
					String newString = endingString.substring(0, i)
							+ endingString.substring(i + 1);

					permuteString(beginningString + endingString.charAt(i),
							newString);
				} catch (StringIndexOutOfBoundsException exception) {
					exception.printStackTrace();
				}
			}
	}

	private static final String operators = "-+/*";
	private static final String operands = "0123456789";

	public static int evalInfix(String infix) {
		return evaluatePostfix(convert2Postfix(infix));
	}

	public static String convert2Postfix(String infixExpr) {
		char[] chars = infixExpr.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		StringBuilder out = new StringBuilder(infixExpr.length());

		for (char c : chars) {
			if (isOperator(c)) {
				while (!stack.isEmpty() && stack.peek() != '(') {
					if (operatorGreaterOrEqual(stack.peek(), c)) {
						out.append(stack.pop());
					} else {
						break;
					}
				}
				stack.push(c);
			} else if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					out.append(stack.pop());
				}
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else if (isOperand(c)) {
				out.append(c);
			}
		}
		while (!stack.empty()) {
			out.append(stack.pop());
		}
		return out.toString();
	}

	public static int evaluatePostfix(String postfixExpr) {
		char[] chars = postfixExpr.toCharArray();
		Stack<Integer> stack = new Stack<Integer>();
		for (char c : chars) {
			if (isOperand(c)) {
				stack.push(c - '0'); // convert char to int val
			} else if (isOperator(c)) {
				int op1 = stack.pop();
				int op2 = stack.pop();
				int result;
				switch (c) {
				case '*':
					result = op1 * op2;
					stack.push(result);
					break;
				case '/':
					result = op2 / op1;
					stack.push(result);
					break;
				case '+':
					result = op1 + op2;
					stack.push(result);
					break;
				case '-':
					result = op2 - op1;
					stack.push(result);
					break;
				}
			}
		}
		return stack.pop();
	}

	private static int getPrecedence(char operator) {
		int ret = 0;
		if (operator == '-' || operator == '+') {
			ret = 1;
		} else if (operator == '*' || operator == '/') {
			ret = 2;
		}
		return ret;
	}

	private static boolean operatorGreaterOrEqual(char op1, char op2) {
		return getPrecedence(op1) >= getPrecedence(op2);
	}

	private static boolean isOperator(char val) {
		return operators.indexOf(val) >= 0;
	}

	private static boolean isOperand(char val) {
		return operands.indexOf(val) >= 0;
	}
}
