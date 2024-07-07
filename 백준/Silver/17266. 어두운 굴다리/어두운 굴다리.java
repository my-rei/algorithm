import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int last = Integer.parseInt(st.nextToken()), now = 0;
		int height = last;
		for(int i = 0;i<M-1;i++) {
			now = Integer.parseInt(st.nextToken());
			height = Math.max(height, (int)Math.ceil((now-last)/2.0));
			last = now;
		}
		height = Math.max(N-last, height);
		
		bw.write(String.valueOf(height));	
		bw.flush();
	}
}