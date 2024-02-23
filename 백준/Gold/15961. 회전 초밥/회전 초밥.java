import java.io.*;
import java.util.*;

public class Main {
	static int[] sList, dList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), D = Integer.parseInt(st.nextToken()),
				K = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());

		sList = new int[N];
		dList = new int[D+1];
		for (int i = 0; i < N; i++) {
			sList[i] = Integer.parseInt(br.readLine());
		}

		int curS = 0, curE = K-1, curVar = 0, maxVar = 0;
		
		// 초기 설정
		for(int i = curS;i<=curE;i++) {
			if(dList[sList[i]] == 0) 
				curVar++;
			dList[sList[i]] ++;
		}
		if(dList[C] == 0) {
			maxVar = curVar+1;
		} else {
			maxVar = curVar;
		}
		
		
		while(curS < N-1) {
			if(dList[sList[curS]] == 1) curVar--;
			if(dList[sList[curS]] > 0) dList[sList[curS]] --;
	
			if(dList[sList[(curE+1)%(N)]] == 0) curVar++;
			dList[sList[(curE+1)%N]] ++;
			
			if(dList[C] > 0) maxVar = Math.max(curVar, maxVar);
			else maxVar = Math.max(curVar+1, maxVar);
			
			
			curS = (curS + 1)% (N);
			curE = (curE + 1) % (N);
		}
		

		System.out.println(maxVar);

	}

}