
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] towers = br.readLine().split(" ");
		Stack<Integer> st1 = new Stack<>();
		Stack<Integer> st2 = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int tower, temp;
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			temp = Integer.parseInt(towers[i]);
			while (true) {
				if (st1.empty()) {
					sb.append("0 ");
					break;
				}
				
				
				//st2.add(tower);
				if (temp < Integer.parseInt(towers[st1.peek()])) {
					sb.append((st1.peek()+1) + " ");
					break;
				} else {
					tower = st1.pop();
				}
			}
//			while (!st2.empty())
//				st1.add(st2.pop());
			st1.add(cnt++);
		}

		System.out.println(sb);
	}
}
