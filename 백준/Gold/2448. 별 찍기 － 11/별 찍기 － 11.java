import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static char[][] starMap;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		starMap = new char[N+1][N*2+1];
		makeStar(0,0,N);
		for(int i = 0;i<=N;i++) {
			for(int j = 0;j<=N*2;j++) {
				if(starMap[i][j] == '*') sb.append(starMap[i][j]);
				else sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void makeStar(int si, int sj, int depth) {
		if(depth == 3) {
			//System.out.printf("si %d sj %d depth %d\n", si, sj, depth);
			//starMap[si][sj] = '*';
			starMap[si][sj+depth-1] = '*';
			starMap[si+1][sj+depth-2] = '*';
			starMap[si+1][sj+depth]='*';
			for(int i = depth-3;i<depth+2;i++) starMap[si+2][sj+i]='*';
		} else {
			makeStar(si, sj+depth/2, depth/2);
			makeStar(si+depth/2, sj, depth/2);
			makeStar(si+depth/2, sj+depth, depth/2);
		}
		
	}
}
