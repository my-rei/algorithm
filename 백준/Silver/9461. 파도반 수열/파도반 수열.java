import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()), last = 3;
		long[] lines = new long[101];
		lines[0] = 0;
		lines[1] = 1;
		lines[2] = 1;
		
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			if(lines[N] == 0) {
				for(int i = last;i<=N;i++) 
					lines[i] = lines[i-2]+lines[i-3];
				last = N;
			}
			sb.append(lines[N]+"\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
}