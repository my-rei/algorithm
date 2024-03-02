import java.io.*;
import java.util.*;

public class Main {
	static int N, M, P, C, D, sCount, rr, rc;
	static int[] score, isSleep;
	static int[][] loc;
	static boolean[] isFail;
	static int[][] map;
	static Queue<Integer> goSanta;
	static int[] dr = {-1,0,1,0,-1,-1,1,1}, dc= {0,1,0,-1,1,-1,1,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		//입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		rr = Integer.parseInt(st.nextToken())-1;
		rc = Integer.parseInt(st.nextToken())-1;
		score = new int[P];
		loc = new int[P][2];
		isSleep = new int[P];
		isFail = new boolean[P];
		map = new int[N][N];
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<N;j++) {
				map[i][j] = -1;
			}
		}
		map[rr][rc] = -2;
		for(int s=0;s<P;s++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()) -1;
			loc[num][0] = Integer.parseInt(st.nextToken())-1;
			loc[num][1] = Integer.parseInt(st.nextToken())-1;
			map[loc[num][0]][loc[num][1]] = num;
		}
		
		sCount = P;
//		System.out.println("========"+M+"=========");
//		for(int i = 0;i<N;i++) {
//			for(int j = 0;j<N;j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
		while(M-->0) {
			int minDis=Integer.MAX_VALUE, minR=0, minC=0, minD = -1;
			for(int i = 0;i<P;i++) {
				if(isFail[i]) continue;
				int dis = getd(rr, rc, loc[i][0], loc[i][1]);
				if(dis < minDis) {
					minDis = dis;
					minR = loc[i][0]; minC = loc[i][1];
				} else if(dis==minDis && ((loc[i][0] > minR) || (loc[i][0]==minR && loc[i][1] > minC))) {
					minDis = dis;
					minR = loc[i][0]; minC = loc[i][1];
				}
			}
			minDis=Integer.MAX_VALUE;
			for(int d = 0;d<8;d++) {
				if(rr+dr[d]<0|| rc+dc[d]>=N||rr+dr[d]<0|| rc+dc[d]>=N) continue;
				int dis = getd(rr+dr[d], rc+dc[d], minR, minC);
				if(dis < minDis) {
					minD = d;
					minDis = dis;
				}
			}
			int ni = rr+dr[minD], nj = rc+dc[minD];
			if(map[ni][nj] != -1) {
				int sNum = map[ni][nj];
				
				score[sNum] += C;
				if(moveSanta(sNum, ni, nj, minD, C)) {
					isSleep[sNum] = 2;
				}
			} 
			map[rr][rc] = -1;
			map[ni][nj] = -2;
			rr = ni; rc = nj;
			
			
			//산타이동
			for(int s=0;s<P;s++) {
				if(isFail[s]) continue;
				if(isSleep[s] > 0) {isSleep[s]--; continue;}
				
				int rDis = getd(rr, rc, loc[s][0], loc[s][1]);
				int minSdis=Integer.MAX_VALUE, minSd=-1;
				for(int d = 0;d<4;d++) {
					int nr = loc[s][0]+dr[d], nc = loc[s][1]+dc[d], nd = getd(rr, rc, nr, nc);
					if(nr<0||nr>=N||nc<0||nc>=N||(map[nr][nc]>=0)) continue;
					if(nd < minSdis && nd < rDis) {
						minSd = d;
						minSdis = nd;
					}
				}
				
				if(minSd == -1) { continue; }
				int nr = loc[s][0]+dr[minSd], nc = loc[s][1]+dc[minSd];
				if(map[nr][nc] == -2) {
					score[s] += D;
					isSleep[s] = 1;
					moveSanta(s, loc[s][0], loc[s][1], (minSd+2)%4, D-1);
				} else {
					moveSanta(s, loc[s][0], loc[s][1], minSd, 1);
				}
			}
			
			for(int s=0;s<P;s++) {
				if(!isFail[s]) score[s]+=1;
			}
//			
//			System.out.println("========"+M+"=========");
//			for(int i = 0;i<N;i++) {
//				for(int j = 0;j<N;j++) {
//					System.out.print(map[i][j]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println(Arrays.toString(isFail));
//			System.out.println(Arrays.toString(isSleep));
//			System.out.println(Arrays.toString(score));
			
			if(sCount==0) break;
			
		}
		
		for(int i = 0;i<P;i++) {
			sb.append(score[i]+" ");
		}
		bw.write(sb.toString());
		bw.flush();
		
		
	}
	
	static int getd(int r1, int c1, int r2, int c2) {
		return (r1-r2)*(r1-r2)+(c1-c2)*(c1-c2);
	}
	
	static boolean moveSanta(int n, int i, int j, int d, int s) {
		map[i][j] = -1;
		int ni = i+(dr[d]*s), nj = j+(dc[d]*s);
		if(ni<0||ni>=N||nj<0||nj>=N) { //탈락
			isFail[n]=true;
			sCount--;
			return false;
		} 
		if(map[ni][nj] != -1) {
			moveSanta(map[ni][nj], ni, nj, d, 1);
		}
		map[ni][nj] = n;
		loc[n][0] = ni; loc[n][1] = nj;
		return true;
	}
}
