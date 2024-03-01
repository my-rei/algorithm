import java.io.*;
import java.util.*;

public class Main {
	static int R, C, M, cMod, rMod, target, person, size;
	static boolean[] isDead;
	static Queue<Shark> queue;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0}, dc = {0,0,1,-1}, sharkSize, sharkTime;
	static class Shark {
		int num, r, c, s, d, z;
		public Shark(int num, int r, int c, int s, int d, int z) {
			this.num = num;
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		//변수초기화
		cMod = (C-1)*2;
		rMod = (R-1)*2;
		isDead = new boolean[M+1];
		queue = new ArrayDeque<>();
		map = new int[R][C];
		sharkSize = new int[M+1];
		sharkTime = new int[M+1];
		int count = 1;
		for(int i = 0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1, c = Integer.parseInt(st.nextToken())-1, s = Integer.parseInt(st.nextToken()), d =Integer.parseInt(st.nextToken())-1, z = Integer.parseInt(st.nextToken());
			queue.add(new Shark(count, r, c, s, d, z));
			sharkSize[count] = z;
			sharkTime[count] = -1;
			map[r][c] = count++;
		}
		
		person = -1; target = -1; size = 0;
		Shark shark = null;
		while (++person < C){
			target = -1;
			for(int i= 0;i<R;i++) {
				if(map[i][person] != 0) {
					target = map[i][person];
					map[i][person] = 0;
					isDead[target] = true;
					break;
				}
			}
			
			int s = queue.size();
			while(s-->0) {
				shark = queue.poll();
				if(target != -1 && target == shark.num) { size += shark.z; continue; }
				if(isDead[shark.num]) continue;
				if(map[shark.r][shark.c] == shark.num) map[shark.r][shark.c] = 0; //내자리일때만 
				int nr = shark.r, nc = shark.c, ns = shark.d<2? rMod:cMod;
				for(int t = 0;t<shark.s%ns;t++) {
					nr = shark.r+dr[shark.d]; nc = shark.c+dc[shark.d];
					if(nr<0||nr>=R||nc<0||nc>=C) { 
						shark.d = shark.d%2==0? shark.d+1:shark.d-1; 
						nr = shark.r+dr[shark.d]; nc = shark.c+dc[shark.d];
					}
					shark.r = nr;
					shark.c = nc;
				}
				
				if(map[shark.r][shark.c] == 0) {
					map[shark.r][shark.c] = shark.num; 
					queue.add(shark);
					sharkTime[shark.num] = person; //최종이동시간 저장 
				} else {
					int t = map[shark.r][shark.c];
					if(sharkTime[t] == person) {//이번에 이동한상어 
						if(shark.z > sharkSize[map[shark.r][shark.c]]) {
							isDead[map[shark.r][shark.c]]= true; 
							map[shark.r][shark.c] = shark.num; 
							queue.add(shark);
							sharkTime[shark.num] = person; 
						}
					} else { //이동 예정 상어 
						map[shark.r][shark.c] = shark.num; 
						queue.add(shark);
						sharkTime[shark.num] = person; 
					}
				}
			}
		}
		
		bw.write(String.valueOf(size));
		bw.flush();
		
	}
}