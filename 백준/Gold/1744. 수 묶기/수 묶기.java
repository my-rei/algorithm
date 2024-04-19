import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine()); 
		int[] nums = new int[N];
		int countZ = 0;
		for(int i = 0;i<N;i++) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) countZ ++;
			else nums[i] = n;
		}
		Arrays.sort(nums);
		
		long sum = 0; int i = N-1, j = 0;
		for(;i>0;i--) {
			if(nums[i] < 0) break;
			if(nums[i] > 1 && nums[i-1] > 1) {
				sum += nums[i] * nums[i-1];
				i --;
			} else 
				sum += nums[i];
		}
		for(;j<i;j+=2) 
			sum += nums[j] * nums[j+1];
		if(j == i) sum += countZ>0? 0:nums[j];
		
		bw.write(String.valueOf(sum));
		bw.flush();
	}
}