import java.io.*;
import java.util.*;


public class Main {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer>[] list = new List[10001];
		StringTokenizer st = null;
		int maxD = 0;
		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			if(list[D] == null) {
				list[D] = new ArrayList<>();
			}
			list[D].add(P);
			maxD = Math.max(maxD, D);
		}
		
		int cur = 0;
		long money = 0L; 
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((i1, i2) -> Integer.compare(i2, i1));
		for(int d = maxD; d>0; d--) {
			if(list[d] != null) {
				pq.addAll(list[d]);
			}
			if(!pq.isEmpty()) {
				money += pq.poll();
			}
		}
		
		System.out.println(money);
		
	}
	
}