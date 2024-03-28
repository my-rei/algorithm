import java.io.*;
import java.util.*;

public class Main {
	static int R, C;
	static char[][] map;
	static int[] dr = {1,0,-1,0}, dc = {0,1,0,-1};
	static Queue<int[]> q, wq;
	static boolean[][] vs;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken());
		q = new ArrayDeque<>(); wq = new ArrayDeque<>();
		map = new char[R][C];
		vs = new boolean[R][C];
		for(int i = 0;i<R;i++) {
			map[i] = br.readLine().toCharArray();
			for(int j = 0;j<C;j++) {
				if(map[i][j] == '*') wq.add(new int[] {i,j});
				else if(map[i][j] == 'S') {
					map[i][j] = '.';
					q.add(new int[] {i, j, 0});
					vs[i][j] = true;
				}
			}
		}

		bw.write(bfs());
		bw.flush();
	}
	
	static String bfs() {
		while(!q.isEmpty()) {
			int s= wq.size();
			while(s-->0) {
				int[] w = wq.poll();
				for(int d = 0;d<4;d++) {
					int nr = w[0]+dr[d], nc = w[1]+dc[d];
					if(nr<0||nr>=R||nc<0||nc>=C) continue;
					if(map[nr][nc] == '.') {
						map[nr][nc] = '*';
						wq.add(new int[] {nr, nc});
					}
				}
			}
			
			s = q.size();
			while(s-->0) {		
				int[] now = q.poll();
				for(int d = 0;d<4;d++) {
					int nr = now[0]+dr[d], nc = now[1]+dc[d];
					if(nr<0||nr>=R||nc<0||nc>=C) continue;
//					System.out.println(Arrays.toString(new int[] {nr, nc, now[2]+1}));
//					System.out.println(map[nr][nc]);
					if(map[nr][nc] == '*' || map[nr][nc] == 'X' || vs[nr][nc]) continue;
					
					if(map[nr][nc] == 'D') {
						return String.valueOf(now[2]+1);
					}
					vs[nr][nc] = true;
					q.add(new int[] {nr, nc, now[2]+1});
				}
//				System.out.println("------------------");
//				System.out.println(Arrays.toString(now)+" "+q.size());
//				for(int i = 0;i<R;i++) {
//					for(int j = 0;j<C;j++) {
//						System.out.print(map[i][j]);
//					}
//					System.out.println();
//				}
			}
			
		}
		return "KAKTUS";
	}
}