import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int X = Integer.parseInt(br.readLine()), N = Integer.parseInt(br.readLine());

		for(int i = 0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			X  -= Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
		}
		
		bw.write(X==0? "Yes":"No");
		bw.flush();
	}
}