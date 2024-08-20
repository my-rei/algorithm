import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double H1 = Integer.parseInt(st.nextToken()) * 30 
					+ Integer.parseInt(st.nextToken()) * 0.5 
					+ Integer.parseInt(st.nextToken()) * (0.5/60)
					+ Integer.parseInt(st.nextToken()) * (0.5/60/100);
			st = new StringTokenizer(br.readLine());
			double H2 = Integer.parseInt(st.nextToken()) * 30 
					+ Integer.parseInt(st.nextToken()) * 0.5 
					+ Integer.parseInt(st.nextToken()) * (0.5/60)
					+ Integer.parseInt(st.nextToken()) * (0.5/60/100);
			double D = Double.parseDouble(br.readLine());
			sb.append(String.format("%d. %.3f\n", i, (H2-H1)/360 * D * D * Math.PI));
		}

		bw.write(sb.toString());
		bw.flush();
	}

}