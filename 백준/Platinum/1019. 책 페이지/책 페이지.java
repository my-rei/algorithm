import java.io.*;
import java.util.*;

public class Main {
	static final int F = 10;
	static long offset=0;
	static int[] nums, offs;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		nums = new int[10]; offs = new int[10];
		getPage(Integer.parseInt(br.readLine()));
		getSum();
		bw.write(Arrays.toString(nums).replaceAll("[\\[,\\]]", ""));
		bw.flush();
	}
	
	static void getPage(int N) {
		if(N<10) {
			offs[N] += 1; offs[0]--;
			return;
		}
		String strN = String.valueOf(N);
		int v = strN.length(), now = 0, d = 0;
		
		while(--v > -1) {
			now = strN.charAt(v)-'0';
			d = strN.length()-v-1;
			
			
			nums[now] +=  (1+Long.parseLong(v==strN.length()-1? "0":strN.substring(v+1, strN.length())));
			if(now > 0)
				offs[now-1] += Math.pow(10,d);
			offs[0] -= Math.pow(10, d);
			offset += (long) Math.pow(10, d-1)*(now)*d;
		}
	}
	
	static void getSum() {
		for(int i = 0;i<10;i++) {
			nums[i] += offset;
		}
		for(int i = 0;i<10;i++) {
			for(int j = 0;j<=i;j++) {
				nums[j] += offs[i];
			}
		}
	}
}