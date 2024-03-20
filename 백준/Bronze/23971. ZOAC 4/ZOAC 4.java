import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken()), W = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken())+1, M =Integer.parseInt(st.nextToken())+1;
		int cntH = H/N +(H%N == 0?0:1), cntW = W/M + (W%M==0?0:1);
		bw.write(String.valueOf(cntH*cntW));
		bw.flush();
	}
}