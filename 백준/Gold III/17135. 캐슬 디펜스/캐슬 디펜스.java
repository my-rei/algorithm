import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/* 
 * 백준 17135 캐슬디펜스 
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()),
				D = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		Queue<int[]> queue = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().replace(" ", "").toCharArray();
		}

		int maxCnt = 0;
//		for(int m = 0;m<N;m++) {
//			for(int n = 0;n<M;n++) {
//				if(map[m][n] == '1') { queue.add(new int[] {m,n});}
//			}
//		}
		for (int i = 0; i < M; i++) {
			for (int j = i + 1; j < M; j++) {
				for (int k = j + 1; k < M; k++) {

					int cnt = 0;
					// i, j, k
					for (int m = 0; m < N; m++) {
						for (int n = 0; n < M; n++) {
							if (map[m][n] == '1') {
								queue.add(new int[] { m, n, 0 });
							}
						}
					}
					while (!queue.isEmpty()) {
						getQ(queue, N, i);
//						System.out.printf("i:: %d,%d => %d,%d(%d)\n", N, i, queue.peek()[0], queue.peek()[1], queue.peek()[2]);
//						System.out.println(inDis(queue.peek()[0], queue.peek()[1], N, i, D));
						if (inDis(queue.peek()[0], queue.peek()[1], N, i, D)) {
							queue.add(new int[] { queue.peek()[0], queue.peek()[1], queue.peek()[2] + 1 });
							queue.poll();
						}
						getQ(queue, N, j);
//						System.out.printf("j:: %d,%d => %d,%d(%d)\n", N, j, queue.peek()[0], queue.peek()[1], queue.peek()[2]);

						if (inDis(queue.peek()[0], queue.peek()[1], N, j, D)) {
							queue.add(new int[] { queue.peek()[0], queue.peek()[1], queue.peek()[2] + 1 });
							queue.poll();
						}
						getQ(queue, N, k);
//						System.out.printf("k:: %d,%d => %d,%d(%d)\n", N, k, queue.peek()[0], queue.peek()[1], queue.peek()[2]);

						if (inDis(queue.peek()[0], queue.peek()[1], N, k, D)) {
							queue.add(new int[] { queue.peek()[0], queue.peek()[1], queue.peek()[2] + 1 });
							queue.poll();
						}

						Queue<int[]> newQ = new ArrayDeque<>();
						while(!queue.isEmpty()) {
							if (queue.peek()[0] + 1 < N && queue.peek()[2] == 0) {
								newQ.add(new int[] { queue.peek()[0] + 1, queue.peek()[1], queue.peek()[2] });
							}
							if(queue.peek()[2] > 0) {
								cnt++;
							}
							queue.poll();
						}
						queue = newQ;
					}
//					if (cnt > maxCnt)
//						System.out.println("max ==> " + i + " " + j + " " + k);

					maxCnt = Math.max(maxCnt, cnt);

					if (queue.isEmpty()) {
//						System.out.println("B  " + i + " " + j + " " + k);
						// break;
					}
				}

			}

		}
		System.out.println(maxCnt);
	}

	static void getQ(Queue<int[]> q, int r1, int c1) {
		List<int[]> list = new ArrayList<>();
		int q1 = q.size();
		for (int i = 0; i < q1; i++)
			list.add(q.poll());
		list.sort(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return getDis(o1[0], o1[1], r1, c1) == getDis(o2[0], o2[1], r1, c1) ? o1[1] - o2[1]
						: getDis(o1[0], o1[1], r1, c1) - getDis(o2[0], o2[1], r1, c1);
			}
		});
		for (int i = 0; i < list.size(); i++)
			q.add(list.get(i));
	}

	static int getDis(int r1, int c1, int r2, int c2) {
		return Math.abs(r1 - r2) + Math.abs(c1 - c2);
	}

	static boolean inDis(int r1, int c1, int r2, int c2, int d) {
		return getDis(r1, c1, r2, c2) <= d;
	}
}
