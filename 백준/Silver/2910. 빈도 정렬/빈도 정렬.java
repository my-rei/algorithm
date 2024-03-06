import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
		HashMap<Integer, int[]> hm = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<N;i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(hm.containsKey(tmp)) hm.put(tmp, new int[] {hm.get(tmp)[0], hm.get(tmp)[1]+1});
			else {
				hm.put(tmp, new int[] {i, 1});
				list.add(tmp);
			}
		}
		list.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(hm.get(o1)[1] != hm.get(o2)[1]) return Integer.compare(hm.get(o2)[1], hm.get(o1)[1]);
				return Integer.compare(hm.get(o1)[0], hm.get(o2)[0]);
			}
		});
		
		for(int j = 0;j<list.size();j++) {
			for(int i = 0;i<hm.get(list.get(j))[1];i++)
				sb.append(list.get(j)+" ");
		}
		bw.write(sb.toString());
		bw.flush();
		
	}
}