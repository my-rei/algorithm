import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		Stack<int[]> stack = new Stack<>();
		int score = 0;
		while(N-->0) {
			st = new StringTokenizer(br.readLine());
			if(st.nextToken().equals("1")) {
				int A = Integer.parseInt(st.nextToken()), T = Integer.parseInt(st.nextToken());
				if(T == 1) score += A;
				else stack.add(new int[] {A,T-1});
			} else {
				// 업무 주어지지 않음 
				if(!stack.isEmpty()) {
					if(stack.peek()[1] > 1) {
						stack.add(new int[] {stack.peek()[0], stack.pop()[1]-1});
					} else {
						score += stack.pop()[0];
					}
				}
			}
		}
		
		bw.write(String.valueOf(score));
		bw.flush();
	}
}