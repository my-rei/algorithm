import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] sensors = new int[N];
		
		for(int i = 0;i<N;i++) {
			sensors[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(sensors);
		
		int[] interval = new int[N-1];
		for(int i = 0;i<N-1;i++) {
			interval[i] = sensors[i+1] - sensors[i];
		}
		Arrays.sort(interval);
		int res = 0;
		for(int i = 0;i<N-K;i++) {
			res += interval[i];
		}
		

		bw.write(String.valueOf(res));
		bw.flush();
	}

}