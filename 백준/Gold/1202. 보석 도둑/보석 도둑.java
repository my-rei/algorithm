import java.io.*;
import java.util.*;

public class Main {
	static int N, K;
	static boolean[] selected;
	static int[] bag;
	static Jw[] jList;
	static PriorityQueue<Jw> jq;
	static class Jw{
		int m, v;
		public Jw(int m, int v) {
			this.m = m;
			this.v = v;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		bag = new int[K];
		jList = new Jw[N];
		jq = new PriorityQueue<>(new Comparator<Jw>() {
			@Override
			public int compare(Jw o1, Jw o2) {
				return o2.v - o1.v;
			} 
		});
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			jList[i] = new Jw(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		for(int i = 0;i<K;i++) {
			bag[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(jList, new Comparator<Jw>() {
			@Override
			public int compare(Jw o1, Jw o2) {
				return o1.m-o2.m;
			}
		});
		Arrays.sort(bag);
		
		
		long value = 0;
		int jInd = 0;
		for(int i = 0;i<K;i++) {
			while(jInd < N && jList[jInd].m <= bag[i]) {
				jq.add(jList[jInd++]);
			}
			if(!jq.isEmpty()) value += jq.poll().v;
		}
		
		bw.write(String.valueOf(value));
		bw.flush();
		
		
	}
	
	private static int upperBound(int[] data, int target) {
	    int begin = 0;
	    int end = data.length;
	    
	    while(begin < end) {
	    	int mid = (begin + end) / 2;
	        
	        if(data[mid] >= target) {
	        	end = mid;
	        }
	        else {
	        	begin = mid + 1;
	        }
	    }
	    return end;
	}
}