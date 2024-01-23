
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int goodCnt = 0;
		for (int i = 0; i <n;i++) {
			char[] words = br.readLine().toCharArray();
			Stack<Character> st = new Stack<>();
			
			for(char w : words) {
				if (!st.isEmpty() && st.peek() == w) {
					st.pop();
					continue;
				}
				st.add(w);
			}
			
			if (st.size() == 0) {
				goodCnt++;
			}
		}
		
		System.out.println(goodCnt);
	}
}
