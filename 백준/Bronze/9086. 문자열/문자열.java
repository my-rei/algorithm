import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int i = Integer.parseInt(br.readLine());
		while(i-- > 0)	{
			String str = br.readLine();
			sb.append(""+str.charAt(0)+str.charAt(str.length()-1)+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}