import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean[] vs;
	static boolean[][] fr;
	static Queue<Integer> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		fr = new boolean[N+1][N+1];
		vs = new boolean[N+1];
		q = new ArrayDeque<>();
		vs[1] = true;
		for(int i = 0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a= Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			fr[a][b] = true;
			fr[b][a] = true;
			if(a==1&&!vs[b]) {
				vs[b] = true;
				q.add(b);
			}
			if(b==1&&!vs[a]) {
				vs[a] = true;
				q.add(a);
			}
		}
		
		while(!q.isEmpty()) {
			int a = q.poll();
			for(int i = 1;i<=N;i++) {
				if(fr[a][i] && !vs[i]) {
					vs[i] = true;
				}
			}
		}
		
		int count = 0;
		for(int i = 2; i<=N;i++) {
			if(vs[i]) count++;
		}
		bw.write(String.valueOf(count));
		bw.flush();
	}
	
	
}