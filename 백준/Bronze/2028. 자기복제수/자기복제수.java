import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			String N2 = String.valueOf(N*N);
			if(N2.substring(N2.length()-String.valueOf(N).length()).equals(String.valueOf(N))) 
				sb.append("YES\n");
			else
				sb.append("NO\n");		
		}
		

		bw.write(sb.toString());
		bw.flush();
	}

}