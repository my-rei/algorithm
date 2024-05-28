import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i = 0;i<N;i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		
		int sum = 0;
		for(int i = 0;i<K;i++) 
			sum += arr[i];
		
		int maxSum = sum;
		for(int i = K;i<N;i++) {
			sum = sum - arr[i-K] + arr[i];
			maxSum = Math.max(sum, maxSum);
		}
		
		bw.write(String.valueOf(maxSum));
		bw.flush(); 
	}
	
}