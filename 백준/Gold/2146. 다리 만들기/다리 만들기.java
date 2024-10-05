import java.io.*;
import java.util.*;

public class Main {
	static int[] dr = new int[] {1,-1,0,0};
	static int[] dc = new int[] {0,0,1,-1};
	static int N, minBridge=Integer.MAX_VALUE;
	static int[][] map, visited;
	static Queue<int[]> mainQueue, queue;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new int[N][N];
		mainQueue = new ArrayDeque<>();
		queue = new ArrayDeque<>();
		StringTokenizer st = null;
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int num = -1;
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<N;j++) {
				if(map[i][j] == 1 && visited[i][j] == 0) {
					findContinent(i, j, num--);
				}
			}
		}
		
		while(!mainQueue.isEmpty()) {
			int[] cur = mainQueue.poll();
			goBridge(cur[0], cur[1], visited[cur[0]][cur[1]]);
		}
		
		System.out.println(minBridge);
	}
	
	static void findContinent(int si, int sj, int num) {
		queue.add(new int[] {si, sj});
		visited[si][sj] = num;
		while(!queue.isEmpty()) {
			int[] cij = queue.poll();
			boolean flag = false;
			for(int d = 0;d<4;d++) {
				int di = cij[0]+dr[d];
				int dj = cij[1]+dc[d];
				
				if(di<0||di>=N||dj<0||dj>=N||visited[di][dj] != 0) continue;
				if(map[di][dj] == 1) {
					queue.add(new int[] {di, dj});
					visited[di][dj] = num;
				} else {
					flag = true;
				}
			}
			
			if(flag)
				mainQueue.add(new int[] {cij[0], cij[1]});
		}
	}
	
	static void goBridge(int si, int sj, int con) {
		queue.clear();
		queue.add(new int[] {si, sj, 0});
		
		while(!queue.isEmpty()) {
			int[] cij = queue.poll();
			int cur = cij[2];
			if(cur+1 > minBridge) continue;
			for(int d = 0;d<4;d++) {
				int di = cij[0]+dr[d];
				int dj = cij[1]+dc[d];
				
				if(di<0||di>=N||dj<0||dj>=N||visited[di][dj] == con) continue;
				if(visited[di][dj] < 0) {
					minBridge = Math.min(minBridge, cur);
				} else if(visited[di][dj] == 0||visited[di][dj] > cur+1) {
					visited[di][dj] = cur+1;
					queue.add(new int[] {di, dj, cur+1});
				}
			}
		}
	}
}