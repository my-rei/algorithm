import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int asum = 0, bsum = 0;
		for(int i =0;i<N;i++) asum += Integer.parseInt(st.nextToken());
		for(int i =0;i<N;i++) bsum += Integer.parseInt(st2.nextToken());
		System.out.println(bsum+" "+asum);
		
	}
}