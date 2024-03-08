import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K;
	static int[][] minVis;
	static boolean[][][] vs;
	static char[][] map;
	static Queue<int[]> queue;
	static int[] dr = {1,0,-1,0}, dc = {0,1,0,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		minVis = new int[N][M];
		map = new char[N][M];
//		vs = new boolean[K+1][N][M];
		
		for(int i = 0;i<N;i++) {
			map[i] = br.readLine().toCharArray();
			Arrays.fill(minVis[i], -1);
		}
		bw.write(String.valueOf(N==1&&M==1? "1":bfs()));
		bw.flush();
		
//		for(int i = 0;i<N;i++) {
//			System.out.println(Arrays.toString(minVis[i]));
//		}
		
	}
	
	
	static int bfs() {
		queue = new ArrayDeque<>();
		queue.add(new int[] {0,0,K,1});
		minVis[0][0] = -1;
		
		int minCount = Integer.MAX_VALUE;
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
//			System.out.println(Arrays.toString(now));
			for(int d = 0;d<4;d++) {
				int nr = now[0]+dr[d], nc = now[1]+dc[d], nk=now[2];
				if(nr<0||nr>=N||nc<0||nc>=M) continue;
				if(nr == N-1 && nc == M-1) {
					return now[3]+1;
				}
				if(map[nr][nc] == '1' && nk > 0 && (minVis[nr][nc] == -1 || minVis[nr][nc] < nk-1)) {
					minVis[nr][nc] = nk-1;
					queue.add(new int[] {nr, nc, nk-1, now[3]+1});
				} else if(map[nr][nc] == '0' && (minVis[nr][nc] == -1 || minVis[nr][nc] < nk)){
					minVis[nr][nc] = nk;
					queue.add(new int[] {nr, nc, nk, now[3]+1});
				}
			}
		}
		return -1;
	}
}