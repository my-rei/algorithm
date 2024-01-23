import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static int s = 0, e = 0;
	public static String[] nums;
//	public static Deque<Integer> deque;
	public static boolean reverseFlag = false;
	public static boolean errorFlag = false;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int t = Integer.parseInt(br.readLine());

		String func = "";
		int n = 0;
		String temp;
		for (int i = 0; i < t; i++) {
			func = br.readLine();
			n = Integer.parseInt(br.readLine());

			s = 0;
			e = n;
			nums = new String[n];
//			deque = new ArrayDeque<Integer>();
			temp = br.readLine();
			st = new StringTokenizer(temp.substring(1, temp.length() - 1), ",");
			for (int j = 0; j < n; j++) {
				nums[j] = st.nextToken();
//				deque.add(Integer.parseInt(st.nextToken()));
			}

			errorFlag = false;
			reverseFlag = false;
			for (int k = 0; k < func.length(); k++) {
				if (func.charAt(k) == 'R') {
					reverseFlag = !reverseFlag;
					continue;
				} else if (func.charAt(k) == 'D') {
					if (reverseFlag) {
						if (e < s + 1) {
							errorFlag = true;
							break;
						} else {
//							deque.removeLast();
						}
						e--;

					} else {
						if (e < s + 1) {
							errorFlag = true;
							break;
						} else {
//							deque.removeFirst();
						}
						s++;
					}
					if (errorFlag) {
						break;
					}
				}
			}

			if (errorFlag) {
//				System.out.println("error");
				sb.append("error\n");
			} else {
//				System.out.printf("[");
				sb.append("[");
				if (reverseFlag) {
					for (int l = e - 1; l >= s; l--) {
//						System.out.printf("%s", nums[l]);
//						System.out.printf("%d", deque.pollLast());
//						sb.append(deque.pollLast());
						sb.append(nums[l]);
						if (l != s) {
//							System.out.printf(",");
							sb.append(",");
						}
					}
				} else {
					for (int l = s; l < e; l++) {
//						System.out.printf("%s", nums[l]);
//						System.out.printf("%d", deque.pollFirst());
//						sb.append(deque.pollFirst());
						sb.append(nums[l]);
						if (l != e - 1) {
//							System.out.printf(",");
							sb.append(",");
						}
					}
				}
//				System.out.printf("]\n");
				sb.append("]").append('\n');
			}
			
		}
		System.out.println(sb);
	}

}
