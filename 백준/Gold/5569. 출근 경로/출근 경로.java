import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int[][][] dp = new int[W][H][4];
		
		dp[0][1][1] = 1;
		dp[1][0][3] = 1;
		
		for(int j = 2 ; j<H ; j++) {
			for(int i = 0, nj = j; i<W && nj>-1 ; i++, nj--) {
//				System.out.println(i+" "+nj);
				if(nj > 0) {
					dp[i][nj][0] = dp[i][nj-1][3];
					dp[i][nj][1] = (dp[i][nj-1][0]+dp[i][nj-1][1])%100000;
				}
				if(i > 0) {
					dp[i][nj][2] = dp[i-1][nj][1];
					dp[i][nj][3] = (dp[i-1][nj][2]+dp[i-1][nj][3])%100000;					
				}
//				System.out.println(String.format("dp[%d][%d] = %s", i, nj, Arrays.toString(dp[i][nj])));
			}
			
		}
		
		
		for(int i = 1;i<W;i++) {
			for(int ni = i, j = H-1; ni<W && j>-1; ni++, j--) {
//				System.out.println(ni+" "+j);
				if(j > 0) {
					dp[ni][j][0] = dp[ni][j-1][3];
					dp[ni][j][1] = (dp[ni][j-1][0]+dp[ni][j-1][1])%100000;
				}
				if(ni > 0) {
					dp[ni][j][2] = dp[ni-1][j][1];
					dp[ni][j][3] = (dp[ni-1][j][2]+dp[ni-1][j][3])%100000;					
				}
//				System.out.println(String.format("dp[%d][%d] = %s", ni, j, Arrays.toString(dp[ni][j])));
			}
		}
		
		
		bw.write(String.valueOf((dp[W-1][H-1][0]+dp[W-1][H-1][1]+dp[W-1][H-1][2]+dp[W-1][H-1][3])%100000));
		bw.flush();
	}

}