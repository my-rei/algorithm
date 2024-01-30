import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test = 0; test < T; test++) {
			char[] cs = br.readLine().toCharArray();

			Stack<Character> st = new Stack<>();

			boolean isVPS = true;

			for (char c : cs) {
				//System.out.println(st);
				if (st.empty()) {
					if (c == ')') {
						isVPS = false;
						break;
					} else {
						st.add(c);
					}
				} else {
					char top = st.peek();

					if (top == '(' && c == ')') {
						// 올바른 경우
						st.pop();
					} else if (c == '(') {
						st.add(c);
					}
				}
			}

			sb.append(isVPS && st.isEmpty() ? "YES\n" : "NO\n");
		}
		
		System.out.println(sb);
	}
}
