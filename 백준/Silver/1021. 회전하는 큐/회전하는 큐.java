
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
			int leftCnt = 0, rightCnt = 0;

			while (dq.size() > 0) {
//				System.out.println(((LinkedList<Integer>)dq).indexOf(target) + " : " + dq.size() / 2);
				if (dq.peek() == target) {
					dq.pop();
					break;
				} else if (((LinkedList<Integer>)dq).indexOf(target) > dq.size() / 2) {
					dq.offerFirst(dq.pollLast());
					cnt++;
//					System.out.println(dq);
					continue;
				} else if (((LinkedList<Integer>)dq).indexOf(target) < dq.size() / 2) {
					dq.offerLast(dq.pollFirst());
					cnt++;
//					System.out.println(dq);
					continue;
				} else if (((LinkedList<Integer>)dq).indexOf(target) == dq.size() / 2) {
					dq.offerLast(dq.pollFirst());
					cnt++;
//					System.out.println(dq);
					continue;
//					if (k != Integer.parseInt(nm[1]) - 1 && ((LinkedList<Integer>)dq).indexOf(Integer.parseInt(nums[k+1])) > dq.size() / 2) {
//						System.out.println("here");
//						dq.offerFirst(dq.pollLast());
//						cnt++;
//						System.out.println(dq);
//						continue;
//					} else {
//						dq.offerLast(dq.pollFirst());
//						cnt++;
//						System.out.println(dq);
//						continue;
//					}
				}
			}

//			cnt += Math.min(leftCnt, rightCnt);
		}
		System.out.println(cnt);

	}
}