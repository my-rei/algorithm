
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		Stack<Integer> st = new Stack<>();
		int temp = 0;
		int nums = 1;

		boolean flag = false;
		for (int i = 0; i < n; i++) {
			temp = Integer.parseInt(br.readLine());
			while (true) {
				if (!st.empty() && st.peek() == temp) {
					st.pop();
					sb.append("-\n");
					break;
				} else if (!st.empty() && st.peek() > temp) {
					
					flag = true;
					break;
				} else if (st.empty() && nums != 1 && nums > temp) {
					
					flag = true;
					break;
				} else {
					st.push(nums++);
					sb.append("+\n");
					continue;
				}
			}
			if (flag) {
				
				sb = new StringBuilder();
				sb.append("NO");
				break;
			}
		}

		System.out.println(sb);
	}
}