import java.io.*;
import java.util.*;


public class Main {
	static int curMin, N, res;
	static int mp, mf, ms, mv;
	static int[][] nut;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		nut = new int[N][5];
		
		st = new StringTokenizer(br.readLine());
		mp = Integer.parseInt(st.nextToken());
		mf = Integer.parseInt(st.nextToken());
		ms = Integer.parseInt(st.nextToken());
		mv = Integer.parseInt(st.nextToken());
		
		
		
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<5;j++) {
				nut[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		curMin = Integer.MAX_VALUE;
		dfs(0, 0, 0, 0, 0, 0, 0);
		if(curMin == Integer.MAX_VALUE) {
			sb.append("-1");
		} else {
			sb.append(curMin+"\n");
//			System.out.println(Integer.toBinaryString(res));
			for(int i = 0;i<N;i++) {
				int r = (res & (1<<(N-i-1)))>>(N-i-1);
//				System.out.println("r="+r);
				if(r == 1)
					sb.append((i+1)+" ");
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void dfs(int cnt, int cp, int cf, int cs, int cv, int cPrice, int selected) {
		
		if(cnt == N || (cp>=mp && cf>=mf && cs>=ms && cv>=mv)) {
			if(cp>=mp && cf>=mf && cs>=ms && cv>=mv && curMin > cPrice) {
//				System.out.println("cur = "+Integer.toBinaryString(selected)+" price="+cPrice+" cnt="+cnt);
				curMin = cPrice;
				res = selected << (N-cnt);
			}
			return;
		}
		
		if(cPrice>curMin) {
			return;
		}
		
		// 현재 상태 선택O
		dfs(cnt+1, cp+nut[cnt][0], cf+nut[cnt][1], cs+nut[cnt][2], cv+nut[cnt][3], cPrice+nut[cnt][4], (selected<<1)+1);
				
		// 선택X
		dfs(cnt+1, cp, cf, cs, cv, cPrice, selected<<1);
		
		
		
	}
	
	
}