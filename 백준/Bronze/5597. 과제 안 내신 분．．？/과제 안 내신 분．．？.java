import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = 30;
		int[] stu = new int[N];
		for(int i = 0;i<N-2;i++) 
			stu[Integer.parseInt(br.readLine())-1]++;
		for(int i = 0;i<N;i++) 
			if(stu[i] == 0) sb.append((i+1)+"\n");
		
		bw.write(sb.toString());	
		bw.flush();
	}
}