import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		bw.write(String.valueOf(Math.abs(Long.parseLong(st.nextToken())-Long.parseLong(st.nextToken()))));
		bw.flush();
	}
}