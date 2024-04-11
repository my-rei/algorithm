import java.io.*;
import java.util.*;

public class Main {
	static boolean find;
	static int N, M;
	static char[][] board;
	static int[] dr = {0,1,0,-1}, dc = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		for(int i = 0;i<N;i++)
			board[i] = br.readLine().toCharArray();
		dfs(0, board);
		bw.write(find? "1":"0");
		bw.flush();
	}
	
	static void dfs(int count, char[][] map) {
		if(find || count == 10) return;
		int rr=0,rc=0,br=0,bc=0;
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<M;j++) {
				if(map[i][j] == 'R') {
					rr = i; rc = j;
				} else if(map[i][j] == 'B') {
					br=i;bc=j;
				}
			}
		}
		for(int d = 0;d<4;d++) {
			char[][] newMap = copy(map);
			if(notFail(newMap, d, rr, rc, br, bc)) {
				//System.out.println("======== dir: "+d+" =======");
				//p(newMap);
				dfs(count+1, newMap);
			}
		}
	}
	
	static char[][] copy(char[][] map){
		char[][] res = new char[N][M];
		for(int i = 0;i<N;i++) {
			res[i] = Arrays.copyOf(map[i], M);
		}
		return res;
	}
	static void p(char[][] map) {
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<M;j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	
	static boolean notFail(char[][] map, int dir, int rr, int rc, int br, int bc) {
		map[rr][rc] = '.';
		while(true) {
			int nr = rr + dr[dir], nc = rc+dc[dir];
			if(map[nr][nc] == 'O') {
				rr = nr; rc = nc; break;
			}
			if(map[nr][nc] != '.') break;
			rr = nr; rc = nc;
		}
		map[rr][rc] = 'R';
		
		map[br][bc] = '.';
		while(true) {
			int nr = br + dr[dir], nc = bc+dc[dir];
//			System.out.println("b "+nr+" "+nc);
			if(board[nr][nc] == 'O') return false;
			if(map[nr][nc] != '.') break;
			br = nr; bc = nc;
		}
		map[br][bc] = 'B';
		
		map[rr][rc] = '.';
		int nr = rr, nc = rc;
		while(true) {
			if(board[nr][nc] == 'O') {
				find = true;
				return true;
			}
			if(map[nr][nc] != '.') break;
			rr = nr; rc = nc;
			nr += dr[dir]; nc += dc[dir];
		}
		map[rr][rc] = 'R';
		
		
		return true;
	}

	
	
}