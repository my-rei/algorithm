import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		while(N-->0) {
			String problem = br.readLine();
			if(problem.equals("P=NP")) {
				sb.append("skipped");
			} else {
				StringTokenizer st = new StringTokenizer(problem, "+");
				sb.append(Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken()));
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}