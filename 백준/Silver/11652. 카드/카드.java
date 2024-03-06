import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		HashMap<Long, Integer> map = new HashMap<>();
			
		int maxCnt = 0; long maxInt = 0;
		for(int i = 0;i<N;i++) {
			long tmp = Long.parseLong(br.readLine());
			if(map.containsKey(tmp)) {
				int cnt = map.get(tmp);
				map.put(tmp, cnt+1);
				if(cnt+1 > maxCnt) {
					maxCnt = cnt+1;
					maxInt = tmp;
				} else if (cnt+1 == maxCnt && tmp < maxInt){
					maxCnt = cnt+1;
					maxInt = tmp;
				}
			} else {
				map.put(tmp, 1);
				if(maxCnt == 0 || maxCnt == 1 && tmp < maxInt) {
					maxCnt = 1;
					maxInt = tmp;
				}
			}
		}
		
		bw.write(String.valueOf(maxInt));
		bw.flush();
	}
}