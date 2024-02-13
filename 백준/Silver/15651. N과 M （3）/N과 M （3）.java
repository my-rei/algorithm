import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		makePer(0, "");
		System.out.println(sb);
	}

	static void makePer(int cnt, String s) {
		if (cnt == M) {
			sb.append(s + "\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			makePer(cnt + 1, s + (i + 1) + " ");
		}
	}
}
