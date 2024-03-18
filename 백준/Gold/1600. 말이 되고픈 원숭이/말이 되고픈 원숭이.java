import java.io.*;
import java.util.*;

public class Main {
	static int K, W, H;
	static int[][] vs;
	static char[][] map;
	static int[] dr = {1,0,-1,0,-2,-2,-1,-1,1,1,2,2}, dc= {0,1,0,-1,-1,1,-2,2,-2,2,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken()); H = Integer.parseInt(st.nextToken());
		map= new char[H][W];
		vs = new int[H][W];
		for(int i = 0;i<H;i++) {
			map[i] = br.readLine().replace(" ", "").toCharArray();
			Arrays.fill(vs[i], -1);
		}
		bw.write(H==1&&W==1? "0":String.valueOf(bfs()));
		bw.flush();
	}
	
	static int bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		vs[0][0] = K;
		queue.add(new int[] {0,0,K,0});
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for(int d=0;d<dr.length;d++) {
				if(d>=4&&now[2]==0) break;
				int nr = now[0]+dr[d], nc=now[1]+dc[d];
				if(nr<0||nr>=H||nc<0||nc>=W||map[nr][nc] == '1') continue;
				if(nr==H-1&&nc==W-1) return now[3]+1;
				if(d<4 && vs[nr][nc] < now[2] || d>=4 && vs[nr][nc] < now[2]-1) {
					vs[nr][nc] = d<4? now[2]:now[2]-1;
					queue.add(new int[] {nr,nc,d<4?now[2]:now[2]-1,now[3]+1});
				}
			}
		}
		return -1;
		
	}
}