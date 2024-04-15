import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, S;
	static int[] nums, sums;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); S = Integer.parseInt(st.nextToken());
		nums = new int[N]; sums = new int[N+1];
		st = new StringTokenizer(br.readLine());
		nums[0] = Integer.parseInt(st.nextToken());
		for(int i=1;i<N;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			sums[i] = sums[i-1]+nums[i-1];
		}
		sums[N] = sums[N-1]+nums[N-1];
		int minL = Integer.MAX_VALUE, e = 0;
		for(int i = 0;i<N;i++) {
			while(e<N) {
				if(sums[e+1]-sums[i] >= S) {
					minL = Math.min(minL, e-i+1);
					break;
				}
				e++;
			}
		}
		bw.write(String.valueOf(minL==Integer.MAX_VALUE? 0:minL));
		bw.flush();
	}
	
}