import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] parent;
	static int[][] distance, map;
	static List<Island> iList;
	static int[] dr = { 1, 0, -1, 0 }, dc = { 0, 1, 0, -1 };
	static Queue<int[]> queue;
	static int[][] vs;
	static PriorityQueue<int[]> pq;

	static class Island {
		int number, sr, sc, er, ec, size;

		public Island(int number, int sr, int sc, int er, int ec, int size) {
			this.number = number;
			this.sr = sr;
			this.sc = sc;
			this.er = er;
			this.ec = ec;
			this.size = size;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		vs = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		iList = new ArrayList<>();
		findIsland();
		distance = new int[iList.size()][iList.size()];
		pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
//		for (int i = 0; i < iList.size(); i++) {
//			for (int j = 0; j < iList.size(); j++) {
//				distance[i][j] = calDistance(i, j);
//				if (distance[i][j] != Integer.MAX_VALUE - 1)
//					pq.add(new int[] { i, j, distance[i][j] });
//			}
//		}

//		for (int i = 0; i < vs.length; i++) {
//			for (int j = 0; j < vs[i].length; j++) {
//				System.out.print(vs[i][j] + " ");
//			}
//			System.out.println();
//		}
		for (int i = 0; i < distance.length; i++) {
			Arrays.fill(distance[i], Integer.MAX_VALUE);
		}
		calculate();
		
//		for (int i = 0; i < distance.length; i++) {
//			for (int j = 0; j < distance[i].length; j++) {
//				pq.add(new int[] {i, j, distance[i][j]});
////				System.out.print(distance[i][j] + " ");
//			}
////			System.out.println();
//		}
//		System.out.println("---------");

		parent = new int[iList.size()];
		makeSet();
		int K = iList.size()-1;
		int first = 0;
		int sum = 0;
		while (!pq.isEmpty()) {
			int[] target = pq.poll();
//			if(target[2] == 1) continue;
			if (union(target[0], target[1])) {
//				System.out.println(Arrays.toString(target));
				K--;
				sum += target[2];
			}
			if(K == 0) break;
		}
		if(K > 0) sum = -1;
		bw.write(String.valueOf(sum));
		bw.flush();
	}

	static void makeSet() {
		for (int i = 0; i < iList.size(); i++) {
			parent[i] = i;
		}
	}

	static boolean union(int a, int b) {
		if (find(a) == find(b))
			return false;
		else {
			parent[find(b)] = find(a);
			return true;
		}
	}

	static int find(int a) {
		if (parent[a] == a)
			return parent[a];
		else
			return parent[a] = find(parent[a]);
	}

	static int calculate() {
		int minDis = Integer.MAX_VALUE;
//		Island fi = iList.get(i1);
//		distance[fi.number][fi.number] = 0;

		for (int i = 0; i <N; i++) {
			for (int j = 0; j <M; j++) {
				if (map[i][j] == 1) {
					for (int d = 0; d < 4; d++) {
						int nr = i + dr[d], nc = j + dc[d], nd = 0;
						while (nr > -1 && nr < N && nc > -1 && nc < M) {
							if (map[nr][nc] == 1) {
								if (vs[nr][nc] == vs[i][j]) {
									break;
								} else {
									//
									if (nd > 1) {
//										System.out.printf("%d-%d : %d\n",vs[nr][nc]-1, vs[i][j]-1, nd);
										pq.add(new int[] {vs[nr][nc]-1, vs[i][j]-1, nd});
									}
									break;
								}
							}
							nr += dr[d];
							nc += dc[d];
							nd++;
						}
					}
				}
			}
		}

		return minDis;
	}

	static int calDistance(int i1, int i2) {
		Island fi = iList.get(i1), si = iList.get(i2);
		if (fi.number == si.number)
			return 0;
		int minDis = Integer.MAX_VALUE;
		for (int i = fi.sr; i <= fi.er; i++) {
			for (int j = fi.sc; j <= fi.ec; j++) {
				if (i >= si.sr && i <= si.er && Math.min(Math.abs(j - si.sc), Math.abs(j - si.ec)) > 1) {
					minDis = Math.min(minDis, Math.min(Math.abs(j - si.sc), Math.abs(j - si.ec)));
				}
				if (j >= si.sc && j <= si.ec && Math.min(Math.abs(i - si.sr), Math.abs(i - si.er)) > 1) {
					minDis = Math.min(minDis, Math.min(Math.abs(i - si.sr), Math.abs(i - si.er)));
				}
			}
		}
		for (int i = si.sr; i <= si.er; i++) {
			for (int j = si.sc; j <= si.ec; j++) {
				if (i >= fi.sr && i <= fi.er && Math.min(Math.abs(j - fi.sc), Math.abs(j - fi.ec)) > 1) {
					minDis = Math.min(minDis, Math.min(Math.abs(j - fi.sc), Math.abs(j - fi.ec)));
				}
				if (j >= fi.sc && j <= fi.ec && Math.min(Math.abs(i - fi.sr), Math.abs(i - fi.er)) > 1) {
					minDis = Math.min(minDis, Math.min(Math.abs(i - fi.sr), Math.abs(i - fi.er)));
				}
			}
		}
		return minDis - 1;
	}

	static void findIsland() {
		queue = new ArrayDeque<int[]>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && vs[i][j] == 0) {
					int er = i, ec = j;
					vs[i][j] = iList.size() + 1;
					queue.add(new int[] { i, j });
					while (!queue.isEmpty()) {
						for (int d = 0; d < 4; d++) {
							int nr = queue.peek()[0] + dr[d], nc = queue.peek()[1] + dc[d];
							if (nr > -1 && nr < N && nc > -1 && nc < M && map[nr][nc] == 1 && vs[nr][nc] == 0) {
								vs[nr][nc] = iList.size() + 1;
								queue.add(new int[] { nr, nc });
							}
						}
						if (queue.size() == 1) {
							er = queue.peek()[0];
							ec = queue.peek()[1];
						}
						queue.poll();
					}
					iList.add(new Island(iList.size(), i, j, er, ec, (er - i) * (ec - j)));
				}
			}
		}
	}
}