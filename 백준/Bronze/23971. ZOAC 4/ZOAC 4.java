import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken()), W = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken()), M =Integer.parseInt(st.nextToken());
		int oneHeight = N+1, oneWidth = M+1;
		int cntH = H%(N+1) > 0? H/(N+1)+1:H/(N+1), cntW =W/(M+1) + (W%(M+1) > 0? 1:0);
		bw.write(String.valueOf(cntH*cntW));
		bw.flush();
	}
}