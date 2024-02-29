import java.io.*;
import java.util.*;

public class Main {
	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	static Queue<int[]> nq, sq, tmpq, iq;
	static int[] dr = {-1,0,1,0}, dc = {0,1,0,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C];
		nq = new ArrayDeque<>(); sq = new ArrayDeque<>(); tmpq = new ArrayDeque<>(); iq = new ArrayDeque<>();
//		tmpnq = new ArrayDeque<>();
		int nr1 = -1, nc1 = -1, sr = -1, sc = -1;
		
		for(int i = 0;i<R;i++) {
			map[i] = br.readLine().toCharArray();
			for(int j = 0;j<C;j++) {
				if(map[i][j] == 'L') {
					if(nr1 == -1 && nc1 == -1) { nr1 = i; nc1 = j; nq.add(new int[] {i, j}); visited[i][j] = true; }
					else { sr = i; sc = j; sq.add(new int[] {i, j}); visited[i][j] = true; }
				} 
			}
		}
		
		for(int i = 0;i<R;i++) {
			for(int j = 0;j<C;j++) {
				if (map[i][j] == '.'){
					for(int d = 0;d<4;d++) {
						int ni = i+dr[d], nj=j+dc[d];
						if(ni>-1&&ni<R&&nj>-1&&nj<C&&map[ni][nj]=='X') {
							iq.add(new int[] {i,j});
							break;
						}
					}
				}
			}
		}
		
		
		
		
		
