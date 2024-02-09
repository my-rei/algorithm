import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int target;
		while (N-- > 0) {
			if ((target = Integer.parseInt(br.readLine())) == 0) {
				sb.append(pq.peek() == null ? "0":pq.poll() ).append("\n");
			} else {
				pq.add(target);
			}
		}
		System.out.println(sb);
	}
}