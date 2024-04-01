import java.io.*;
import java.util.*;

public class Main {
	static int V, maxV=0; static long maxLength=0, maxL = 0;
	static List<int[]>[] list;
	static boolean[] vs;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		V = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		list = new List[V+1];
		vs = new boolean[V+1];
		for(int i = 0;i<V;i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()), t=0, w=0;
			list[n] = new ArrayList<>();
			while((t = Integer.parseInt(st.nextToken())) != -1) {
				list[n].add(new int[] {t, Integer.parseInt(st.nextToken())});
			}
		}
		
		vs[1] = true;
		dfs(1,0,0);
		vs[1] = false;
		vs[maxV] = true;
		dfs(maxV, 0, 0);
//		System.out.println(maxV);
		bw.write(String.valueOf(maxLength));
		bw.flush();
		
	}
	
	static void dfs(int now, long sum, int count) {
//		System.out.println(now+" "+sum+" "+count);
		maxLength = Math.max(maxLength, sum);
		if(sum > maxL) { maxL = sum; maxV = now; }
		
		for(int i = 0;i<list[now].size();i++) {
			if(!vs[list[now].get(i)[0]]) {
				vs[list[now].get(i)[0]] = true;
				dfs(list[now].get(i)[0], sum+list[now].get(i)[1], count+1);
				vs[list[now].get(i)[0]] = false;
			}
		}
		
	}
}