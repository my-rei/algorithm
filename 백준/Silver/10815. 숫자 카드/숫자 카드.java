import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Set<Integer> sets = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<N;i++) {
			sets.add(Integer.parseInt(st.nextToken()));
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<M;i++) {
			int t = Integer.parseInt(st.nextToken());
			sb.append(sets.contains(t)? "1":"0").append(" ");
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
	
}