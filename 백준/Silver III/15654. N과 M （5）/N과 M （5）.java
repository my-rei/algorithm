import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] nums;
	static boolean[] visited;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<N;i++) nums[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(nums);
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
			if(!visited[i]) {
				visited[i] = true;
				makePer(cnt + 1, s + nums[i] + " ");
				visited[i] = false;
			}
		}
	}
}
