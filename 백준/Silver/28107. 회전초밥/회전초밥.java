import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<Integer, Queue<Integer>> qmap = new HashMap<>();
		int[] eat = new int[N];
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			while(K-->0) {
				int t = Integer.parseInt(st.nextToken())-1;
				if(!qmap.containsKey(t)) qmap.put(t, new ArrayDeque<Integer>());
				qmap.get(t).add(i);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		while(M-->0) {
			int C = Integer.parseInt(st.nextToken())-1;
			if(qmap.get(C) == null) continue;
			Integer P = qmap.get(C).poll();
			if(P != null) {
				eat[P]++;
			}
		}

		bw.write(Arrays.toString(eat).replaceAll("[\\[\\],]", ""));
		bw.flush();
	}

}