		bw.write(String.valueOf(find()));
		bw.flush();
		
		
	}
	
	static int find() {
		int count = 0;

		while(!nq.isEmpty() || !sq.isEmpty()) {
//			p("================count="+count+"===================", true);
			int is = iq.size();
			while(is-->0) {
				int[] now = iq.poll();
//				p("===iq===="+Arrays.toString(now), true);
				for(int d = 0;d<4;d++) {
					int nr = now[0]+dr[d], nc = now[1]+dc[d];
					if(nr>-1&&nr<R&&nc>-1&&nc<C&&(map[nr][nc] == 'X')) {
						map[nr][nc] = 'O';
						iq.add(new int[] {nr, nc});
					} 
				}
			}
			
			int ns = nq.size();
			while(ns-->0) {
				int[] now = nq.poll();
//				p("===nq===="+Arrays.toString(now), true);
				for(int d = 0;d<4;d++) {
					int nr = now[0]+dr[d], nc = now[1]+dc[d];
					if(nr>-1&&nr<R&&nc>-1&&nc<C&&(map[nr][nc] == 'X'||map[nr][nc] == 'O')) {
						map[nr][nc] = 'N';
//						tmpnq.add(new int[] {nr, nc});
						nq.add(new int[] {nr, nc});
					} else if(nr>-1&&nr<R&&nc>-1&&nc<C&&(map[nr][nc] == '.')&&!visited[nr][nc]) {
						//전진해서 이후.인부분 다 처리 
						visited[nr][nc] = true;
						tmpq.add(new int[] {nr, nc});
					} else if(nr>-1&&nr<R&&nc>-1&&nc<C&&map[nr][nc] == 'S') {
//						p("!!!!!!S!!!!!!", true);
						return count;
					}
				}
			}
			
//			System.out.println("======nq======");
//			System.out.println(nq.toString());
//			System.out.println("======tmpq======");
//			System.out.println(tmpq.toString());
			
			//. 전진 
			while(!tmpq.isEmpty()) {
				int[] now = tmpq.poll();
//				p("===1tmp===="+Arrays.toString(now), true);
				for(int d = 0;d<4;d++) {
					int nr = now[0]+dr[d], nc = now[1]+dc[d];
					if(nr>-1&&nr<R&&nc>-1&&nc<C&&(map[nr][nc] == 'X'||map[nr][nc]=='O')) {
						map[nr][nc] = 'N';
//						tmpnq.add(new int[] {nr, nc});
						nq.add(new int[] {nr, nc});
					} else if(nr>-1&&nr<R&&nc>-1&&nc<C&&(map[nr][nc] == '.')&&!visited[nr][nc]) {
						visited[nr][nc] = true;
						tmpq.add(new int[] {nr, nc});
					} else if(nr>-1&&nr<R&&nc>-1&&nc<C&&map[nr][nc] == 'S') {
//						p("!!!!!!S!!!!!!", true);
						return count;
					}
				}
			}
			
			int ss = sq.size();
			while(ss-- > 0) {
				int[] now = sq.poll();
//				p("===sq===="+Arrays.toString(now), true);
				for(int d = 0;d<4;d++) {
					int nr = now[0]+dr[d], nc = now[1]+dc[d];
					if(nr>-1&&nr<R&&nc>-1&&nc<C&&(map[nr][nc] == 'X'||map[nr][nc]=='O')) {
						map[nr][nc] = 'S';
						sq.add(new int[] {nr, nc});
					} else if(nr>-1&&nr<R&&nc>-1&&nc<C&&(map[nr][nc] == '.')&&!visited[nr][nc]) {
						visited[nr][nc] = true;
						tmpq.add(new int[] {nr, nc});
					} 
					else if(nr>-1&&nr<R&&nc>-1&&nc<C&&map[nr][nc] == 'N') {
//						p("!!!!!!N!!!!!!", true);
						return count+1;
					} 
//					else if(nr>-1&&nr<R&&nc>-1&&nc<C&&map[nr][nc] == 'M') {
////						p("!!!!!!N!!!!!!", true);
//						flag = true;
//						return count;
//					}
				}
			}
//			System.out.println("======sq======");
//			System.out.println(sq.toString());
//			System.out.println("======tmpq======");
//			System.out.println(tmpq.toString());
			
			while(!tmpq.isEmpty()) {
				int[] now = tmpq.poll();
//				p("===2tmp===="+Arrays.toString(now), true);
				for(int d = 0;d<4;d++) {
					int nr = now[0]+dr[d], nc = now[1]+dc[d];
					if(nr>-1&&nr<R&&nc>-1&&nc<C&&(map[nr][nc] == 'X'||map[nr][nc]=='O')) {
						map[nr][nc] = 'S';
						sq.add(new int[] {nr, nc});
					} else if(nr>-1&&nr<R&&nc>-1&&nc<C&&(map[nr][nc] == '.')&&!visited[nr][nc]) {
						visited[nr][nc] = true;
						tmpq.add(new int[] {nr, nc});
					} 
					else if(nr>-1&&nr<R&&nc>-1&&nc<C&&map[nr][nc] == 'N') {
//						p("!!!!!!N!!!!!!", true);
						return count+1;
					} 
//					else if(nr>-1&&nr<R&&nc>-1&&nc<C&&map[nr][nc] == 'M') {
////						p("!!!!!!N!!!!!!", true);
//						flag = true;
//						return count;
//					}
				}
			}
			
			is = iq.size();
			while(is-->0) {
				if(map[iq.peek()[0]][iq.peek()[1]] == 'O') map[iq.peek()[0]][iq.peek()[1]] = '.';
				iq.add(iq.poll());
			}
//			while(!tmpnq.isEmpty()) {
//				if(map[tmpnq.peek()[0]][tmpnq.peek()[1]] == 'M') map[tmpnq.peek()[0]][tmpnq.peek()[1]] = 'N';
//				tmpnq.poll();
//			}
//			for(int i = 0;i<R;i++) {
//				for(int j = 0;j<C;j++) {
//					p(map[i][j]+"", false);
//				}
//				System.out.println();
//			}
//			System.out.println();
			count++;
		}
		
		return count;
	}
	
//	static void p(String s, boolean t) {
//		if(t) System.out.println(s);
//		else System.out.print(s);
//	}
}