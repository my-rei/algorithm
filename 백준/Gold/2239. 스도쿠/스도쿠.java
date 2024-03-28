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
		
		// 입력받는 부분
		for(int i = 0;i<N;i++) {
			String str = br.readLine();
			for(int j = 0;j<N;j++) {
				puzzle[i][j] = str.charAt(j) - '0';
			}
		}

		// 로직 실행 
		dfs(0);
		
		// 출력하는 부분
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void dfs(int cor) {
		if(flag) return;
		if(cor == 81) {
			for(int i = 0;i<N;i++) {
				for(int j = 0;j<N;j++) {
					sb.append(puzzle[i][j]);
				}
				sb.append("\n");
			}
			flag = true;
			return;
		}
		int r = cor/N, c = cor%N;
		if(puzzle[r][c] != 0) { dfs(cor+1); }
		else {
			int ch = 0;
			for(int i = 0;i<N;i++) {
				ch |= 1 << puzzle[r][i]; 
				ch |= 1 << puzzle[i][c]; 
				ch |= 1 << puzzle[(r/3)*3+i/3][(c/3)*3+i%3]; 
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