import java.io.*;
import java.util.*;

public class Solution {
	static int N, M, K, A, B;
	static int[] aTime, aPerson, aCurrent, bTime, bPerson, bCurrent;
	static List<Integer>[] time;
	static PriorityQueue<Integer> aq;
	static Queue<Integer> bq;
	static List<Integer> people;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		aq = new PriorityQueue<>();
		bq = new ArrayDeque<>();
		
		for(int test = 1;test<=T;test++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken())-1;
			B = Integer.parseInt(st.nextToken())-1;
			
			aTime = new int[N];
			aPerson = new int[N];
			aCurrent = new int[N];
			bTime = new int[M];
			bPerson = new int[M];
			bCurrent = new int[M];
			time = new List[1001];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0;i<N;i++)
				aTime[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i = 0;i<M;i++)
				bTime[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i = 1;i<K+1;i++) {
				int t  = Integer.parseInt(st.nextToken());
				if(time[t] == null) time[t] = new ArrayList<>();
				time[t].add(i);
			}
			
			aq.clear();
			bq.clear();
//			System.out.println(time[7].toString());
			List<Integer> aCandidate = new ArrayList<>();
			List<Integer> abCandidate = new ArrayList<>();
			int curT = 0;
			while(K>0) {
				// 현황 출력
//				System.out.println("======="+curT+"=======");
//				System.out.println("aq  "+aq.toString());
//				System.out.println("aCurrent  "+Arrays.toString(aCurrent));
//				System.out.println("aPerson  "+Arrays.toString(aPerson));
//				System.out.println("aCandidate  "+aCandidate.toString());
//				System.out.println("bq  "+bq.toString());
//				System.out.println("bCurrent  "+Arrays.toString(bCurrent));
//				System.out.println("bPerson  "+Arrays.toString(bPerson));
//				System.out.println("abCandidate  "+abCandidate.toString());
				if(curT <= 1000) people = time[curT];
				else people = null;
				if(people != null) { // 대기 손님 
					for(int p : people)
						aq.add(p);
				}
				for(int aIndex = 0;aIndex<N;aIndex++) { // A 넣기
					if(aCurrent[aIndex]> 1) {
						aCurrent[aIndex]--;
						continue;
					}
					if(aCurrent[aIndex] - 1 == 0) {
						// 나감 
						aCurrent[aIndex] = 0;
						int p = aPerson[aIndex];
						aPerson[aIndex] = 0;
						bq.add(p);
					}
					if(aCurrent[aIndex] == 0) {
						if(!aq.isEmpty()) {
							int p = aq.poll();
							if(aIndex == A) aCandidate.add(p);
							aCurrent[aIndex] = aTime[aIndex];
							aPerson[aIndex] = p;
						}		
					}
				}
				for(int bIndex = 0;bIndex<M;bIndex++) {
					if(bCurrent[bIndex]>1) {
						bCurrent[bIndex]--;
						continue;
					}
					if(bCurrent[bIndex] - 1== 0) {
						bCurrent[bIndex] = 0;
						K--;
					}
					if(bCurrent[bIndex] == 0) {
						if(!bq.isEmpty()) {
							int p = bq.poll();
							if(bIndex == B) for(int tmp:aCandidate) if(tmp==p) abCandidate.add(p);
							bCurrent[bIndex] = bTime[bIndex];
							bPerson[bIndex] = p;
						}
					}
				}
				curT++;
			}
			
			int pSum = 0;
			if(abCandidate.size() == 0) pSum = -1;
			else {
				for(int p:abCandidate) pSum += p;
			}
				
			sb.append("#"+test+" "+pSum+"\n");
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		
	}
}