import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int count = 0;
		PriorityQueue<Long> pq = new PriorityQueue<>();
		
		String str = null, newStr = null;
		while(count < N) {
			if(st.hasMoreTokens()) {
				str = st.nextToken(); newStr = "";
				for(int i = str.length()-1;i>-1;i--) newStr += str.charAt(i); 
				pq.add(Long.parseLong(newStr));
				count++;
			} else {
				st = new StringTokenizer(br.readLine());
			}
		}
		
		while(!pq.isEmpty()) {
			sb.append(pq.poll()+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}