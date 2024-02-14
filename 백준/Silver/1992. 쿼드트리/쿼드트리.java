import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static char[][] map;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		for(int i = 0;i<N;i++)
			map[i] = br.readLine().toCharArray();
		
		
		sb = new StringBuilder();
		findTree(0,0,N);
		System.out.println(sb);	
	}
	
	static void findTree(int si, int sj, int width) {
		if(isSame(si, sj, si+width, sj+width)) {
			sb.append(map[si][sj]);
		} else {
			sb.append("(");
			findTree(si, sj, width/2);
			findTree(si, sj+width/2, width/2);
			findTree(si+width/2, sj, width/2);
			findTree(si+width/2, sj+width/2, width/2);
			sb.append(")");
		}
	}
	
	static boolean isSame(int si, int sj, int ei, int ej) {
		char t = map[si][sj];
		for(int i = si;i<ei;i++) {
			for(int j = sj;j<ej;j++) {
				if(map[i][j] != t) return false;
			}
		}
		return true;
	}
}
