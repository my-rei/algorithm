import java.io.*;
import java.util.*;

public class Solution {
	static int N, eSum, MAX = 2050;
	static Atom[][] map;
	static Queue<Atom> queue;
	static int[] dr = { 0, 0, -1, 1 }, dc = { 1, -1, 0, 0 };

	static class Atom {
		int n, r, c, d, t, energy;

		public Atom(int n ,int r, int c, int d, int t, int energy) {
			this.n = n;
			this.r = r;
			this.c = c;
			this.d = d;
			this.t = t;
			this.energy = energy;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int test = 1; test <= T; test++) {
			N = Integer.parseInt(br.readLine());

			map = new Atom[MAX][MAX];
			queue = new ArrayDeque<>();
			Atom a = null;
			int number = 1;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				a = new Atom(number++, Integer.parseInt(st.nextToken()) + 1000, Integer.parseInt(st.nextToken()) + 1000,
						Integer.parseInt(st.nextToken()), 0, Integer.parseInt(st.nextToken()));
				queue.add(a);
				map[a.r][a.c] = a;
			}

			eSum = 0;
			Set<Integer> check = new HashSet<>();
			//Atom empty = new Atom(0, 0, 0, -1, 0);
			while (!queue.isEmpty()) {
				int size = queue.size();
				while (size-- > 0) {
					a = queue.poll();
					if (map[a.r][a.c] != null && map[a.r][a.c].t == a.t)
						map[a.r][a.c] = null;
					int nr = a.r + dr[a.d], nc = a.c + dc[a.d];
					if (nr < 0 || nr >= MAX || nc < 0 || nc >= MAX || check.contains(a.n))
						continue;
					if (map[nr][nc] != null && (map[nr][nc].t == a.t + 1)) {
						check.add(map[nr][nc].n);
						eSum += map[nr][nc].energy + a.energy;
						map[nr][nc] = new Atom(number++, 0, 0, 0, a.t + 1, 0);
						continue;
					} else if (map[nr][nc] != null && (map[nr][nc].t == a.t)) {
						// 반대방향일때만충돌
						if (map[nr][nc].d == 0 && a.d == 1 || map[nr][nc].d == 2 && a.d == 3
								|| map[nr][nc].d == 1 && a.d == 0 || map[nr][nc].d == 3 && a.d == 2) {
							eSum += map[nr][nc].energy + a.energy;
							check.add(map[nr][nc].n);
							map[nr][nc] = null;
							continue;
						} 
						
					}
					a.r = nr; a.c = nc; a.t += 1;
					map[nr][nc] = a;
					queue.add(a);

				}
			}

			sb.append("#" + test + " " + eSum + "\n");
		}
		bw.write(sb.toString());
		bw.flush();

	}
}