import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] time = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0;i<N;i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(time);
		long res = time[0];
		for(int i = 1;i<N;i++) {
			time[i] = time[i-1]+time[i];
			res += time[i];
		}
		bw.write(String.valueOf(res));
		bw.flush();
	}
}