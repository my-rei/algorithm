import java.io.*;
import java.util.*;

public class Main {
	static int N, curI, curJ, time, size, count;
	static int[] dr = new int[] { -1, 0, 0, 1 }, dc = new int[] { 0, -1, 1, 0 };
	static char[][] map;
	static boolean[][] visited;
	static Queue<int[]> queue;
	static List<int[]> tmp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for (int i = 0; i < N; i++)
			map[i] = br.readLine().replace(" ", "").toCharArray();
		for(int i =0;i<N;i++){
			for(int j = 0;j<N;j++)
				if(map[i][j] == '9') {
					curI = i;
					curJ = j;
					map[i][j] = '0';
					break;
				}
		}
		queue = new ArrayDeque<>();
		tmp = new ArrayList<>();
		visited = new boolean[N][N];
		time = 0;
		size = 2;
		swim();
		bw.write(String.valueOf(time));
		bw.flush();
	}

	static void swim() {
		boolean res = findAndGo();
		while (res) {
			if (size == count) {
				size++;
				count = 0;
			}
			res = findAndGo();
		}
		
	}

	static boolean findAndGo() {
		queue.clear();
		queue.add(new int[] { curI, curJ });
		int t = 0;
		visited = new boolean[N][N];
		while (!queue.isEmpty()) {
			tmp.clear();
			int qs = queue.size();
			while (qs-- > 0) {
				int[] pos = queue.peek();
				for (int d = 0; d < 4; d++) {
					int nr = pos[0] + dr[d], nc = pos[1] + dc[d];
					if (nr > -1 && nr < N && nc > -1 && nc < N && !visited[nr][nc] &&  map[nr][nc] - '0' <= size) {
						visited[nr][nc] = true;
						tmp.add(new int[] { nr, nc });
					}
				}
				queue.poll();
			}
			tmp.sort(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0]!=o2[0]? o1[0]-o2[0]:o1[1]-o2[1];
				}
			});
			for(int[] now : tmp) {
				int nr = now[0], nc = now[1];
				if (map[nr][nc] - '0' > 0 && map[nr][nc] - '0' < 7 && map[nr][nc] - '0' < size) {
                    time += t+1;
					curI = nr;
					curJ = nc;
					count += 1;
					map[nr][nc] = '0';
					return true;
				}
				queue.add(now);
			}
			t++;
		}

		return false;
	}
}
