import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int now = 0;
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashMap<Integer, Integer> lastSeat = new HashMap<>();
		HashMap<Integer, Integer> count = new HashMap<>();
		while(now++ < N) {
			int K = Integer.parseInt(st.nextToken());
			Integer seat = lastSeat.get(K);
//			System.out.println("K="+K+" now="+now+"  seat="+seat);
			if(seat != null) {
				count.put(K, Math.min(count.get(K), now-lastSeat.get(K)));
				lastSeat.put(K, now);
			} else {
				lastSeat.put(K, now);
				count.put(K, Integer.MAX_VALUE);
			}
		}
		
		int min = Integer.MAX_VALUE;
		for(int val:count.values()) {
			min = Math.min(val, min);
		}
		
//		System.out.println("max="+max);
		
		bw.write(String.valueOf(min==Integer.MAX_VALUE? N:min));
		bw.flush();
	}
}