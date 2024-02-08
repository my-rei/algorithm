import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		sb= new StringBuilder();
		map = new int[N][N];
		for(int i = 0;i<N;i++) {
			char[] cs = br.readLine().toCharArray();
			for(int j = 0;j<N;j++) {
				map[i][j] = cs[j]-'0';
			}
		}
		
		comp(N, 0,0);
		System.out.println(sb);
	}
	
	static void comp(int width, int ci, int cj) {
		int f = map[ci][cj];
		
		if(width == 1) {
			sb.append(f);
			return;
		}
		
		int nextWidth = width / 2;
		boolean flg = false;
		for(int i = ci;i<ci+width;i++) {
			for(int j = cj;j<cj+width;j++) 
				if(!flg && f != map[i][j]) flg = true;
			if(flg) break;
		}
		
		if(flg) {
			sb.append("(");
			for(int i = ci;i<ci+width;i+=nextWidth)
				for(int j = cj;j<cj+width;j+=nextWidth)
					comp(nextWidth, i, j);
			sb.append(")");
		} else {
			sb.append(f);
		}
	}
}
