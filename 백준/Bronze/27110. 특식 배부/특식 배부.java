import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int sum = 0;
		
		for(int i = 0; i < 3; i++) {
			int val = Integer.parseInt(st.nextToken());
			
			if(val < N) {
				sum += val;
			} else {
				sum += N;
			}
		}
			
		System.out.println(sum);
	}
}