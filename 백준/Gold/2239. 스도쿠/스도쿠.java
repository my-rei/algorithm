import java.io.*;
import java.util.*;

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
		StringTokenizer st = null;
		
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
		if(puzzle[r][c] != 0) {
			dfs(cor+1); 
			return;
		}
		for(int n = 1;n<=9;n++) {
			if(isValid(r, c, n)) {
				puzzle[r][c] = n;
				dfs(cor+1);
				puzzle[r][c] = 0;
			}
		}
	}
	
	static boolean isValid(int r, int c, int n) {
		//일부 정합성만 판별 -> 중복만 거른다 
		//행 탐색
		for(int j = 0;j<N;j++) 
			if(puzzle[r][j] == n) return false;
		
		//열 탐색
		for(int i = 0;i<N;i++) 
			if(puzzle[i][c] == n) return false;

		//구역 탐색
		int offsetR = (r/3)*3, offsetC = (c/3)*3;
		for(int i = 0;i<3;i++) 
			for(int j = 0;j<3;j++) 
				if(puzzle[offsetR+i][offsetC+j] == n) return false;
		return true;
	}
	
}