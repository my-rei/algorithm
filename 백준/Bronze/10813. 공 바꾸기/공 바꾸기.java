import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] basket = new int[N];
		for(int i = 0;i<N;i++)
			basket[i] = i+1;
		
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			swap(basket, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);
		}
		
		
		bw.write(Arrays.toString(basket).replaceAll("[\\[\\],]", ""));
		bw.flush();
	}
	
	static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}