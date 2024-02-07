import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()),
				R = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		List<Integer> orders = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int lastO = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			int o = Integer.parseInt(st.nextToken());
			if ((lastO == 1 || lastO == 2) && lastO == o)
				lastO = 0;
			else
				orders.add(o);
		}

		for (int k : orders) {
			if (k == 1) {
				int[][] temp = new int[N / 2][M];
				for (int i = 0; i < N / 2; i++) {
					for (int j = 0; j < M; j++) {
						temp[i][j] = map[i][j];
						map[i][j] = map[N - i - 1][j];
					}
				}
				for (int i = 0; i < N / 2; i++) {
					for (int j = 0; j < M; j++) {
						map[N - i - 1][j] = temp[i][j];
					}
				}

			} else if (k == 2) {
				int[][] temp = new int[N][M / 2];
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M / 2; j++) {
						temp[i][j] = map[i][j];
						map[i][j] = map[i][M - j - 1];
					}
				}
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M / 2; j++) {
						map[i][M - j - 1] = temp[i][j];
					}
				}
			} else if (k == 3) {
				Queue<Integer> q = new LinkedList<>();
				for (int i = 0; i < N; i++)
					for (int j = 0; j < M; j++)
						q.offer(map[i][j]);
				
				int temp = N;
				N = M; M=temp;
				map = new int[N][M];
				for (int j = M - 1; j > -1; j--)
					for (int i = 0; i < N; i++)
						map[i][j] = q.poll();

			} else if (k == 4) {
				Queue<Integer> q = new LinkedList<>();
				for (int i = 0; i < N; i++)
					for (int j = 0; j < M; j++)
						q.offer(map[i][j]);

				int temp = N;
				N = M; M=temp;
				map = new int[N][M];
				for (int j = 0; j < M; j++)
					for (int i = N - 1; i > -1; i--)
						map[i][j] = q.poll();

			} else if (k == 5) {
				Queue<Integer> q = new LinkedList<>();
				for (int i = 0; i < N/2; i++) for (int j = 0; j < M/2; j++) q.offer(map[i][j]);
				for (int i = 0; i < N/2; i++) for (int j = M/2; j < M; j++) q.offer(map[i][j]);
				for (int i = N/2; i < N; i++) for (int j = M/2; j < M; j++) q.offer(map[i][j]);
				for (int i = N/2; i < N; i++) for (int j = 0; j < M/2; j++) q.offer(map[i][j]);
				
				for (int i = 0; i < N/2; i++) for (int j = M/2; j < M; j++) map[i][j] = q.poll();
				for (int i = N/2; i < N; i++) for (int j = M/2; j < M; j++) map[i][j] = q.poll();
				for (int i = N/2; i < N; i++) for (int j = 0; j < M/2; j++) map[i][j] = q.poll();

				for (int i = 0; i < N/2; i++) for (int j = 0; j < M/2; j++) map[i][j] = q.poll();	
			} else if (k == 6) {
				Queue<Integer> q = new LinkedList<>();
				for (int i = 0; i < N/2; i++) for (int j = 0; j < M/2; j++) q.offer(map[i][j]);
				for (int i = 0; i < N/2; i++) for (int j = M/2; j < M; j++) q.offer(map[i][j]);
				for (int i = N/2; i < N; i++) for (int j = M/2; j < M; j++) q.offer(map[i][j]);
				for (int i = N/2; i < N; i++) for (int j = 0; j < M/2; j++) q.offer(map[i][j]);
				
				
				for (int i = N/2; i < N; i++) for (int j = 0; j < M/2; j++) map[i][j] = q.poll();
				for (int i = 0; i < N/2; i++) for (int j = 0; j < M/2; j++) map[i][j] = q.poll();
				for (int i = 0; i < N/2; i++) for (int j = M/2; j < M; j++) map[i][j] = q.poll();	
				for (int i = N/2; i < N; i++) for (int j = M/2; j < M; j++) map[i][j] = q.poll();
			}
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}
}
