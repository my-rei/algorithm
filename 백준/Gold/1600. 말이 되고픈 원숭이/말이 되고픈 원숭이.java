import java.io.*;
import java.util.*;

public class Main {
	static int K, W, H;
	static int[][] map;
	static boolean[][][] vs;
	static int[][] dr = {{1,0,-1,0,-2,-2,-1,-1,1,1,2,2},{1,0,-1,0}}, dc= {{0,1,0,-1,-1,1,-2,2,-2,2,-1,1}, {0,1,0,-1}}; 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken()); H = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		
		
		for(int i =0;i<H;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<W;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bw.write(String.valueOf(bfs()));
		bw.flush();
	}
	
	static int bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {0,0,K,0});
		vs = new boolean[H][W][K+1];
		for(int k=0;k<K+1;k++) vs[0][0][k] = true;
		if(H==1&&W==1) return 0;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int dim = now[2]>0? 0:1; //0말가능 1말불가 
//			System.out.println(Arrays.toString(now)+" "+dr[dim].length);
			for(int d=0;d<dr[dim].length;d++) {
				int nr = now[0]+dr[dim][d], nc = now[1]+dc[dim][d], nn = d>3?now[2]-1:now[2];
				if(nr>-1&&nr<H&&nc>-1&&nc<W&&!vs[nr][nc][nn]&&map[nr][nc]!=1) {
					if(nr==H-1&&nc==W-1) return now[3]+1;
					vs[nr][nc][nn] = true;
//					System.out.println(Arrays.toString(new int[] {nr, nc, nn, now[3]+1}));
					q.add(new int[] {nr, nc, nn, now[3]+1});
				}
			}
		}
		return -1;
	}
}