import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		Queue<Integer>[] list = new Queue[K+1];
		int[] seq = new int[K];
		for(int i = 0;i<K;i++) {
			int c = Integer.parseInt(st.nextToken());
			seq[i] = c;
			if(list[c] == null) list[c] = new ArrayDeque<>();
			list[c].add(i);
		}
		int cnt = 0;
		List<Integer> tab = new ArrayList<>();
		for(int i = 0;i<K;i++) {
			if(!tab.contains(seq[i])) {
				if(tab.size() < N) {
					tab.add(seq[i]);
				} else {
					int minV = -1, minI = 0;
					for(int j = 0;j<tab.size();j++) {
						int last = list[tab.get(j)] == null || list[tab.get(j)].isEmpty()? Integer.MAX_VALUE:list[tab.get(j)].peek();
						if(minV < last) {
							minV = last;
							minI = j;
						} 
					}
					tab.remove(minI);
					tab.add(seq[i]);
					cnt++;
				}
			}
			list[seq[i]].poll();
		}
		
		bw.write(String.valueOf(cnt));
		bw.flush();
		
	}
}