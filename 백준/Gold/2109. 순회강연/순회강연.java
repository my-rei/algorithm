import java.io.*;
import java.util.*;


public class Main {
	static class Lecture {
		int d; int p;
		public Lecture(int d, int p) {
			this.d = d;
			this.p = p;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Lecture[] lecs = new Lecture[N];
		StringTokenizer st = null;
		int maxD = 0;
		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			lecs[i] = new Lecture(D, P);
			maxD = Math.max(maxD, D);
		}
		
		int cur = 0;
		long money = 0L; 
		Arrays.sort(lecs, (l1, l2) -> Integer.compare(l2.d, l1.d));
		PriorityQueue<Lecture> pq = new PriorityQueue<>((l1, l2) -> Integer.compare(l2.p, l1.p));
		for(int d = maxD; d > 0; d--) {
			for(;cur<N;cur++) {
				if(lecs[cur].d == d) {
//					System.out.println("add lect p= "+lecs[cur].p+" d="+lecs[cur].d);
					pq.add(lecs[cur]);
				} else {
					break;
				}
			}
//			cur--;
			if(!pq.isEmpty()) {		
//				System.out.println("lect p="+pq.peek().p+" d="+pq.peek().d);
				money += pq.poll().p;
			}
		}
		
		System.out.println(money);
		
	}
	
}