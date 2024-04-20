import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int bit = (1<<10)-1;
		for(int t = 1;t<=T;t++) {
			int N = Integer.parseInt(br.readLine());
			
			int cur = 0, num = 0;
			while(cur != bit) {
				num += N; 
				int tmp = num;
				while(tmp > 0) {
					cur |= 1 << (tmp % 10);
					tmp /= 10;
				}
			}
			sb.append("#").append(t).append(" ").append(num).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}