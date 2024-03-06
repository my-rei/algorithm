import java.io.*;
import java.util.*;

public class Main {
	static class Num {
		String str;
		int sum, length;
		public Num(String str) {
			this.str = str;
			this.length = str.length();
			this.sum = -1;
		}
		public int getSum() {
			if(sum != -1) return sum;
			int s = 0;
			for(int i = 0;i<length;i++) {
				if(this.str.charAt(i) >= '0' && this.str.charAt(i) <= '9') {
					s += this.str.charAt(i) - '0';
				}
			}
			return s;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Num> nq = new PriorityQueue<>(new Comparator<Num>() {
			@Override
			public int compare(Num o1, Num o2) {
				if(o1.length != o2.length) return o1.length - o2.length;
				int s1 = o1.getSum(), s2 = o2.getSum();
				if(s1 != s2) return s1 - s2;
				return o1.str.compareTo(o2.str);
			}
		});
		for(int i = 0;i<N;i++) {
			nq.add(new Num(br.readLine()));
		}
		while(!nq.isEmpty()) {
			sb.append(nq.poll().str+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}