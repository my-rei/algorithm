import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N, M, MAX;
	static int[] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()); MAX = 0;
		tree = new int[N];
		for(int i = 0;i<N;i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			MAX = Math.max(MAX, tree[i]);
		}
		bw.write(String.valueOf(halfFind()));
		bw.flush();
	}
	
	static int halfFind() {
		int s = 0, e = MAX;
		while(s+1<e) {
			int mid = (s+e)/2;
//			System.out.println(s+" "+mid+" "+e+" "+countTree(mid));
			if(countTree(mid) < M) {
				e= mid;
			} else {
				s=mid;
			}
		}
		return s;
	}
	
	static long countTree(int n) {
		long cnt = 0;
		for(int i = 0;i<N;i++) {
			cnt += Math.max(0, tree[i]-n);
		}
//		System.out.println(n+ " cnt ="+cnt);
		return cnt;
	}
}