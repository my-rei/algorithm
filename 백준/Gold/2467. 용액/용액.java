import java.io.*;
import java.util.*;

public class Main {
	static int N, l, r;
	static int[] nums;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<N;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		tp();
		sb.append(nums[l]+" "+nums[r]);
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void tp() {
		l = 0; r = N-1;
		int lp = 0; int rp = N-1; int sum = Integer.MAX_VALUE;
		while(lp < rp) {
			int newSum = nums[lp]+nums[rp];
			if(Math.abs(newSum) < sum) {
				sum = Math.abs(newSum);
				l = lp; r = rp;
			}
			if(newSum == 0) return;
			else if(newSum > 0) {
				rp--;
			} else if (newSum < 0) {
				lp++;
			}
		}
	}
}