
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		char[] cs;
		boolean flag;
		while (!((cs = br.readLine().toCharArray()).length == 1 && cs[0] == '.')) {
			flag = false;
			for (char c : cs) {
				if (c == '[') {
					stack.add(c);
				} else if (c == '(') {
					stack.add(c);
				} else if (c == ']') {
					if (stack.size() != 0 && stack.peek() == '[') {
						stack.pop();
					} else if (stack.size() != 0 && stack.peek() == '(') {
						flag = true;
						break;
					} else if (stack.size() == 0) {
						flag = true;
						break;
					}
				} else if (c == ')') {
					if (stack.size() != 0 && stack.peek() == '(') {
						stack.pop();
					} else if (stack.size() != 0 && stack.peek() == '[') {
						flag = true;
						break;
					} else if (stack.size() == 0) {
						flag = true;
						break;
					}
				}
			}
			if (stack.size() > 0) {
				flag = true;
			}

			if (flag) {
				sb.append("no\n");
			} else {
				sb.append("yes\n");
			}

			stack.clear();
		}

		System.out.println(sb);
	}
}
