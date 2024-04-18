import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] price;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st= null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			N = Integer.parseInt(br.readLine());
			price = new int[N];
			st  = new StringTokenizer(br.readLine());
			for(int i = 0;i<N;i++)
				price[i] = Integer.parseInt(st.nextToken());
			
			int last = price[N-1], curCnt = 0, curSum = 0;
			long profit = 0;
			for(int i = N-2;i>-1;i--) {
//				System.out.println(i+" "+price[i]+" last="+last+" curCnt="+curCnt+" curSum="+curSum);
				if(price[i] >= last) {
					profit += Math.max(0, last*curCnt - curSum);
					last = price[i];
					curCnt = 0; curSum = 0;
				} else {
					curCnt++;
					curSum += price[i];
				}
			}
			profit += Math.max(0, last*curCnt - curSum);
//			System.out.println("==============================");
			sb.append(profit).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
	}

}