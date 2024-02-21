import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Node{
		List<Integer> child= new ArrayList<>();
	}
	
	static Node[] nodes;
	static int[] parents;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		nodes = new Node[N+1];
		visited = new boolean[N+1];
		parents = new int[N+1];
		for(int i = 0;i<N+1;i++) nodes[i] = new Node();
		for(int i = 0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
			nodes[A].child.add(B);
			nodes[B].child.add(A);
		}
		
		dfs(0,1);
		for(int i = 2;i<N+1;i++) 
			sb.append(parents[i]+"\n");
		
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void dfs(int prev, int cur) {
		parents[cur] = prev;
		for(int i = 0;i<nodes[cur].child.size();i++) {
			if(!visited[nodes[cur].child.get(i)]) {
				visited[nodes[cur].child.get(i)] = true;
				dfs(cur, nodes[cur].child.get(i));
				visited[nodes[cur].child.get(i)] = false;
			}
		}
	}
}
