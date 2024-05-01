import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, X;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken())-1;
		
		
		List<int[]>[] inlist = new List[N];
		List<int[]>[] outlist = new List[N];
		int[] inx = new int[N];
		int[] outx = new int[N];
		PriorityQueue<Integer> inpq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(inx[o1], inx[o2]);
			}
		});
		PriorityQueue<Integer> outpq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(outx[o1], outx[o2]);
			}
		});
		
		
		for(int i = 0;i<N;i++) {
			inlist[i] = new ArrayList<>();
			outlist[i] = new ArrayList<>();
		}
		for(int i = 0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int A=Integer.parseInt(st.nextToken())-1, B=Integer.parseInt(st.nextToken())-1, C=Integer.parseInt(st.nextToken());
			inlist[B].add(new int[] {A,C});
			outlist[A].add(new int[] {B,C});
			if(B==X) {
				inx[A] = C;
				inpq.add(A);
			} 
			else if(A==X) {
				outx[B] = C;
				outpq.add(B);
			}	
		}
        
		while(!inpq.isEmpty()) {
			int now = inpq.poll();
			for(int i = 0;i<inlist[now].size();i++) {
				int[] nxt = inlist[now].get(i);
				if(nxt[0] == X) continue;
				if(inx[nxt[0]] == 0 || nxt[1]+inx[now] < inx[nxt[0]]) {
					inx[nxt[0]] = nxt[1]+inx[now];
					inpq.add(nxt[0]);
				}
			}
		}
		
		while(!outpq.isEmpty()) {
			int now = outpq.poll();
			for(int i = 0;i<outlist[now].size();i++) {
				int[] nxt = outlist[now].get(i);
				if(nxt[0] == X) continue;
				if(outx[nxt[0]] == 0 || nxt[1]+outx[now] < outx[nxt[0]]) {
					outx[nxt[0]] = nxt[1]+outx[now];
					outpq.add(nxt[0]);
				}
			}
		}

		int max = 0;
		for(int i = 0;i<N;i++) {
			max = Math.max(inx[i]+outx[i], max);
		}
		bw.write(String.valueOf(max));
		bw.flush();
	}
}