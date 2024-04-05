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
	static int[] v;
	static boolean[][] f;
	static Queue<Integer> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine()); int a, b;
		f = new boolean[N][N];
		v = new int[N];
		st = new StringTokenizer(br.readLine());
		while((a=Integer.parseInt(st.nextToken())) != -1) {
			b = Integer.parseInt(st.nextToken());
			f[a-1][b-1] = true;
			f[b-1][a-1] = true;
			st = new StringTokenizer(br.readLine());
		}

		Arrays.fill(v, -1);
		int count = 1, min = bfs(0); sb.append(1).append(" ");
		for(int i = 1;i<N;i++) {
			int tmp = bfs(i);
//			System.out.println("[level] "+ i+" "+tmp);
			if(tmp < min) {
				min = tmp;
				count = 1;
				sb = new StringBuilder();
				sb.append(i+1).append(" ");
			} else if(tmp == min) {
				count++;
				sb.append(i+1).append(" ");
			}
		}
		
		bw.append(String.valueOf(min)+" "+String.valueOf(count)+"\n").append(sb.toString());
		bw.flush();
		
	}
	
	static int bfs(int T) {
		q = new ArrayDeque<>();
		int count = 1, level = 1;
		v[T] = T;
		for(int i = 0;i<N;i++) {
			if(f[T][i]) {
				v[i] = T;
				q.add(i);
				count++;
			}
		}
//		System.out.println("-------------"+T+"------------");
//		System.out.println(Arrays.toString(v));
		while(!q.isEmpty()) {
			if(count == N) {
				return level;
			}
			int size = q.size();
			while(size-- > 0) {	
				int now = q.poll();
//				System.out.println(level+"======"+now);
				for(int i = 0;i<N;i++) {
					if(f[now][i] && v[i] != T) {
						v[i] = T;
						q.add(i);
						count++;
					}
				}
			}
//			System.out.println("level="+level+"  count="+count);
			level++;
		}
		
		return 0;
	}
}