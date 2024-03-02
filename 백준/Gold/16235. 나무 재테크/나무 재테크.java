import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K, SN = 5;
	static int[][] nut;
	static Land[][] map;
	static int[] dr = {-1,-1,-1,0,0,1,1,1}, dc = {-1,0,1,-1,1,-1,0,1};
	
	static class Land {
		int n;
		PriorityQueue<Integer> trees;
		Queue<Integer> newTrees;
		public Land(int n) {
			this.n = n;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		nut = new int[N][N];
		map = new Land[N][N];
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<N;j++) {
				nut[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = new Land(SN);
			}
		}
		
		for(int i = 0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int r= Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken()), z = Integer.parseInt(st.nextToken());
			if(map[r-1][c-1].trees == null) map[r-1][c-1].trees = new PriorityQueue<>();
			map[r-1][c-1].trees.add(z);
		}
		
		int tmps = 0, tmpn = 0, tree = 0;
		Land land = null;
		while (K-->0){
			for(int i = 0;i<N;i++) {
				for(int j =0;j<N;j++) {
					if(map[i][j].trees == null) continue;
					tmps = map[i][j].trees.size();
					tmpn = map[i][j].n;
					map[i][j].n = 0;
					while(tmps-->0) {
						tree = map[i][j].trees.poll();
						if(tmpn >= tree) {
							tmpn -= tree;
							if(map[i][j].newTrees == null) map[i][j].newTrees = new ArrayDeque<>();
							map[i][j].newTrees.add(tree+1);
							if((tree+1)%5 != 0)  continue;
							for(int d = 0;d<8;d++) {
								int ni = i+dr[d], nj = j+dc[d];
								if(ni>-1&&ni<N&&nj>-1&&nj<N) {
									if(map[ni][nj].newTrees == null) map[ni][nj].newTrees = new ArrayDeque<>();
									map[ni][nj].newTrees.add(1);
								}
							}	
						} else {
							
//							System.out.println("lack");
							map[i][j].n += tree/2;
						}
					}
					map[i][j].n += tmpn;
				}
			}
			for(int i = 0;i<N;i++) {
				for(int j =0;j<N;j++) {
					map[i][j].n += nut[i][j];
					if(map[i][j].newTrees == null || map[i][j].newTrees.size() == 0) continue;
					if(map[i][j].trees == null) map[i][j].trees = new PriorityQueue<>();
					while(!map[i][j].newTrees.isEmpty()) {
						map[i][j].trees.add(map[i][j].newTrees.poll());
					}
				}
			}
//			System.out.println("======"+K+"=======");
//			for(int i = 0;i<N;i++) {
//				for(int j =0;j<N;j++) {
//					System.out.print((map[i][j].trees==null?"n":map[i][j].trees.size())+" ");
//				}
//				System.out.println();
//			}
			
		}
		
		int count = 0;
		for(int i = 0;i<N;i++) {
			for(int j =0;j<N;j++) {
				count +=map[i][j].trees== null?0:map[i][j].trees.size();
			}
		}
		bw.write(String.valueOf(count));
		bw.flush();
	}
}