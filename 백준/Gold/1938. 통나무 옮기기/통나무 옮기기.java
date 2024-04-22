import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int str = 0, stc = 0, std = 0, sct = 0, etr = 0, etc = 0, etd = 0, ect = 0;
	static char[][] map;
	static boolean[][][] vs;
	static int[] dr = {-1,1,0,0,0}, dc = {0,0,-1,1,0};
	static int[][] cr = {{-1,0,1}, {0,0,0}}, cc = {{0,0,0}, {-1,0,1}};
	static int[] tr = {-1,-1,-1,0,0,1,1,1}, tc= {-1,0,1,-1,1,-1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		vs = new boolean[N][N][2];
		for(int i = 0;i<N;i++) {
			map[i] = br.readLine().toCharArray();
			for(int j = 0;j<N;j++) {
				if(map[i][j] == 'B') { 
					if(sct == 1) {str = i; stc = j;}
					sct++;
				}
				if(map[i][j] == 'E') { 
					if(ect == 1) {etr = i; etc = j;}
					ect++;
				}
			}
		}
//		System.out.println(str+" "+stc+" "+std+" / "+etr+" "+etc+" "+etd);
		if(stc != 0 && map[str][stc-1] == 'B') {
			std = 1;
		}
		if(etc != 0 && map[etr][etc-1] == 'E') {
			etd = 1;
		}
		
		int minMove = bfs();
//		for(int i = 0;i<N;i++) {
//			for(int j = 0;j<N;j++) {
//				System.out.print((vs[i][j][0]? "O":"X")+"/"+(vs[i][j][0]? "O":"X")+" ");
//			}
//			System.out.println();
//		}
//		System.out.println("=============");
		bw.write(String.valueOf(minMove));
		bw.flush();
		
	}
	
	static int bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {str, stc, std, 0});
		vs[str][stc][std] = true;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int r = now[0], c = now[1], dir = now[2];
			for(int d = 0;d<4;d++) {
				int nr = r+dr[d], nc = c+dc[d];
				if(canMove(nr, nc, dir, d) && !vs[nr][nc][dir]) {
					vs[nr][nc][dir] = true;
					q.add(new int[] {nr, nc, dir, now[3]+1});
					if(nr == etr && nc == etc && dir == etd) return now[3]+1;
				}
			}
			if(canTurn(r, c, (dir+1)%2, 4) && !vs[r][c][(dir+1)%2]) {
				vs[r][c][(dir+1)%2] = true;
				q.add(new int[] {r, c, (dir+1)%2, now[3]+1});
				if(r == etr && c == etc && dir == etd) return now[3]+1;
			}
		}
		return 0;
	}
	
	
	static boolean canMove(int r, int c, int dir, int fw) {
		for(int i = 0;i<3;i++) {
			int nr = r+cr[dir][i], nc = c+cc[dir][i];
			if(nr < 0 || nr >= N || nc <0||nc>=N) return false;
			if(map[nr][nc] == '1') return false;
		}
		return true;
	}
/*	4
	BBB1
	0E01
	1E11
	1E11*/
	static boolean canTurn(int r, int c, int dir, int fw) {
		for(int d=0;d<8;d++) {
			int nr = r+tr[d], nc = c+tc[d];
			if(nr < 0 || nr >= N || nc <0||nc>=N) return false;
			if(map[nr][nc] == '1') return false;
		}
		return true;
	}
}