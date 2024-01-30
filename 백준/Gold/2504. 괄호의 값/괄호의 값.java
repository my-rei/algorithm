import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();

		Stack<Character> st = new Stack<>();

		// ( [ 받을 때마다 점수 증가
		// ) ] 닫히면 점수 감소
		// () [] 들어올 때마다 sum에 점수 더해줌,
		int sum = 0, num = 1;
		for (int i = 0; i < str.length; i++) {
			if (str[i] == '(') {
				num *= 2;
				st.add(str[i]);
			} else if (str[i] == '[') {
				num *= 3;
				st.add(str[i]);
			} else if (str[i] == ')') {
				if (i == 0 || st.isEmpty() || st.peek() != '(') {
					sum = 0;
					break;
				} else {
					if (str[i - 1] == '(') {
						sum += num;
					}
					num /= 2;
					st.pop();
				}
			} else if (str[i] == ']') {
				if (i == 0 || st.isEmpty() || st.peek() != '[') {
					sum = 0;
					break;
				} else {
					if (str[i - 1] == '[') {
						sum += num;
					}
					num /= 3;
					st.pop();
				}
			}
		}

		System.out.println(st.isEmpty() ? sum : 0);
	}
}
