import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int[] cCnt = new int[2];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());			
			for(int j = 0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int sDepth = (int) Math.round(Math.log(N)/Math.log(2));
		cut(sDepth, 0,0);
		
		System.out.println(cCnt[0]+"\n"+cCnt[1]);
	}
	
	static void cut(int depth, int curI, int curJ) {
		int t = map[curI][curJ];
		
		if(depth == 0) {
			cCnt[t]++;
			return;
		}
		boolean flg = false;
		int curWidth =(int) Math.pow(2, depth);
		int nextWidth = (int) Math.pow(2, depth-1);
		for(int i = curI;i<curI+curWidth;i++) {
			for(int j = curJ;j<curJ+curWidth;j++) 
				if(!flg && t != map[i][j]) flg = true;
			if (flg) break;
		}
		
		if(flg) {
			for(int i = curI;i<curI+curWidth;i+=nextWidth) {
				for(int j = curJ;j<curJ+curWidth;j+=nextWidth) 
					cut(depth-1, i,j);
			}
		} else 
			cCnt[t]++;
	}
}
