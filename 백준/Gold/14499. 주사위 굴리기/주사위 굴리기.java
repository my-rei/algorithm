import java.io.*;
import java.util.*;

public class Main {
	static char[] dice;
	static char[][] map;
	static final int[] dr = {0,0,-1,1}, dc = {1,-1,0,0};
	static final int[][] direction = {{3,5,2,0}, {3,0,2,5}, {4,5,1,0}, {4,0,1,5}}; 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		dice = new char[6];
		Arrays.fill(dice, '0');
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<M;j++) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}
		
		st=new StringTokenizer(br.readLine());
		for(int k = 0;k<K;k++) {
			int order = Integer.parseInt(st.nextToken());
			int nx = x+dr[order-1], ny = y+dc[order-1];
			if(nx<0||nx>=N||ny<0||ny>=M) continue;
			
			move(direction[order-1]);
			if(map[nx][ny] == '0') {
				map[nx][ny] = dice[5];
			} else {
				dice[5] = map[nx][ny];
				map[nx][ny] = '0';
			}
			x = nx; y = ny;
			sb.append(dice[0]+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void move(int[] turn) {
		char tmp = dice[turn[0]];
		for(int i = 0;i<turn.length-1;i++) 
			dice[turn[i]] = dice[turn[i+1]];
		dice[turn[turn.length-1]] = tmp;
	}
}