import java.io.*;
import java.util.*;

public class Solution {
	static int[][] goTime;
	static int[] stairSelect, endTime;
	static Stair aStair, bStair;
	static int N, pCount, minTime;
	static List<int[]> pList, asList, bsList;
	
	static class Stair{
		int r, c, L;
		public Stair(int r, int c, int l) {
			this.r = r;
			this.c = c;
			L = l;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		
		for (int test = 1; test <= T; test++) {
			N = Integer.parseInt(br.readLine());

			// 변수 초기화, 설정
			minTime = Integer.MAX_VALUE;
			aStair = null; bStair = null; pCount = 0;
			
			
			// 맵 입력받기 
			int val = 0;
			pList = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					val = Integer.parseInt(st.nextToken());
					if(val == 1) pList.add(new int[] {pCount++, i, j});
					else if(val > 1 && aStair == null) aStair = new Stair(i, j, val);
					else if(val > 1 && aStair != null) bStair = new Stair(i, j, val);
				}
			}
			goTime = new int[pCount][2]; //두 계단거리 모두
			endTime = new int[pCount];
			stairSelect = new int[pCount];
			// 조합
			updateTime();
			combi(0);
			sb.append("#"+test+" "+minTime+"\n");
		}
		bw.write(sb.toString());
		bw.flush();

	}
	
	static void combi(int cnt) {
		if(cnt == pCount) {
			minTime = Math.min(minTime, go());
			return;
		}
		
		stairSelect[cnt] = 0;
		combi(cnt+1);
		stairSelect[cnt] = 1;
		combi(cnt+1);
	}
	
	static void updateTime() {
		for(int i = 0;i<pCount;i++) {
			goTime[i][0] = getTime(pList.get(i)[1], pList.get(i)[2], aStair.r, aStair.c);
			goTime[i][1] = getTime(pList.get(i)[1], pList.get(i)[2], bStair.r, bStair.c);
		}
	}
	
	static int go() {
		int curTime = 0;
		//A, B에 각각 넣기
		asList = new ArrayList<>();
		bsList = new ArrayList<>();
		
		for(int i = 0;i<pCount;i++) {
			if(stairSelect[i] == 0) asList.add(new int[] {i, goTime[i][0]});
			else bsList.add(new int[] {i, goTime[i][1]});
		}
		
		// 정렬 
		asList.sort(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
		});
		
		bsList.sort(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
		});
		
		//이전사람끝나는시간, 내가가는시간 중 최댓값 
		for(int i = 0;i<asList.size();i++) {
			if(i < 3) { endTime[asList.get(i)[0]] = asList.get(i)[1]+aStair.L+1; }
			else {
				endTime[asList.get(i)[0]] = Math.max(goTime[asList.get(i)[0]][0]+aStair.L+1, endTime[asList.get(i-3)[0]]+aStair.L);
			}
		}

		for(int i = 0;i<bsList.size();i++) {
			if(i < 3) { endTime[bsList.get(i)[0]] = bsList.get(i)[1]+bStair.L+1; }
			else {
				endTime[bsList.get(i)[0]] = Math.max(goTime[bsList.get(i)[0]][1]+bStair.L+1, endTime[bsList.get(i-3)[0]]+bStair.L);
			}
		}
		
		for(int i = 0;i<pCount;i++) {
			curTime = Math.max(endTime[i], curTime);
		}
		
		return curTime;
	}
	
	static int getTime(int r1, int c1, int r2, int c2) {
		return Math.abs(r1-r2)+Math.abs(c1-c2);
	}
}