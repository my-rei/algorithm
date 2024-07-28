import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			
			if(n <= W || n <= H) {
                sb.append("DA\n");
			} else if(n <= Math.sqrt(Math.pow(W, 2) + Math.pow(H, 2))) {
				sb.append("DA\n");
			}else {
				sb.append("NE\n");
			}
		}
		System.out.println(sb.toString());
	}

}