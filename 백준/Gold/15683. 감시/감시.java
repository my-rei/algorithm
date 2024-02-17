import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static char[][] map;
	static int N, M, cnt, cctvNum, minBlock;
	static CCTV[] cctvs;
	static boolean flag = false; // 추후 삭제 
	static class CCTV{
		int r;
		int c;
		int dir;
		int type;
		public CCTV(int r, int c, int dir, char t) {
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.type = t-'0';
		}
	}
	static int[] deltaR = new int[] {0,1,0,-1}, deltaC = new int[] {1,0,-1,0};

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		
		cctvNum = 0;
		minBlock = Integer.MAX_VALUE;
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<M;j++) {
				map[i][j] = st.nextToken().charAt(0);
				if(map[i][j]>'0'&&map[i][j]<'6') cctvNum++;
			}
		}
		cctvs = new CCTV[cctvNum];
		cctvNum = 0;
		for(int i = 0;i<N;i++) 
			for(int j = 0;j<M;j++) 
				if(map[i][j]>'0'&&map[i][j]<'6') 
					cctvs[cctvNum++] = new CCTV(i,j,-1, map[i][j]);
		Arrays.sort(cctvs, new Comparator<CCTV>() {
			@Override
			public int compare(CCTV o1, CCTV o2) {
				return o2.type - o1.type;
			}
		});
		camera(0,0);
		
		System.out.println(minBlock);
		
	}
	
	static void camera(int cnt, int cur) {
		if(cur == cctvNum) {
			minBlock = Math.min(minBlock, getBlocked());
			return;
		}
		boolean flg = false;
		
		for(int i = 0;i<4;i++) {
			if(!isIn(cctvs[cur].r, cctvs[cur].c, i, cctvs[cur].type, cur)) {
				cctvs[cur].dir = i;
				camera(cnt, cur+1);
				flg = true;
			}
			
			if(cctvs[cur].type == 5 && i == 0) break;
			if(cctvs[cur].type == 2 && i == 1) break;
		}
		if(!flg) camera(cnt, cur+1);
		
	}
	
	static int getBlocked() {
		int cnt = 0;
		int[] dirList;
		boolean[][] check = new boolean[N][M];
		for(int i = 0;i<cctvNum;i++) {
			if(cctvs[i].dir==-1) {
				continue;
			}
			
			dirList = cctvs[i].type == 1? new int[] {0}:
				cctvs[i].type == 2? new int[] {0, 2}:
					cctvs[i].type == 3? new int[] {0, 3}:
						cctvs[i].type == 4? new int[] {0, 2, 3}:
							new int[] {0, 1, 2, 3};
			for(int d : dirList) {
				int ci = cctvs[i].r, cj = cctvs[i].c;
				while(ci>-1&&ci<N&&cj>-1&&cj<M) {
					if(map[ci][cj]=='6') break;
					check[ci][cj] = true;
					ci += deltaR[(cctvs[i].dir+d)%4];
					cj += deltaC[(cctvs[i].dir+d)%4];
				}
			}
			
		}
		
		for(int i = 0;i<N;i++)
			for(int j = 0;j<M;j++)
				cnt += !check[i][j] && map[i][j] == '0'? 1:0; 
		return cnt;
	}
	
	static boolean isIn(int r, int c, int d, int t, int cnt) {
		for(int i = 0;i<cnt;i++) {
			if(cctvs[i].r==r) {
				if(cctvs[i].type == 5 && d%2 == 0 && t < 3) {
					for(int k =0;k<M;k++)
						if(map[r][k] == '6') return false;
					return true;
				}
//				if(cctvs[i].type == 4 && !(cctvs[i].dir == (d+3)%4)) return true;
//				if(cctvs[i].type == 3 && (cctvs[i].dir == d || cctvs[i].dir == (d+1)%4)) return true;
//				if(cctvs[i].type == 2 && cctvs[i].dir % 2 == d % 2) return true;
			}
			if(cctvs[i].c == c) {
				if(cctvs[i].type == 5 && d%2 == 1 && t < 3) {
					for(int k =0;k<N;k++)
						if(map[k][c] == '6') return false;
//					System.out.println(r+" "+c+" "+d);
					return true;
				}
//				if(cctvs[i].type == 5 && d%2 == 1) return true;
//				if(cctvs[i].type == 4 && !(cctvs[i].dir == (d+3)%4)) return true;
//				if(cctvs[i].type == 3 && (cctvs[i].dir == d || cctvs[i].dir == (d+1)%4)) return true;
//				if(cctvs[i].type == 2 && cctvs[i].dir % 2 == d % 2) return true;
			} 
			
		}
		return false;
	}
}
