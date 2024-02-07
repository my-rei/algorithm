import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
	static int[][] rooms;
	static boolean[][] bigRooms;
	static boolean[][] visited;
	static int N, maxCnt = 0;
	static int[][] delta = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
	static Now maxNow;

	static class Now {
		public int i;
		public int j;
		public int roomCnt;
		public int roomVal;
		public int startVal;

		public Now(int i, int j, int rcnt, int rv, int sv) {
			this.i = i;
			this.j = j;
			this.roomCnt = rcnt;
			this.roomVal = rv;
			this.startVal = sv;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			rooms = new int[N][N];
			maxNow = new Now(0, 0, 0, 0, 0);
			
			for (int i = 0; i < N; i++) {
				String[] tmp = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					rooms[i][j] = Integer.parseInt(tmp[j]);
				}
			}

			bigRooms = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!bigRooms[i][j])
						bfs(i, j);
				}
			}
			sb.append("#" + t + " " + maxNow.startVal + " " + maxNow.roomCnt + "\n");
		}
		System.out.println(sb);
	}

	static void bfs(int i, int j) {
		Queue<Now> queue = new ArrayDeque<>();
		visited = new boolean[N][N];

		queue.add(new Now(i, j, 1, rooms[i][j], rooms[i][j]));
		visited[i][j] = true;

		while (!queue.isEmpty()) {
			for (int[] d : delta) {
				int curI = queue.peek().i + d[0];
				int curJ = queue.peek().j + d[1];

				if (curI > -1 && curI < N && curJ > -1 && curJ < N && !visited[curI][curJ]
						&& queue.peek().roomVal+1 == rooms[curI][curJ]) {
					visited[curI][curJ] = true;
					bigRooms[curI][curJ] = true;

					queue.add(new Now(curI, curJ, queue.peek().roomCnt + 1, rooms[curI][curJ], queue.peek().startVal));
				}
			}

			Now temp = queue.poll();
			if (queue.isEmpty() && temp.roomCnt > maxNow.roomCnt)
				maxNow = temp;
			if (queue.isEmpty() && temp.roomCnt == maxNow.roomCnt && temp.startVal < maxNow.startVal)
				maxNow = temp;
		}
	}
}
