import java.io.*; 
import java.util.*;

public class Main {
	static int N;
	static int[][] map, dis;
	static int[] dr = {1,0,-1,0}, dc= {0,1,0,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int t = 1;
		
		while((N=Integer.parseInt(br.readLine())) != 0) {
			map = new int[N][N];
			dis = new int[N][N];
			for(int i = 0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dis[i][j] = -1;
				}
			}
			dijkstra();
			sb.append("Problem "+(t++)+": "+dis[N-1][N-1]+"\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void dijkstra() {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {0,0});
		dis[0][0] = map[0][0];
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for(int d=0;d<4;d++) {
				int nr = now[0]+dr[d], nc = now[1]+dc[d];
				if(nr<0||nr>=N||nc<0||nc>=N) continue;
				if(dis[nr][nc] == -1 || dis[now[0]][now[1]] + map[nr][nc] < dis[nr][nc]) {
					dis[nr][nc] = dis[now[0]][now[1]]+map[nr][nc];
					queue.add(new int[] {nr, nc});
				}
			}
		}
	}
}