import java.io.*;
import java.util.*;

public class Main {
	static int[] stu, team;
	static int N, count;
	static boolean[] vs;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());
			count = 0;
			stu = new int[N];
			team = new int[N];
			vs = new boolean[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				stu[i] = Integer.parseInt(st.nextToken()) - 1;
				if(stu[i] == i) { team[i] = 1; count++; }
			}
			//1개짜리 처리 
			for (int i = 0; i < N; i++) {
				if (team[i] == 0) {
					dfs(i, i);
				}
			}
			sb.append((N - count) + "\n");
//			sb.append(Arrays.toString(team)+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}

	static void dfs(int cnt, int sIndex) {
//		System.out.println(cnt+" "+sIndex);
		if(stu[cnt] == sIndex) {
			//사이클 완성
			int now = stu[sIndex];
			count ++; team[sIndex] = 1;
			while(now != sIndex) {
				team[now] = 1;
				count ++;
				now = stu[now];
			}
			return;
		} 
		if (vs[stu[cnt]]) {
			// 중간 사이클
			int now = stu[cnt];
			count ++; team[cnt] = 1;
			while(now != cnt) {
				team[now] = 1;
				count ++;
				now = stu[now];
			}
			// 안되는 셀 지우기
			now = stu[sIndex];
			team[sIndex] = -1;
			while(team[now] == 0) {
				team[now] = -1;
				now = stu[now];
			}
			return;
		}
		if (team[stu[cnt]] != 0) {
			// 비적합 참조 
			int now = stu[sIndex];
			team[sIndex] = -1;
			while(team[now] == 0) {
				team[now] = -1;
				now = stu[now];
			}
			return;
		}
		
		vs[stu[cnt]] = true;
		dfs(stu[cnt], sIndex);
		vs[stu[cnt]] = false;
	}
}