import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[][] paper;
	static int N, M;
	static List<Integer> pList;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());M = Integer.parseInt(st.nextToken());
		paper = new int[N+6][M+6];
		pList = new ArrayList<>();
		for(int i = 3;i<N+3;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 3;j<M+3;j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		System.out.println(getMax());
	}
	
	static int getMax() {
		int maxCnt = 0;
		for(int i = 3;i<N+3;i++) {
			for(int j = 3;j<M+3;j++) {
				pList.clear();
				getCyan(i,j);
				getYellow(i,j);
				getOrange(i,j);
				getGreen(i,j);
				getPink(i,j);
				Collections.sort(pList);
				maxCnt = Math.max(maxCnt, pList.get(pList.size()-1));
			}
		}
		return maxCnt;
	}
	
	static void getCyan(int i, int j) {
		pList.add(paper[i][j] + paper[i-1][j] + paper[i-2][j]+paper[i-3][j]);
		pList.add(paper[i][j] + paper[i][j-1]+paper[i][j-2]+paper[i][j-3]);
		pList.add(paper[i][j] + paper[i+1][j] + paper[i+2][j]+paper[i+3][j]);
		pList.add(paper[i][j] + paper[i][j+1]+paper[i][j+2]+paper[i][j+3]);
	}
	static void getYellow(int i, int j) {
		pList.add(paper[i][j] + paper[i-1][j] + paper[i][j-1]+paper[i-1][j-1]);
		pList.add(paper[i][j] + paper[i+1][j]+paper[i+1][j-1]+paper[i][j-1]);
		pList.add(paper[i][j] + paper[i+1][j]+paper[i+1][j+1]+paper[i][j+1]);
		pList.add(paper[i][j] + paper[i-1][j] + paper[i][j+1]+paper[i-1][j+1]);
	}
	static void getOrange(int i, int j) {
		pList.add(paper[i][j] + paper[i+1][j] + paper[i+2][j]+paper[i+2][j+1]);
		pList.add(paper[i][j] + paper[i][j-1] + paper[i][j-2]+paper[i+1][j-2]);
		pList.add(paper[i][j] + paper[i-1][j] + paper[i-2][j]+paper[i-2][j-1]);
		pList.add(paper[i][j] + paper[i][j+1] + paper[i][j+2]+paper[i-1][j+2]);
		
		pList.add(paper[i][j] + paper[i+1][j] + paper[i+2][j]+paper[i+2][j-1]);
		pList.add(paper[i][j] + paper[i][j-1] + paper[i][j-2]+paper[i-1][j-2]);
		pList.add(paper[i][j] + paper[i-1][j] + paper[i-2][j]+paper[i-2][j+1]);
		pList.add(paper[i][j] + paper[i][j+1] + paper[i][j+2]+paper[i+1][j+2]);
	}
	static void getGreen(int i, int j) {
		pList.add(paper[i][j] + paper[i+1][j] + paper[i+1][j+1]+paper[i+2][j+1]);
		pList.add(paper[i][j] + paper[i][j-1] + paper[i+1][j-1]+paper[i+1][j-2]);
		pList.add(paper[i][j] + paper[i-1][j] + paper[i-1][j-1]+paper[i-2][j-1]);
		pList.add(paper[i][j] + paper[i][j+1] + paper[i-1][j+1]+paper[i-1][j+2]);
		
		pList.add(paper[i][j] + paper[i+1][j] + paper[i+1][j-1]+paper[i+2][j-1]);
		pList.add(paper[i][j] + paper[i][j-1] + paper[i-1][j-1]+paper[i-1][j-2]);
		pList.add(paper[i][j] + paper[i-1][j] + paper[i-1][j+1]+paper[i-2][j+1]);
		pList.add(paper[i][j] + paper[i][j+1] + paper[i+1][j+1]+paper[i+1][j+2]);
	}
	static void getPink(int i, int j) {
		pList.add(paper[i][j] + paper[i][j+1] + paper[i][j+2]+paper[i+1][j+1]);
		pList.add(paper[i][j] + paper[i+1][j] + paper[i+2][j]+paper[i+1][j-1]);
		pList.add(paper[i][j] + paper[i][j-1] + paper[i][j-2]+paper[i-1][j-1]);
		pList.add(paper[i][j] + paper[i-1][j] + paper[i-2][j]+paper[i-1][j+1]);
		
		pList.add(paper[i][j] + paper[i][j+1] + paper[i][j+2]+paper[i-1][j+1]);
		pList.add(paper[i][j] + paper[i+1][j] + paper[i+2][j]+paper[i+1][j+1]);
		pList.add(paper[i][j] + paper[i][j-1] + paper[i][j-2]+paper[i+1][j-1]);
		pList.add(paper[i][j] + paper[i-1][j] + paper[i-2][j]+paper[i-1][j-1]);
	}
}
