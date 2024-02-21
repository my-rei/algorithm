import java.io.*;
import java.util.*;

public class Main {
	static boolean[] visited;
	static List<Integer>[] fList;
	static boolean flag;
	static int G = 5;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		
		fList = new List[N];
		visited = new boolean[N];
		flag = false;
		for(int i = 0;i<N;i++) fList[i] = new ArrayList<Integer>();
		
		for(int i = 0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			fList[a].add(b);
			fList[b].add(a);
		}
		
		for(int i = 0;i<N;i++) {
			visited[i] = true;
			dfs(1, i);
			visited[i] = false;
			if(flag) break;
		}
		
		System.out.println(flag? "1":"0");
		
	}
	
	static void dfs(int cur, int now) {
		if(cur == G) {
			flag = true;
			return;
		}
//		System.out.println("cur: "+cur+" now: "+now);
		
		if(!flag) {
			for(int i = 0;i<fList[now].size();i++) {
				if(!visited[fList[now].get(i)]) {
					visited[fList[now].get(i)] = true;
					dfs(cur+1, fList[now].get(i));
					visited[fList[now].get(i)] = false;
				}
			}
		}
	}
}
