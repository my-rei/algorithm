import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static char[][] map;
	static int[] bPos;
	static int N, maxCnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		bPos = new int[2*N-1];
		for(int i = 0;i<2*N-1;i++)
			bPos[i] = -1;
		maxCnt = 0;
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<N;j++)
				map[i][j] = st.nextToken().charAt(0);
//			map[i] = br.readLine().replace(" ", "").toCharArray();
		}
		
		bishop(0,0,0,0);
		System.out.println(maxCnt);
	}
	
	static void bishop(int si, int sj, int cnt, int cur) {
		if(cur == 2*N-1) {
//			System.out.println(Arrays.toString(bPos)+ "  \t"+cnt);
			maxCnt = Math.max(maxCnt, cnt);
			return;
		}
		if(2*N-1 - cur < maxCnt - cnt) return;
		int ci= si, cj=sj, c = 0;
		
		int minR = Integer.MAX_VALUE;
		while(ci > -1&&ci<N&&cj>-1&&cj<N) {
			if(map[ci][cj] == '1') {
				if(canBishop(ci, cj, cur)) {
					minR = Math.min(minR, countGo(ci, cj));
				}
			}
			ci += 1;
			cj -= 1;
		}
		ci= si; cj=sj; c = 0;
		while(ci > -1&&ci<N&&cj>-1&&cj<N) {
			if(map[ci][cj] == '1') {
				if(canBishop(ci, cj, cur) && countGo(ci, cj) == minR) {
					bPos[cur] = c;
					if(sj+1<N) bishop(si, sj+1, cnt+1, cur+1);
					else bishop(si+1, sj, cnt+1, cur+1);
					bPos[cur] = -1;
				}
			}
			
			ci += 1;
			cj -= 1;
			c++;
		}
		
		if(sj+1<N) bishop(si, sj+1, cnt, cur+1);
		else bishop(si+1, sj, cnt, cur+1);
		
	}
	
	static int countGo(int ti, int tj) {
		int res = 0;
		int ci = ti, cj = tj;
		while(ci>-1&&ci<N&&cj>-1&&cj<N) {
			if(map[ci][cj] == '1')
				res++;
			ci ++;
			cj ++;
		}
		
		return res;
	}
	
	static boolean canBishop(int ti, int tj, int cnt) {
		for(int i = 0;i<cnt;i++) {
			if(bPos[i] == -1) continue;
			
			int ki = 0, kj = 0;
			if(i<N) kj = i;
			else { ki = i-N+1; kj = N-1;}
			ki += bPos[i];
			kj -= bPos[i];
			
//			if(bPos[0]==0&&bPos[1]==0&&bPos[2]==2&&bPos[3]==0&&bPos[4]==0&&bPos[5]==-1) {
//				System.out.println("kikj "+ki+" "+kj+"("+ti+","+tj+") "+i+" // "+(N-1)+" "+(i-N+1)+" "+bPos[i]);
//			}
			if(ki>-1&&ki<N&&kj>-1&&kj<N&&Math.abs(ti-ki)==Math.abs(tj-kj)) return false;
		}
		return true;
	}
	
	
}
