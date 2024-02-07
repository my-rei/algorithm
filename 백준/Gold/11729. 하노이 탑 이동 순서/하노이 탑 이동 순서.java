import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		hanoi(N, 1, 2, 3);
		System.out.println(n+"\n"+sb);
	}

	static void hanoi(int cnt, int from, int by, int to) {
		if (cnt == 1) {
			sb.append(from + " " + to + "\n");
			n++;
		} else {
			hanoi(cnt - 1, from, to, by); // 위에 있는 원반들은 from에서 최종 to를 경유하여 최종by로 가야함.
			sb.append(from + " " + to + "\n");
			n++;
			hanoi(cnt - 1, by, from, to); // 최종 by의 원반들은 초기 from을 경유하여 to로 가야함
		}
	}
}
