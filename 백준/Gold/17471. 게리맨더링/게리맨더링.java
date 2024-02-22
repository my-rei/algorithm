import java.io.*;
import java.util.*;

public class Main {
	static int N, minDif;
	static int[] population;
	static boolean[] isSelected, visited;
	static boolean[][] edge;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());

		minDif = Integer.MAX_VALUE;
		isSelected = new boolean[N + 1];
		edge = new boolean[N + 1][N + 1];
		population = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			for (int j = 1; j <= c; j++) {
				int t = Integer.parseInt(st.nextToken());
				edge[i][t] = true;
			}
		}

		isSelected[1] = true;
		getCombi(1, 1);
		System.out.println(minDif == Integer.MAX_VALUE ? -1 : minDif);
	}

	static void getCombi(int cnt, int cur) {
		if (leftover()) {
			updateMinDif();
		}

		if (cnt == N)
			return;

		for (int i = 1; i <= N; i++) {
			if (!isSelected[i] && isClose(i)) {
				isSelected[i] = true;
				getCombi(cnt + 1, i + 1);
				isSelected[i] = false;
			}
		}

	}

	static boolean leftover() {
		int cnt = 0, s = 0;
		for (int i = 1; i <= N; i++)
			if (!isSelected[i]) {
				cnt++;
				s = i;
			}
		if (cnt == 0 || cnt == N)
			return false;
		if (cnt == 1) 
			return true;

		// 남은 경로 탐색
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(s);
		visited = new boolean[N + 1];

		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (int i = 1; i <= N; i++) {
				if (edge[now][i] && !isSelected[i] && !visited[i]) {
					visited[i] = true;
					queue.add(i);
					cnt--;
				}
			}
		}

		if (cnt > 0)
			return false;

		return true;
	}

	static void updateMinDif() {
		int sSum = 0, uSum = 0;
		for (int i = 1; i <= N; i++) {
			if (isSelected[i])
				sSum += population[i];
			else
				uSum += population[i];
		}

		minDif = Math.min(minDif, Math.abs(sSum - uSum));
	}

	static boolean isClose(int cur) {
		for (int i = 1; i <= N; i++) {
			if (isSelected[i] && edge[i][cur])
				return true;
		}
		return false;
	}
}