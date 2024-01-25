
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		Stack<Integer> st = new Stack<>();
		long sumCnt = 0, cnt = 0;
		int target;
		for (int i = 0; i < n; i++) {
			target = Integer.parseInt(br.readLine());
//			System.out.println(st + " " + sumCnt+" "+target);
			if (st.empty()) {
				st.push(target);
				continue;
			}
				
			if (!st.empty() && st.peek() <= target) {
				cnt = 0;
				while (!st.empty() && st.peek() <= target) {
//					System.out.println(st.peek() + " " + sumCnt + cnt);
					 st.pop();
					sumCnt += st.size();
				}
				if (cnt == 1)
					sumCnt += cnt;
				st.push(target);
			} else if (!st.empty() && st.peek() > target) {
				st.push(target);
			}
		}
		cnt = 0;
		while (!st.empty()) {
			st.pop();
			sumCnt += st.size();
		}
//		System.out.println(st);
		System.out.println(sumCnt);
	}
}