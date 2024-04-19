import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringTokenizer st= new StringTokenizer(br.readLine());

		int N = Integer.parseInt(br.readLine()); 
		int[] nums = new int[N];
		int countZ = 0, countM = 0;
		for(int i = 0;i<N;i++) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) countZ ++;
			else nums[i] = n;
			if(nums[i] < 0) countM++;
		}
		Arrays.sort(nums);
		if(countZ > 0 && countM % 2 == 1) {
			for(int i = 0;i<N-1;i++) {
				if(nums[i+1] == 0) {
					nums[i] = 0;
					break;
				}
			}
		}
		
		long sum = 0; int i = N-1, j = 0;
		for(;i>0;i--) {
			if(nums[i] < 0) break;
			if(nums[i] > 1 && nums[i-1] > 1) {
				sum += nums[i] * nums[i-1];
				i --;
			} else 
				sum += nums[i];
		}
		for(;j<i;j++) {
			if (nums[j] < 0 && nums[j+1] < 0) {
				sum += nums[j] * nums[j+1];
				j++;
			} 
			else {
				sum += nums[j];
			}
		}
		if(j == i) sum += nums[j];
		
		
		bw.write(String.valueOf(sum));
		bw.flush();
	}
}