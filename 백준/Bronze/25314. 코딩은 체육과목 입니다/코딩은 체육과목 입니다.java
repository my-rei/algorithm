import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int i = Integer.parseInt(br.readLine());
		while((i -= 4) > 0)	{
			sb.append("long ");
		}
		sb.append("long int");
		bw.write(sb.toString());
		bw.flush();
	}
}