import java.io.*;

public class Main {
	static final int N=9;
	static boolean flag=false;
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
			int offsetR = (r/3)*3, offsetC = (c/3)*3;
			int ch = 0;
			for(int i = 0;i<N;i++) {
				ch |= 1 << puzzle[r][i]; 
				ch |= 1 << puzzle[i][c]; 
				ch |= 1 << puzzle[offsetR+i/3][offsetC+i%3]; 
			}
			
			for(int n = 1;n<=9;n++) {
				if((ch>>n & 1) == 0) {
					puzzle[r][c] = n;
					dfs(cor+1);
					puzzle[r][c] = 0;
				}
			}
		}
	}
}