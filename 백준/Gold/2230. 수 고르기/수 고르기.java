import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[N];
		for(int i = 0;i<N;i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(nums);
		
		int s = 0, e = 0; long dif = Long.MAX_VALUE;
		while(e<N) {
			if(nums[e]-nums[s] == M) {
				dif = M;
				break;
			} else if (nums[e] - nums[s] > M) {
				dif = Math.min(dif, nums[e]-nums[s]);
				s++;
			} else {
				e++;
			}
		}
				
				
		bw.write(String.valueOf(dif));
		bw.flush();
	}
}