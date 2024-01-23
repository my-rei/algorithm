
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] pieces = br.readLine().toCharArray();
		
		Stack<Character> st = new Stack<>();
		
		int stick = 0;
		int ps = 0;
		for(char p : pieces) {
			// if laser
			if (!st.isEmpty() && st.peek() == '(' && p == ')') {
				stick--;
				st.add(p);
				ps += stick;
			}
			// if stick
			else if (!st.isEmpty() && st.peek() == ')' && p == ')') {
				stick--;
				ps++;
				st.add(p);
			}
			else if (p == '(') {
				stick++;
				st.add(p);
			}
			else {
				System.out.println("asdfasdf");
			}
		}
		
		System.out.println(ps);
	}
}