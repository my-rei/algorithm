import java.io.*;
import java.util.*;

public class Main {
	static int[] ABC;
	static boolean[] cs;
	static boolean[][] ac;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		ABC = new int[3];
		ABC[0] = Integer.parseInt(st.nextToken()); ABC[1] = Integer.parseInt(st.nextToken()); ABC[2] = Integer.parseInt(st.nextToken());
		ac = new boolean[201][201];
		cs = new boolean[ABC[2]+1];
		
		dfs(new int[] {0,0,ABC[2]});
//		System.out.println(Arrays.toString(cs));
		for(int i = 0;i<ABC[2]+1;i++) {
			if(cs[i]) sb.append(i+" ");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void dfs(int[] bottle) {
		if(bottle[0] == 0) {
			cs[bottle[2]] = true;
		}
		if(ac[bottle[0]][bottle[2]]) return;
		ac[bottle[0]][bottle[2]] = true;
//		System.out.println(Arrays.toString(bottle) +" "+ac[bottle[0]][bottle[2]]);
		
		for(int i = 0;i<3;i++) {
			if(bottle[i] > 0) {
				int j = (i+1)%3, k = (i+2)%3;
				if(bottle[j] < ABC[j]) {
					if(bottle[i]+bottle[j] < ABC[j]) {
						int[] tmp = new int[3];
						tmp[i] = 0; tmp[j] = bottle[i]+bottle[j]; tmp[k] = bottle[k];
//						ac[tmp[0]][tmp[2]] = true;
//						System.out.println(Arrays.toString(tmp)+" a="+(i==0?tmp[i]:i==1?tmp[j]:tmp[k])+" c="+(i==0?tmp[k]:i==1?tmp[i]:tmp[j]));
						dfs(tmp);
//						ac[tmp[0]][tmp[2]] = false;
//						ac[i==0?tmp[i]:i==1?tmp[j]:tmp[k]][i==0?tmp[k]:i==1?tmp[i]:tmp[j]] = false;
					} else {
						int[] tmp = new int[3];
						tmp[i] = bottle[i] - ABC[j] + bottle[j]; tmp[j] = ABC[j]; tmp[k] = bottle[k];
//						ac[tmp[0]][tmp[2]] = true;
						dfs(tmp);
//						ac[tmp[0]][tmp[2]] = false;
//						ac[i==0?tmp[i]:i==1?tmp[j]:tmp[k]][i==0?tmp[k]:i==1?tmp[i]:tmp[j]] = false;
					}
				}
				if(bottle[k] < ABC[k]) {
					if(bottle[i]+bottle[k] < ABC[k]) {
						int[] tmp = new int[3];
						tmp[i] = 0; tmp[j] = bottle[j]; tmp[k] = bottle[i]+bottle[k];
//						ac[tmp[0]][tmp[2]] = true;
						dfs(tmp);
//						ac[tmp[0]][tmp[2]] = false;
//						ac[i==0?tmp[i]:i==1?tmp[j]:tmp[k]][i==0?tmp[k]:i==1?tmp[i]:tmp[j]] = false;
					} else {
						int[] tmp = new int[3];
						tmp[i] = bottle[i] - ABC[k] + bottle[k]; tmp[j] = bottle[j]; tmp[k] = ABC[k];
//						ac[tmp[0]][tmp[2]] = true;
						dfs(tmp);
//						ac[tmp[0]][tmp[2]] = false;
//						ac[i==0?tmp[i]:i==1?tmp[j]:tmp[k]][i==0?tmp[k]:i==1?tmp[i]:tmp[j]] = false;
					}
				}
			}
		}
	}

}