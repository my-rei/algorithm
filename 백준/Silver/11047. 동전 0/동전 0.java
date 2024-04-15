import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
		int[] ms = new int[N];
		for(int i = 0;i<N;i++) {
			ms[i] = Integer.parseInt(br.readLine());
		}
		
		int cnt = 0;
		for(int i = N-1;i>-1 && K > 0;i--) {
			if(K / ms[i] > 0) {
				cnt += K / ms[i];
				K %= ms[i];
			}
		}
		
		bw.write(String.valueOf(cnt));
		bw.flush();
	}
}