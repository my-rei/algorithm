import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Record {
		int id, count=0, last=0, total = 0;
		int[] score;
		public Record(int i, int n) {
			id = i;
			score = new int[n];
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		while(T-->0) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int TM = Integer.parseInt(st.nextToken())-1;
			int M = Integer.parseInt(st.nextToken());
			
			Record[] record = new Record[N];
			for(int i = 0;i<N;i++)
				record[i] = new Record(i, K);
			
			for(int i = 0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int cur = Integer.parseInt(st.nextToken())-1;
				int j = Integer.parseInt(st.nextToken())-1;
				int s = Integer.parseInt(st.nextToken());
				record[cur].count++;
				record[cur].score[j] = Math.max(record[cur].score[j], s);
				record[cur].last = i;
			}
			
			for(int i = 0;i<N;i++) 
				record[i].total = Arrays.stream(record[i].score).sum();
			
			
			Arrays.sort(record, (Record a, Record b) -> 
				Integer.compare(a.total, b.total) * -1 == 0? 
						Integer.compare(a.count, b.count) == 0? 
								Integer.compare(a.last, b.last) :
									Integer.compare(a.count, b.count) :
										Integer.compare(a.total, b.total) * -1
			);
			
			for(int i = 0;i<N;i++) 
				if(record[i].id == TM) {
					sb.append((i+1)+"\n");
					break;
				}
			
		}
		

		bw.write(sb.toString());
		bw.flush();
	}

}