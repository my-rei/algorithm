import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st= null;
		
		int N = Integer.parseInt(br.readLine());
		int[] a = new int[N], b = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<N;i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<N;i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a); Arrays.sort(b);
		long res = 0;
		for(int i = 0;i<N;i++)
			res += a[i]*b[N-i-1];
		bw.write(String.valueOf(res));
		bw.flush();
		
	}
}