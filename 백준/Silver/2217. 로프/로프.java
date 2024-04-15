import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		int[] ropes = new int[N];
		for(int i = 0;i<N;i++) {
			ropes[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(ropes);
		
		long maxW = 0;
		for(int i = 0;i<N;i++) {
			maxW = Math.max(maxW, ropes[i]*(N-i));
		}

		bw.write(String.valueOf(maxW));
		bw.flush();
	}
}