import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] numbers, selected;
	static StringBuilder sb;
	static int N, M;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			numbers[i] = Integer.parseInt(st.nextToken());
		selected = new int[M];
		visited = new boolean[N];
		Arrays.sort(numbers);
		findPer(0, 0);
		System.out.println(sb);
	}

	static void findPer(int cur, int cnt) {
		if (cur == N || cnt >= M) {
			for (int i = 0; i < M; i++)
				sb.append(numbers[selected[i]] + " ");
			sb.append("\n");
			return;
		}

		int prev = 0;
		for (int i = 0; i < N; i++) {
			if (!visited[i] && prev != numbers[i]) {
				visited[i] = true;
				selected[cnt] = i;
				findPer(i, cnt + 1);
				visited[i] = false;
				prev = numbers[i];
			}
		}
	}
}
