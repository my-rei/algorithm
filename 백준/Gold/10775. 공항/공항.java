import java.io.*;
import java.util.*;

public class Main {
	static int[] parents;
	static int P, G;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		G = Integer.parseInt(br.readLine());
		P = Integer.parseInt(br.readLine());
		int c = 0;
		makeset();
		for(int i = 0;i<P;i++) {
			int num = Integer.parseInt(br.readLine());
			int target = find(num);
			if(target == 0) break;
			c++;
			union(target-1, target);
		}
		
		bw.write(String.valueOf(c));
		bw.flush();
	}
	static void makeset() {
		parents = new int[G+1];
		for(int i = 1;i<G+1;i++) parents[i] = i;
	}
	
	static int find(int a) {
		if(parents[a] == a) return a;
		else return parents[a] = find(parents[a]);
	}
	
	static void union(int a, int b) {
		int pa = find(a), pb = find(b);
		if(pa == pb) return;
		parents[pb] = pa;
	}
}