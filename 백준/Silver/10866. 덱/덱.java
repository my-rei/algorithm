
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque<Integer> dq = new ArrayDeque<>();

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String[] order = br.readLine().split(" ");
			switch (order[0]) {
			case "push_front":
				dq.offerFirst(Integer.parseInt(order[1]));
				break;
			case "push_back":
				dq.offerLast(Integer.parseInt(order[1]));
				break;
			case "pop_front":
				sb.append((dq.peekFirst() != null ? dq.pollFirst() : -1) + "\n");
				break;
			case "pop_back":
				sb.append((dq.peekLast() != null ? dq.pollLast() : -1) + "\n");
				break;
			case "size":
				sb.append((dq.size()) + "\n");
				break;
			case "empty":
				sb.append((dq.isEmpty() ? 1 : 0) + "\n");
				break;
			case "front":
				sb.append((dq.peekFirst() != null ? dq.peekFirst() : -1) + "\n");
				break;
			case "back":
				sb.append((dq.peekLast() != null ? dq.peekLast() : -1) + "\n");
				break;
			}
		}

		System.out.println(sb);
	}
}