import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] map, newMap;
	static Queue<int[]> queue;
	static int[] dr = {0,1,0,-1}, dc= {1,0,-1,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		queue = new ArrayDeque<>();
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > 0) queue.add(new int[] {i, j});
			}
		}
		
		bw.write(String.valueOf(bfs()));
		bw.flush();	
	}
	
	static int bfs() {
		int year = 1;
		Queue<int[]> checkq = new ArrayDeque<>();
		int count = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			newMap = new int[N][M];
			count = 0; //잔여빙하
			while(size-->0) {
				int[] now = queue.poll();
				int cnt = 0; //주변빙하개수 
				for(int d= 0;d<4;d++) {
					int nr=now[0]+dr[d], nc=now[1]+dc[d];
					if(nr<0||nr>=N||nc<0||nc>=M) continue;
					if(map[nr][nc] == 0) cnt++;
				}
				if(cnt == 0 || map[now[0]][now[1]] - cnt > 0) { //잔여빙하
					newMap[now[0]][now[1]] = map[now[0]][now[1]] - cnt; 
					count++; 
					queue.add(new int[] {now[0], now[1]});
					if(checkq.size() == 0) checkq.add(new int[] {now[0], now[1]});
					continue; 
				}
				
			}
			
			
			if(checkq.size() == 0) { // 모두 녹음
				return 0;
			}
			int newIceCnt = 0; //임의의 빙하에서 이어진 빙하의 개수 
			while(!checkq.isEmpty()) {
				int[] now = checkq.poll();
				for(int d= 0;d<4;d++) {
					int nr=now[0]+dr[d], nc=now[1]+dc[d];
					if(nr<0||nr>=N||nc<0||nc>=M) continue;
					if(newMap[nr][nc] == 0 || map[nr][nc] == 0) continue;
					newIceCnt++;
					map[nr][nc] = 0;
					checkq.add(new int[] {nr, nc});
				}
			}
			if(newIceCnt != count) {
				return year;
			}
			year++;
			map = newMap;	
		}
		return 0;
	}
}