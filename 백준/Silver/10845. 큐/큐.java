
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> dq = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String order = br.readLine();
			switch (order) {
			case "front":
				sb.append((dq.peekFirst() != null ? dq.peekFirst() : -1) + "\n");
				break;
			case "back":
				sb.append((dq.peekLast() != null ? dq.peekLast() : -1) + "\n");
				break;
			case "size":
				sb.append(dq.size() + "\n");
				break;
			case "empty":
				sb.append((dq.isEmpty() ? 1 : 0) + "\n");
				break;
			case "pop":
				sb.append((dq.peekFirst() != null ? dq.pollFirst() : -1) + "\n");
				break;
			default:
				if (order.length() > 5 && order.split(" ")[0].equals("push")) {
					dq.offer(Integer.parseInt(order.split(" ")[1]));
				}
			}
		}

		System.out.println(sb);
	}
}