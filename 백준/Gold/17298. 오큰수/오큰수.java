
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String[] an = br.readLine().split(" ");

		Stack<int[]> st = new Stack<>();
		int[] result = new int[n];

		int cnt = 0;
		for (String s : an) {
			int target = Integer.parseInt(s);
			if (st.empty() || st.peek()[1] >= target) {
				st.push(new int[] { cnt++, target });
			} else if (st.peek()[1] < target) {
				while ((!st.empty()) && st.peek()[1] < target) {
					int[] t = st.pop();
					result[t[0]] = target;
				}
				st.push(new int[] { cnt++, target });
			}
		}

		while (!st.empty()) {
			result[st.pop()[0]] = -1;
		}

		System.out.println(Arrays.toString(result).replaceAll("[\\[\\],]", ""));
	}
}