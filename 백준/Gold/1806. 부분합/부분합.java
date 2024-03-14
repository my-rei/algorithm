import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()), S = Integer.parseInt(st.nextToken());
		int[] nums = new int[N];
		int[] sums = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<N;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			//sums[i+1] = sums[i] + nums[i];
		}
		
		int left = 0, right = 0, length = Integer.MAX_VALUE, tmp = nums[0];
		while(left <= right) {
			if(tmp >= S) {
				length = Math.min(length, right-left+1);
				tmp -= nums[left];
				left++;
			} else {
				if(right == N-1) {
					break;
				}
				right++;
				tmp += nums[right];	
			}
		}
		
		bw.write(String.valueOf(length==Integer.MAX_VALUE? 0:length));
		bw.flush();
	}
}