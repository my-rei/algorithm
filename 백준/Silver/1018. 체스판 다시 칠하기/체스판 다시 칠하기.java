import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 1018 체스판 다시 칠하기
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		boolean[][] map = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) == 'B' ? true : false;
			}
		}
		
		// W의 경우
		boolean flag = false;
		int cnt = 0, minCnt = Integer.MAX_VALUE;
		for (int i = 0; i+8 <= N; i++) {
			for (int j = 0; j+8 <= M; j++) {
				cnt = 0;
				for(int r = i;r<i+8;r++) {
					for(int c = j;c<j+8;c++) {
						if(flag != map[r][c]) {
							cnt++;
						}
						flag = !flag;
					}
					flag = !flag;
				}
				minCnt = Math.min(minCnt, cnt);
				
				cnt = 0;
				flag = !flag;
				for(int r = i;r<i+8;r++) {
					for(int c = j;c<j+8;c++) {
						if(flag != map[r][c]) {
							cnt++;
						}
						flag = !flag;
					}
					flag = !flag;
				}
				minCnt = Math.min(minCnt, cnt);
			}
		
		}	
		
	
	System.out.println(minCnt);	

	}
}
