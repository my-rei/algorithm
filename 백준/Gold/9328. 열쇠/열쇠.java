import java.io.*;
import java.util.*;

public class Main {
	static int H, W, docu;
	static int[] key;
	static char[][] map;
	static Queue<int[]> queue, doorQueue;
	static boolean[][] vs;
	static int[] dr = {1,0,-1,0}, dc= {0,1,0,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			st  =new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken()); W = Integer.parseInt(st.nextToken());
			
			docu = 0;
			key = new int[26];
			map = new char[H][W];
			vs = new boolean[H][W];
			queue = new ArrayDeque<>();
			doorQueue = new ArrayDeque<>();
			for(int i=0;i<H;i++) {
				map[i] = br.readLine().toCharArray();
				for(int j = 0;j<W;j++) {
					if((i==0||i==H-1||j==0||j==W-1)&&(map[i][j] >= 'A' && map[i][j] <='Z')) {
						doorQueue.add(new int[] {i,j});
						continue;
					}
					if((i==0||i==H-1||j==0||j==W-1)&&(map[i][j]=='.'||map[i][j]=='$'||(map[i][j] >= 'a' && map[i][j] <='z'))) {
						if(map[i][j]=='$') {
//							System.out.println(i+ " "+j);
							docu++;
							map[i][j] = '.';
						}
						if(map[i][j] >= 'a' && map[i][j] <='z') {
							key[map[i][j]-'a']++;
						}
						queue.add(new int[] {i,j});
						vs[i][j] = true;
					}
				}
			}
			
			String k = br.readLine();
			if(!k.equals("0")) {
				for(char c:k.toCharArray()) {
					key[c-'a']++;
				}
			}
			
			bfs();
			if(T>0) sb.append(docu+"\n");
			else sb.append(docu);
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void bfs() {
		int ds = doorQueue.size();
		while(ds-->0) {
			int[] door = doorQueue.poll();
			if(map[door[0]][door[1]] != '.' && key[map[door[0]][door[1]]-'A'] > 0) {
				map[door[0]][door[1]] = '.';
				vs[door[0]][door[1]] = true;
				queue.add(new int[] {door[0], door[1]});
			} else {
				doorQueue.add(door);
			}
		}
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for(int d = 0;d<4;d++) {
				int nr = now[0]+dr[d], nc=now[1]+dc[d];
				if(nr<0||nr>=H||nc<0||nc>=W||vs[nr][nc]) continue;
				if(map[nr][nc]=='*') continue;
				if(map[nr][nc]>='A'&&map[nr][nc]<='Z') {
					doorQueue.add(new int[] {nr, nc});
					continue;
				}
				if(map[nr][nc]=='$') {
					docu++; map[nr][nc] = '.';
				} else if(map[nr][nc] >='a'&&map[nr][nc]<='z') {
					key[map[nr][nc]-'a']++; map[nr][nc] = '.';
				}
				vs[nr][nc] = true;
				queue.add(new int[] {nr, nc});
			}
			
			ds = doorQueue.size();
			while(ds-->0) {
				int[] door = doorQueue.poll();
				if(map[door[0]][door[1]] != '.' && key[map[door[0]][door[1]]-'A'] > 0) {
					map[door[0]][door[1]] = '.';
					vs[door[0]][door[1]] = true;
					queue.add(new int[] {door[0], door[1]});
				} else {
					doorQueue.add(door);
				}
			}
		}
	}
}