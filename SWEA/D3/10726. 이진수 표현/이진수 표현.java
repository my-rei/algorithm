import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		int bit = (1<<10)-1;
		for(int t = 1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
			
			boolean flag = (M & ((1<<N) - 1)) == ((1<<N) - 1);
			
			
			sb.append("#").append(t).append(" ").append(flag? "ON":"OFF").append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}