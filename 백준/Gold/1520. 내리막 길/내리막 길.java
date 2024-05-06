import java.io.*;
import java.util.*;

public class Main {
	static int M, N;
	static int[][] map, cal;
	static int[] dr = {-1,0,1,0}, dc = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		cal = new int[M][N];
		
		for(int i = 0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			Arrays.fill(cal[i], -1);
		}
		
		cal[M-1][N-1] = 1;
		bw.write(String.valueOf(dfs(0,0)));
		bw.flush();
	}
	
	static int dfs(int r, int c) {
		if(cal[r][c] != -1) return cal[r][c];
		int temp = 0;
		for(int d = 0;d<4;d++) {
			int nr = r+dr[d], nc = c+dc[d];
			if(nr<0||nr>=M||nc<0||nc>=N) continue;
			if(map[nr][nc] < map[r][c]) {
				temp += dfs(nr, nc);
			}
		}
		
		cal[r][c] = temp;
		return temp;
	}
}