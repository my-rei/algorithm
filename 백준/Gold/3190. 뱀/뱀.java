import java.io.*;
import java.util.*;

public class Main {
	static int N, K, L;
	static Map<Integer, Character> turn;
	static Deque<int[]> sq;
	static char[][] map;
	static int[] dr= {0,1,0,-1}, dc = {1,0,-1,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for(int i = 0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 'A';
		}
		L = Integer.parseInt(br.readLine());
		turn = new HashMap<>();
		for(int i = 0;i<L;i++) {
			st = new StringTokenizer(br.readLine());
			turn.put(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
		}
		
		int time = 0, d = 0;
		sq = new ArrayDeque<>();
		sq.add(new int[] {0,0});
		map[0][0] = 'S';
		while(true) {
			time++;
			int nr = sq.peekFirst()[0]+dr[d], nc = sq.peekFirst()[1]+dc[d];
			if(nr<0||nr>=N||nc<0||nc>=N||map[nr][nc]=='S') break;
			if(map[nr][nc] != 'A') {
				map[sq.peekLast()[0]][sq.pollLast()[1]] = '.';
			}
			map[nr][nc] = 'S';
			
			if(turn.containsKey(time)) {
				d = turn.get(time) == 'L'? (d+3)%4:(d+1)%4;
			}
			
			sq.addFirst(new int[] {nr, nc});
		}
		
		bw.write(String.valueOf(time));
		bw.flush();
	}
}