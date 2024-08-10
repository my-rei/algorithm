import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		while(N-->0) {
			st = new StringTokenizer(br.readLine());
			int time = 0;
			int h = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			int elevator = 0;
			int move = 0;
			int[] belt = new int[l];
			for(int j = 0;j<h;j++) {
				st = new StringTokenizer(br.readLine());
				int offset = 0;
				int found = 0;
				for(int i = 0;i<l;i++) {
					belt[i] = Integer.parseInt(st.nextToken());
					if(belt[i] > -1) found++;
				}
				while(found > 0) {
					//최댓값 찾는다 
					int curMin = Integer.MAX_VALUE, curMinInd = 0;
					for(int i = 0;i<l;i++) {
						if(belt[i] != -1 && curMin > belt[i]) {
							curMin = belt[i];
							curMinInd = i;
						}
					}
//					System.out.println("offset="+offset+" curMinInd="+curMinInd+" curMin="+curMin+" move="+move+" curMove="+(Math.min(Math.abs(curMinInd-offset), Math.abs(curMinInd>offset? l-curMinInd+offset:l-offset+curMinInd))));
					//offset이랑 차이 중 작은 것을 더한다 
					move += Math.min(Math.abs(curMinInd-offset), Math.abs(curMinInd>offset? l-curMinInd+offset:l-offset+curMinInd));
					elevator += j*2;
					belt[curMinInd] = -1;
					found--;
					offset = curMinInd;
				}
			}
			sb.append(((long)move*5 + (long)elevator*10)+"\n");
//			System.out.println("-------------");
		}
		
		
		
		bw.write(sb.toString());	
		bw.flush();
	}
}