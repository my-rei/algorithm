
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Deque<Integer> dq = new ArrayDeque<>();
		for (int i =1;i<=n;i++) {
			dq.offer(i);
		}
		
		while(dq.size() > 1) {
			dq.poll();
			dq.offer(dq.poll());
		}
		
		System.out.println(dq.peek());
	}
}
