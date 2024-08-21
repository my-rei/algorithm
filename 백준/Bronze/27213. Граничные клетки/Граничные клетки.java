import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long M = Long.parseLong(br.readLine());
		long N = Long.parseLong(br.readLine());
		bw.write(String.valueOf(M==1||N==1? M+N-1: (M+N)*2 - 4));
		bw.flush();
	}

}