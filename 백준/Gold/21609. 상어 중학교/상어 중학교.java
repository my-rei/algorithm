import java.io.*;
import java.util.*;
public class Main {
	static int N, M;
	static boolean[][] vs;
	static int[][] map;
	static int[] dr = {0,1,0,-1}, dc= {1,0,-1,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int score = 0, result = 0;
		while((score = findAndRemove()) != -1) {
			result += score;
			down();
			turn();
			down();
		}
		
		bw.write(String.valueOf(result));
		bw.flush();
	}
	
	static int findAndRemove() {
		int maxSize = 1, maxR = 0;
		Queue<int[]> maxQ = null, q = new ArrayDeque<>();
		vs = new boolean[N][N];

		for(int i = 0;i<N;i++) {
			for(int j = 0;j<N;j++) {
				if(vs[i][j]) continue;
				if(map[i][j] <= 0) continue;
				vs[i][j] = true;
				Queue<int[]> saveQ = new ArrayDeque<>();
				q.add(new int[] {i,j});
				
				int size = 1, rCount=0;
				while(!q.isEmpty()) {
					int[] now = q.poll();
					for(int d = 0;d<4;d++) {
						int nr = now[0]+dr[d], nc = now[1]+dc[d];
						if(nr<0||nr>=N||nc<0||nc>=N||vs[nr][nc]) continue;
						if(!(map[nr][nc] == map[i][j] || map[nr][nc] == 0)) continue;
						vs[nr][nc] = true;
						q.add(new int[] {nr,nc});
						saveQ.add(new int[] {nr, nc});
						size++;
						if(map[nr][nc] == 0) rCount++;
					}
				}
				if(size == 1) continue;
				saveQ.add(new int[] {i,j});
				if(maxSize < size || maxSize==size&&maxR <= rCount) {
					maxSize = size;
					maxQ = saveQ;
					maxR = rCount;
				}
				
				while(size-- > 0) {
					if(map[saveQ.peek()[0]][saveQ.peek()[1]] == 0)
						vs[saveQ.peek()[0]][saveQ.peek()[1]] = false;
					saveQ.add(saveQ.poll()); 	
				}
			}
		}
		
		if(maxSize == 1) {
			return -1;
		} else {
			while(!maxQ.isEmpty()) {
				int[] now = maxQ.poll();
				map[now[0]][now[1]] = Integer.MIN_VALUE;
			}
			return maxSize * maxSize;
		}
	}
	
	static void turn() {
		int[][] newMap = new int[N][N];
		for(int i = 0;i<N;i++) 
			for(int j = 0;j<N;j++) 
				newMap[N-j-1][i] = map[i][j];
		map = newMap;
	}
	static void down() {
		Queue<Integer> q = new ArrayDeque<>();
		for(int j = 0;j<N;j++) {
			for(int i=N-1;i>-1;i--) {
				if(map[i][j] == Integer.MIN_VALUE) continue;
				if(map[i][j] == -1) {
					for(int k = N-i-q.size()-1;k>0;k--) {
						q.add(Integer.MIN_VALUE);
					}
				}
				q.add(map[i][j]);
			}
			for(int i=N-1;i>-1;i--) {
				if(q.isEmpty()) 
					map[i][j] = Integer.MIN_VALUE;
				else 
					map[i][j] = q.poll();	
			}
		}
	}
}