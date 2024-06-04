import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		boolean[] isVirus = new boolean[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<K;i++) {
			isVirus[Integer.parseInt(st.nextToken())] = true;
		}
		List<int[]> logs = new ArrayList<>();
		for(int i = 0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			logs.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
		logs.sort(Comparator.comparingInt(arr -> arr[0]));
		
		for(int i = 1;i<=N;i++) {
			if(!isVirus[i]) continue;
			
			boolean[] getVirus = new boolean[N+1];
			getVirus[i] = true;
			int count = 1;
			for(int j = 0;j<M;j++) {
				if(getVirus[logs.get(j)[1]]) {
					if(!getVirus[logs.get(j)[2]] && isVirus[logs.get(j)[2]]) { // 적합
						getVirus[logs.get(j)[2]] = true;
						count++;
					}
					if(!isVirus[logs.get(j)[2]]) { // 비적합
						count = -1;
						break;
					}
				}
				
			}
			
			
//			System.out.println(i+":  "+count);
			if(count == K) {
				bw.write(String.valueOf(i));
				break;
			}
		}
		
		bw.flush();
		
	}
}