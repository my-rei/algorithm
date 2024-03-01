import java.io.*;
import java.util.*;

public class Main {
	static int N, M, ri, rj, bi, bj, oi, oj, minTry;
	static char[][] map;
	static int[] dr = {0,0,-1,1}, dc = {-1,1,0,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		
		for(int i = 0;i<N;i++) {
			String str = br.readLine();
			for(int j =0;j<M;j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'R') { ri = i; rj = j; map[i][j] ='.'; }
				else if(map[i][j] == 'B') { bi = i; bj = j; map[i][j] = '.';}
				else if(map[i][j] == 'O'){ oi = i; oj = j; }
			}
		}
		
		//모든 경우 탐색
		//각경우마다 이동하여 유효성 판단
		minTry = Integer.MAX_VALUE;
		dfs(0, new int[] {0, ri, rj, bi, bj});
		
		if(minTry == Integer.MAX_VALUE) minTry = -1;
		bw.write(String.valueOf(minTry));
		bw.flush();
	}
	
	static void dfs(int count, int[] cor) {
		// r, b 좌표로 위치 관리한다 
		if(count == 10)  return;
		if(count > minTry) return;
		
		// d 0왼쪽 1오른쪽 2위쪽 3오른쪽 
		for(int d = 0;d<4;d++) {
			int[] rs = move(d, cor);
			if(rs[0] == 0) {
				dfs(count+1, rs);
			} else if(rs[0] == 1) {
				minTry = Math.min(minTry, count+1);
                return;
			}
		}
	}
	
	static int[] move(int d, int[] cor) {
		// return -1:실패/움직이지않음 0:이동완료 1:종료 
		boolean flag = false, rStop = false, bStop = false, success = false;
		int crr = cor[1], crc = cor[2], cbr = cor[3], cbc = cor[4];
		while(!rStop || !bStop) {
			int nrr = crr + dr[d], nrc = crc+dc[d], nbr = cbr+dr[d], nbc = cbc+dc[d];
			if(map[nrr][nrc] == '#') {nrr = crr; nrc = crc; rStop = true;}
			if(map[nbr][nbc] == '#') {nbr = cbr; nbc = cbc; bStop = true;}
			if(!rStop) { //r 전진함
				if (nrr == nbr && nrc == nbc) {
					rStop = true;
				} else if (map[nrr][nrc] == '.') {
					crr = nrr; crc = nrc;
					flag = true;
				} else if(map[nrr][nrc] == 'O') {
					rStop = true;
					success = true;
				}
			}
			
			if(!bStop) { //b 전진함
				if (nrr == nbr && nrc == nbc && !success) {
					bStop = true;
				} else if (map[nbr][nbc] == '.') {
					cbr = nbr; cbc = nbc;
					flag = true;
				} else if(map[nbr][nbc] == 'O') {
					return new int[] {-1, nrr, nrc, nbr, nbc};
				}
			}
		}
		
		if(success) return new int[] {1, crr, crc, cbr, cbc};
		int resultcode = flag? 0:-1;
		return new int[] {resultcode, crr, crc, cbr, cbc};
	}
}