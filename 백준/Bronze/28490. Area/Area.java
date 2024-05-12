import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine()), maxA = 0;
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			maxA = Math.max(maxA, Integer.parseInt(st.nextToken())*Integer.parseInt(st.nextToken()));
		}
		bw.write(String.valueOf(maxA));
		bw.flush();
	}
	
}