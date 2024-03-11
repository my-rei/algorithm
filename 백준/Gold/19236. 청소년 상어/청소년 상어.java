import java.io.*;
import java.util.*;

public class Main {
	static int N=4, S=20, maxCount;
	static int[][] originMap;
	static boolean[] isDead;
	static Fish[] fishList;
	static int[] dr = {-1,-1,0,1,1,1,0,-1}, dc= {0,-1,-1,-1,0,1,1,1};
	static class Fish {
		int n, dir, r, c;
		public Fish(int n, int dir) {
			this.n = n;
			this.dir = dir;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		originMap = new int[N][N];
		fishList = new Fish[S+1];
		isDead = new boolean[N*N+1];
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0;j<N;j++) {
				originMap[i][j] = Integer.parseInt(st.nextToken());
				fishList[originMap[i][j]] = new Fish(originMap[i][j], Integer.parseInt(st.nextToken())-1);
			}
		}
//		originMap[0][0] = S;
//		fishMove(originMap);
//		System.out.println("============");
//		for(int i = 0;i<N;i++) {
//			for(int j = 0;j<N;j++) {
//				System.out.print(originMap[i][j]+" ");
//			}
//			System.out.println();
//		}
		fishList[S] = fishList[originMap[0][0]];
		maxCount = originMap[0][0];
		originMap[0][0] = S;
		dfs(maxCount, originMap, fishList);
		bw.write(String.valueOf(maxCount));
		bw.flush();
	}
	
	static void dfs(int cnt, int[][] map, Fish[] fishes) {
//		System.out.println("====="+cnt+"=======");
//		for(int i = 0;i<N;i++) {
//			for(int j = 0;j<N;j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
		boolean flg = false;
		for(int step = 1;step<N;step++) {
			int[][] newMap = cloneMap(map);
			Fish[] fList = cloneFish(fishes);
			fishMove(newMap, fList);
//			System.out.println("-------"+cnt+"/"+step+"--------");
//			for(int i = 0;i<N;i++) {
//				for(int j = 0;j<N;j++) {
//					System.out.print(newMap[i][j]+" ");
//				}
//				System.out.println();
//			}
			if(sharkCanMove(step, newMap, fList)) {
				flg = true;
				Fish t = sharkMove(step, cnt, newMap, fList);
				int tmp = fList[S].dir;
				fList[S].dir = t.dir;
				
//				System.out.println("~~~~~~~"+t.n+"~~~~~~~");
				dfs(cnt+t.n, newMap, fList);
				fList[S].dir = tmp;
			}
		}
		if(!flg) {
//			System.out.println("  *   *     *");
			maxCount = Math.max(maxCount, cnt);
		}
	}
	static int[][] cloneMap(int[][] map){
		int[][] newMap = new int[N][N];
		for(int i = 0;i<N;i++) {
			newMap[i] = map[i].clone();
		}
		return newMap;
	}
	
	static Fish[] cloneFish(Fish[] fl){
		Fish[] ff = new Fish[S+1];
		for(int i = 0;i<S+1;i++) {
			if(fl[i] != null) {
				ff[i] = new Fish(fl[i].n, fl[i].dir);
			}
		}
		return ff;
	}
	
	static Fish sharkMove(int step, int count, int[][] map, Fish[] fList) {
		Fish shark = findFish(S, map, fList);
		int s = step, r = shark.r, c = shark.c;
		map[r][c] = 0;
		while(s-->0) {
			r+=dr[shark.dir];
			c+=dc[shark.dir];
		}
		
		Fish target = fList[map[r][c]];
		map[r][c] = S;
		return target;
	}
	
	static boolean sharkCanMove(int step, int[][] map, Fish[] fList) {
		Fish shark = findFish(S, map, fList);
		int s = step, r = shark.r, c = shark.c;
//		System.out.println("shark "+r+" "+c+" "+shark.dir);
		while(s-->0) {
			r+=dr[shark.dir];
			c+=dc[shark.dir];
			if(r<0||r>=N||c<0||c>=N)  return false;
		}
		if(map[r][c] == 0) {
			return false;
		}
		return true;
	}
	static void fishMove(int[][] map, Fish[] fList) {
		for(int k = 1;k<=N*N;k++) {
//			System.out.println("' ' ' ' ' ' "+k+" ' ' ' ' ' '");
//			for(int i = 0;i<N;i++) {
//				for(int j = 0;j<N;j++) {
//					System.out.print(map[i][j]+" ");
//				}
//				System.out.println();
//			}
			Fish fish = findFish(k, map, fList);
			if(fish == null || isDead[k]) {
				continue;
			}
			
			//이동전검사
			//물고기는 swap빈칸 이동
			//상어바깥은 회전 
			int nr = fish.r+dr[fish.dir], nc = fish.c+dc[fish.dir], nd = fish.dir;
			if(nr>-1&&nr<N&&nc>-1&&nc<N) {
				if(map[nr][nc] == 0 || map[nr][nc] != S) {
					swap(map, fish.r, fish.c, nr, nc);
					continue;
				}
			}
			while((nd=++nd%8) != fish.dir) {
				nr = fish.r+dr[nd]; nc = fish.c+dc[nd];
				if(nr>-1&&nr<N&&nc>-1&&nc<N) {
					if(map[nr][nc] == 0 || map[nr][nc] != S) {
						fList[fish.n].dir = nd; 
						swap(map, fish.r, fish.c, nr, nc);
						break;
					}
				}
			}
		}
	}
	
	static Fish findFish(int i, int[][] map, Fish[] fList) {
		//i번 fish의 위치를 찾는다
		Fish fish = fList[i];
		for(int m=0;m<N;m++) {
			for(int n=0;n<N;n++) {
				if(map[m][n] == i) {
					fish.r = m;
					fish.c = n;
					return fish;
				}
			}
		}
		return null;
	}
	
	static void swap(int[][] map, int r1, int c1, int r2, int c2) {
		int tmp = map[r1][c1];
		map[r1][c1] = map[r2][c2];
		map[r2][c2] = tmp;
	}
	
	
}