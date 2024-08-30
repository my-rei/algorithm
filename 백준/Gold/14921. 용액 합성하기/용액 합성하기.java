import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] potions = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0;i<N;i++) {
			potions[i] = Integer.parseInt(st.nextToken());
		}
		
		int minB = Integer.MAX_VALUE;
		int s = 0, e = N-1;
		while(s<e) {
			int t = potions[s] + potions[e];
//			System.out.println(String.format("%d(potions[%d])+%d(potions[%d])=%d", potions[s], s,potions[e],e,t));
			if(Math.abs(t) < Math.abs(minB)) minB = t;
			if(minB == 0) break;
			if(t>0) {
				e--;
			} else {
				s++;
			}
			
		}
		
		bw.write(String.valueOf(minB));
		bw.flush();
	}

}