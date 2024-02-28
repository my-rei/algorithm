import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int[][] map, wormHole;
	static int[] dr = new int[] {-1,0,1,0}, dc = new int[] {0,1,0,-1};
	static int[][] turn = new int[][] {{2,3,1,0},{1,3,0,2},{3,2,0,1},{2,0,3,1},{2,3,0,1}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test = 1;test<=T;test++) {
			N = Integer.parseInt(br.readLine().trim());
			
			map = new int[N][N];
			wormHole = new int[5][5];
			
			//입력부
			for(int i = 0;i<N;i++) {
				st = new StringTokenizer(br.readLine().trim());
				for(int j = 0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] > 5) 
						if(wormHole[map[i][j]-6][0] == 0){
							wormHole[map[i][j]-6][0] = 1;
							wormHole[map[i][j]-6][1] = i;
							wormHole[map[i][j]-6][2] = j;
						} else {
							wormHole[map[i][j]-6][3] = i;
							wormHole[map[i][j]-6][4] = j;
						}
				}
			}
			
			//브루트포스
			int maxResult = 0;
			for(int i = 0;i<N;i++) {
				for(int j = 0;j<N;j++) {
					if(map[i][j] == 0) {
						for(int d = 0;d<4;d++) {
							maxResult = Math.max(simulation(i, j, d), maxResult);
						}
					}
				}
			}
			sb.append("#"+test+" "+maxResult+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static int simulation(int r, int c, int d) {
		int result = 0, dir = d, cr = r+dr[dir], cc = c+dc[dir];
//		System.out.println("======"+r+","+c+" "+d+"========");
//		System.out.println("("+cr+","+cc+") "+dir);
		while(cr != r || cc != c) {
//			if(cr != 3 || cc != 0&&cc!=4) System.out.println("("+cr+","+cc+") "+dir+" => "+(cr>-1&&cr<N&&cc>-1&&cc<N?map[cr][cc]:"X"));
			if(cr<0||cr>=N||cc<0||cc>=N) {
//				System.out.println("aa");
				result ++;
				dir = turn[4][dir]; //벽
				cr += dr[dir]; cc += dc[dir];
				continue;
			} 
			if(map[cr][cc] != 0) {
//				System.out.println("======"+r+","+c+" "+d+"========");
//				if(cr != 3 || cc != 0&&cc!=4) System.out.println("("+cr+","+cc+") "+dir+" => "+map[cr][cc]);
				if(map[cr][cc] == -1) { //블랙홀
//					System.out.println("blackHole");
					return result;
				} else if(map[cr][cc] < 6) {
					//블럭
//					if(cr != 3 || cc != 0&&cc!=4) System.out.println("block "+dir+"->"+turn[map[cr][cc]-1][dir]);
					dir = turn[map[cr][cc]-1][dir];
					result++;
				} else if(map[cr][cc] >= 6 && map[cr][cc] <= 10) {
					int[] wh = wormHole[map[cr][cc]-6];
					if(cr == wh[1] && cc == wh[2]) {
						cr = wh[3]; cc = wh[4];
					} else if(cr == wh[3] && cc == wh[4]) {
						cr = wh[1]; cc = wh[2];
					}
				}
			}
			cr += dr[dir]; cc+=dc[dir];
		}
		
		
		return result;
	}
}