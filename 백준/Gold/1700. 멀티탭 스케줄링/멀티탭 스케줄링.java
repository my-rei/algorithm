import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] count = new int[K+1];
		Queue<Integer>[] list = new Queue[K+1];
		int[] seq = new int[K];
		for(int i = 0;i<K;i++) {
			int c = Integer.parseInt(st.nextToken());
			seq[i] = c;
			count[c]++;
			if(list[c] == null) list[c] = new ArrayDeque<>();
			list[c].add(i);
		}
		int cnt = 0;
		List<Integer> tab = new ArrayList<>();
		for(int i = 0;i<K;i++) {
//			System.out.println("start "+tab.toString());
			if(!tab.contains(seq[i])) {
				if(tab.size() < N) {
					tab.add(seq[i]);
				} else {
					int minV = K, minI = 0, minC = 0;
					for(int j = 0;j<tab.size();j++) {
						if(minV > count[tab.get(j)]) {
							minV = count[tab.get(j)];
							minI = j;
							minC = 1;
						} else if(minV == count[tab.get(j)]) {
							minC++;
						}
					}
					
//					if(minC > 1 && minV > 0) {
						minV = -1;
						for(int j = 0;j<tab.size();j++) {
							int last = list[tab.get(j)] == null || list[tab.get(j)].isEmpty()? Integer.MAX_VALUE:list[tab.get(j)].peek();
							if(minV < last) {
								minV = last;
								minI = j;
							} 
						}
//					}
//					System.out.println("j="+minI);
					tab.remove(minI);
					tab.add(seq[i]);
					cnt++;
				}
			}
			count[seq[i]]--;
			list[seq[i]].poll();
//			System.out.println("end "+tab.toString());
		}
		
		bw.write(String.valueOf(cnt));
		bw.flush();
		
	}
}