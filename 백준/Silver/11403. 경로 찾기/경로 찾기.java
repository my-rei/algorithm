import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		map = new boolean[N][N];
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<N;j++) {
				map[i][j] = st.nextToken().equals("1");
			}
		}
		
		for(int k = 0;k<N;k++) {
			for(int i = 0;i<N;i++) {
				if(k == i) continue;
				for(int j = 0;j<N;j++) {
					if(map[i][j]) continue;
					map[i][j] = (map[i][k]&&map[k][j])? true:map[i][j];
				}
			}
		}
		
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<N;j++) {
				sb.append(map[i][j]? "1 ":"0 ");
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		
	}
	
	
}