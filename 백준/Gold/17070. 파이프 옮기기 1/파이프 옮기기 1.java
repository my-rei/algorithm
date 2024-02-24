import java.io.*;
import java.util.*;

public class Main {
	static char[][] map;
	static boolean[][] visited;
	static int[][] del = new int[][] {{0,1}, {1,0}, {1,1}};
	static int[][][] dir = new int[][][] {{{0,1}},{{1,0}}, {{0,1}, {1,0}, {1,1}}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		map = new char[N+1][N+1];
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<N;j++) {
				map[i][j] = st.nextToken().charAt(0);
			}
			map[i][N] = '1';
		}
		for(int j = 0;j<N+1;j++) map[N][j] = '1';
		
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {0,1,0});
		int count = 0;
		while(!queue.isEmpty()) {
			int curR = queue.peek()[0], curC = queue.peek()[1], curD = queue.peek()[2];
			//System.out.println("("+curR+","+curC+") ["+curD+"]");
			
			if(curR == N-1 && curC == N-1) {
				count++;
			}
			for(int i = 0;i<3;i++) {
				if(canMove(curR, curC, curD, i)) {
					queue.add(new int[] {curR+del[i][0], curC+del[i][1], i});
				}
			}
			queue.poll();
		}
		
		bw.write(String.valueOf(count));
		bw.flush();
	}
	
	static boolean canMove(int r, int c, int curd, int d) {
		if(curd == 0 && d == 1 || curd==1&&d==0) return false;
		for(int[] delta : dir[d]) {
			if(map[r+delta[0]][c+delta[1]] == '1') {
				//System.out.println(r+" "+c+" "+(r+delta[0])+" "+(c+delta[1]+" "+d));
				return false;
			}
		}
		return true;
	}
}