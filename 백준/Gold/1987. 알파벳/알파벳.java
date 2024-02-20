import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static boolean[] aC;
	static char[][] map;
	static int[] deltaX = {1,0,-1,0}, deltaY = {0,1,0,-1};
	static int maxCnt, R, C;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		aC = new boolean[26];
		
		
		R = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for(int i = 0;i<R;i++)
			map[i] = br.readLine().toCharArray();
		
		maxCnt = 0;
		aC[map[0][0]-'A'] = true;
		dfs(0, 0, 1);
		System.out.println(maxCnt);
	}
	
	static void dfs(int r, int c, int cnt) {
		maxCnt = Math.max(maxCnt, cnt);
		for(int d= 0; d<4;d++) {
			int nr = r+deltaX[d], nc = c+deltaY[d];
			if(nr>-1&&nr<R&&nc>-1&&nc<C) {
				if(!aC[map[nr][nc] - 'A']){
					aC[map[nr][nc] - 'A'] = true;
					dfs(nr, nc, cnt+1);
					aC[map[nr][nc] - 'A'] = false;
				}
			}
		}
	}
}
