import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		Set<Integer> set = new HashSet<>();
		for(int i = 0;i<N;i++) {
			String[] str = br.readLine().split(" ");
			boolean flg = false; int cnt = 0, mcnt = 0;
			for(int j = 0;j<M;j++) {
				if(str[j].equals("*")) {
					flg = false; cnt = 0;
				} else {
					if(!flg) flg = true;
					cnt++;
					mcnt = Math.max(mcnt, cnt);
				}
			}
			set.add(mcnt);
			sb.append(mcnt+" "+str[M]+"\n");
		}
		
		
		bw.write(set.size()+"\n"+sb.toString());
		bw.flush(); 
	}
	
}