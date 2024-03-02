import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] stu = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0;i<N;i++) 
			stu[i] = Integer.parseInt(st.nextToken());
		st =  new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
		long count=0;
		for(int i = 0;i<N;i++) {
			count += stu[i]<=B? 1: (stu[i]-B)%C == 0? (stu[i]-B)/C+1:(stu[i]-B)/C+2;
		}
		bw.write(String.valueOf(count));
		bw.flush();
	}
}