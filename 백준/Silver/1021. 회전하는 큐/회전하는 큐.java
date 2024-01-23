
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		String[] nums = br.readLine().split(" ");

		Deque<Integer> dq = new LinkedList<>();

		for (int i = 1; i <= Integer.parseInt(nm[0]); i++) {
			dq.offer(i);
		}
		int cnt = 0;
		for (int k = 0; k < Integer.parseInt(nm[1]); k++) {
			int target = Integer.parseInt(nums[k]);

			while (dq.size() > 0) {
				if (dq.peek() == target) {
					dq.pop();
					break;
				} else if (((LinkedList<Integer>)dq).indexOf(target) > dq.size() / 2) {
					dq.offerFirst(dq.pollLast());
					cnt++;
					continue;
				} else if (((LinkedList<Integer>)dq).indexOf(target) < dq.size() / 2) {
					dq.offerLast(dq.pollFirst());
					cnt++;
					continue;
				} else if (((LinkedList<Integer>)dq).indexOf(target) == dq.size() / 2) {
					dq.offerLast(dq.pollFirst());
					cnt++;
					continue;
				}
			}
		}
		System.out.println(cnt);

	}
}