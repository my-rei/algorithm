import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String res = N%3%2 == 0? N/3%2==0? "CY":"SK": N/3%2==0? "SK":"CY";
		bw.write(res);
		bw.flush();
	}
}