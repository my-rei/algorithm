import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) return o1.compareTo(o2);
				return o1.length()-o2.length();
			}
		});
		
		while(N-->0) {
			pq.add(br.readLine());
		}
		
		String prev = "";
		while(!pq.isEmpty()) {
			if(prev.equals(pq.peek())) pq.poll();
			else { prev = pq.poll(); sb.append(prev+"\n"); }
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
}