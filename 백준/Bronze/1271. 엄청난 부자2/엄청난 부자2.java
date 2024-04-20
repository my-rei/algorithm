import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BigInteger N = new BigInteger(st.nextToken()), M = new BigInteger(st.nextToken()); 
		
		
		bw.write(String.valueOf(N.divide(M))+"\n"+String.valueOf(N.remainder(M)));
		bw.flush();
	}
}