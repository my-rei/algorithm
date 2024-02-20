import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] count;
	static boolean[][] map;
	static int N, M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
				M = Integer.parseInt(st.nextToken());
		map = new boolean[N+1][N+1];
		count = new int[N+1][N+1];
		
		for(int i = 0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
			map[A][B] = true;
			map[B][A] = true;
			count[A][B] = 1;
			count[B][A] = 1;
		}
		
		for(int k = 1;k<N+1;k++) {
			for(int i = 1;i<N+1;i++) {
				for(int j = 1;j<N+1;j++) {
					if(i == j) continue;
					if(count[i][k] > 0 && count[j][k] > 0)
						count[i][j] =count[i][j]==0? count[i][k]+count[k][j]:Math.min(count[i][k]+count[k][j], count[i][j]);
				}
			}
		}
		
		int minNum = 0, minCnt = Integer.MAX_VALUE;
		for(int i = 1;i<N+1;i++){
			int cnt = 0;
			for(int j = 1;j<N+1;j++) {
				cnt += count[i][j];
			}
			if(cnt < minCnt) {
				minCnt = cnt;
				minNum = i;
			}
		}
		
		System.out.println(minNum);
		
	}
}
