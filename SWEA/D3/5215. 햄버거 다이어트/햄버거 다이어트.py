import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, limit, maxScore;
	static Food[] foods;

	static class Food {
		int score;
		int cal;

		public Food(int s, int c) {
			this.score = s;
			this.cal = c;
		}
	}

	static void dfs(int cur, int cal, int sco, int cnt) {
		if(cal <= limit) maxScore = Math.max(maxScore, sco);
		if(cnt == N) return;
		
		for (int i = cur; i < N; i++) {
			dfs(i + 1, cal + foods[i].cal, sco + foods[i].score, cnt+1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			limit = Integer.parseInt(st.nextToken());

			foods = new Food[N];
			maxScore = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				foods[i] = new Food(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			dfs(0, 0, 0, 0);

			sb.append("#" + test + " " + maxScore + "\n");
		}
		System.out.println(sb);
	}
}
