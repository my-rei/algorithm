
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] nq = br.readLine().split(" ");
		int n = Integer.parseInt(nq[0]);
		int q = Integer.parseInt(nq[1]);

		Stack<Integer[]> back = new Stack<>();
		Stack<Integer[]> front = new Stack<>();
		// {주소, 연속횟수}
		int cur = 0;
		int cnt = 0;
		while (q-- > 0) {
			String[] order = br.readLine().split(" ");
			switch (order[0]) {
			case "B":
				if (!back.isEmpty()) {
					// 현재 보고 있던 페이지를 앞으로 가기 공간에 저장
					front.add(new Integer[] { cur, 1 });
					// 뒤로가기 공간에서 방문한지 가장 최근의 페이지에 접속
					if (back.peek()[1] == 1)
						cur = back.pop()[0];
					else if (back.peek()[1] > 1) {
						int c = back.peek()[1];
						cur = back.pop()[0];
						back.add(new Integer[] { cur, c - 1 });
					}
				}
				break;
			case "F":
				if (!front.isEmpty()) {
					// 현재 보고 있던 페이지를 뒤로 가기 공간에 저장
					if (back.isEmpty() || back.peek()[0] != cur)
						back.add(new Integer[] { cur, 1 });
					else {
						int c = back.pop()[1];
						back.add(new Integer[] { cur, c + 1 });
					}
					// 앞으로 가기 공간에서 방문한지 가장 최근의 페이지에 접속
					cur = front.pop()[0];
				}
				break;
			case "A":
				// 앞으로 가기 공간에 저장된 페이지가 삭제된다
				front.clear();
				// 현재 페이지를 뒤로 가기 공간에 추가
				if (cnt != 0) {
					if (back.isEmpty() || back.peek()[0] != cur)
						back.add(new Integer[] { cur, 1 });
					else {
						int c = back.pop()[1];
						back.add(new Integer[] { cur, c + 1 });
					}
				} else
					cnt = 1;
				// 다음에 접속할 페이지가 현재 페이지로 갱신
				cur = Integer.parseInt(order[1]);
				break;
			case "C":
				for (int i = 0; i < back.size(); i++) {
					Integer[] s = back.get(i);
					if (s[1] > 1) {
						back.set(i, new Integer[] { s[0], 1 });
					}
				}
				break;
			}
		}

		String res1 = "";
		String res2 = "";
		while (back.size() > 0) {
			// 반복
			Integer[] t = back.pop();
			for (int i = 0; i < t[1]; i++) {
				res1 += t[0] + " ";
			}
		}
		while (front.size() > 0) {
			res2 += front.pop()[0] + " ";
		}

//		for (int i = 0; i < front.size(); i++) {
//			res2 += front.get(i)[0] + " ";
//		}

		System.out.printf("%d\n%s\n%s", cur, res1.equals("") ? "-1" : res1, res2.equals("") ? "-1" : res2);
	}
}