import java.io.*;
import java.util.Arrays;

public class Main {
	static final int N=9;
	static boolean flag;
	static int[] check;
	static int[][] puzzle;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
		puzzle = new int[N][N];
		for(int i = 0;i<N;i++) {
			String str = br.readLine();
			for(int j = 0;j<N;j++) {
				puzzle[i][j] = str.charAt(j) - '0';
			}
		}
		flag = false;
		dfs(0);
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void dfs(int cor) {
		if(flag) return;
		if(cor == 81) {
			flag = true;
			for(int i = 0;i<N;i++) {
				for(int j = 0;j<N;j++) {
					sb.append(puzzle[i][j]);
				}
				sb.append("\n");
			}
			return;
		}
		int r = cor/N, c = cor%N;
		if(puzzle[r][c] != 0) { dfs(cor+1); }
		else {
			boolean[] chk = new boolean[N+1];
			int offsetR = (r/3)*3, offsetC = (c/3)*3;
			for(int i = 0;i<N;i++) {
				chk[puzzle[r][i]] = true;
				chk[puzzle[i][c]] = true;
				chk[puzzle[offsetR+i/3][offsetC+i%3]] = true;
			}
			for(int n = 1;n<=9;n++) {
				if(!chk[n]) {
					puzzle[r][c] = n;
					dfs(cor+1);
					puzzle[r][c] = 0;
				}
			}
		}
	}
	
	
}