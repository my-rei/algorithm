import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long[] classes = new long[N];
		st = new StringTokenizer(br.readLine());
		classes[0] = Integer.parseInt(st.nextToken());
		for(int i = 1;i<N;i++) 
			classes[i] = Integer.parseInt(st.nextToken()) + classes[i-1];
		Arrays.sort(classes);
		long sum = 0;
		for(int i = 0;i<K;i++)
			sum += classes[N-i-1];
		
		bw.write(String.valueOf(sum));
		bw.flush();
		
	}
}