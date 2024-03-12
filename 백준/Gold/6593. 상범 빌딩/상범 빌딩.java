import java.io.*;
import java.util.*;

public class Main {
	static int L, R, C, sl, sr, sc;
	static char[][][] map;
	static boolean[][][] vs;
	static Queue<int[]> queue;
	static int[] dl= {0,0,0,0,-1,1}, dr= {1,-1,0,0,0,0}, dc= {0,0,1,-1,0,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		while(!(L==0&&R==0&&C==0)) {
			map = new char[L][R][C];
			for(int i = 0;i<L;i++) {
				for(int j = 0;j<R;j++) {
					map[i][j] = br.readLine().toCharArray();
				}
				br.readLine();
			}
			
			int r = bfs();
			sb.append(r==-1?"Trapped!\n":"Escaped in "+r+" minute(s).\n");
			
			st = new StringTokenizer(br.readLine());
			
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
		}
		bw.write(sb.toString());
		bw.flush();
		
	}
	
	static int bfs() {
		//변수선언
		queue = new ArrayDeque<>();
		vs = new boolean[L][R][C];
		//출발점 찾기
		findS();
		vs[sl][sr][sc] = true;
		queue.add(new int[] {sl, sr, sc, 0});
		
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for(int d = 0;d<6;d++) {
				int cl=now[0]+dl[d], cr=now[1]+dr[d], cc=now[2]+dc[d], ct=now[3]+1;
				if(cl<0||cl>=L||cr<0||cc<0||cr>=R||cc>=C) continue;
				if(map[cl][cr][cc] == '#' || vs[cl][cr][cc]) continue;
				if(map[cl][cr][cc] == 'E') return ct;
				if(map[cl][cr][cc] == '.' && !vs[cl][cr][cc]) {
					vs[cl][cr][cc] = true;
					queue.add(new int[] {cl, cr, cc, ct});
				}
			}
		}
		return -1;
	}
	
	static void findS() {
		for(int i = 0;i<L;i++) 
			for(int j = 0;j<R;j++) 
				for(int k = 0;k<C;k++) 
					if(map[i][j][k] == 'S') {
						sl = i; sr=j; sc=k;
						return;
					}
	}
}