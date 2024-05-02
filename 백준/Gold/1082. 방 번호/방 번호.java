import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] p = new int[N];
		int minN = -1, minNP = Integer.MAX_VALUE, notZeroN = -1, notZeroNP = Integer.MAX_VALUE;
		for(int i = 0;i<N;i++) {
			p[i] = Integer.parseInt(st.nextToken());
			if(minNP >= p[i]) {
				minNP = p[i]; minN = i;
			}
			if(i != 0 && notZeroNP >= p[i]) {
				notZeroNP = p[i]; notZeroN = i;
			}
		}
		int M = Integer.parseInt(br.readLine());
		
		
		ArrayList<Integer> nums = new ArrayList<>();
		int remain = M;
		if(minN == 0 && notZeroN != -1 && remain >= notZeroNP) { 
			nums.add(notZeroN);
			remain -= notZeroNP;
		}
		
		int minCount = remain/minNP;
		int c = 0;
		while(c++ < minCount) {
			nums.add(minN);
		}
//		System.out.println(nums.toString());
		remain = remain%minNP;
		
//		System.out.println(minN+" "+minNP+" "+minCount+" "+remain+" "+notZeroNP);
		int cur = 0;
		for(int i = N-1;i>-1;) {
			if(i == minN || cur == nums.size()) break;
//			System.out.println(i+"i"+ " "+remain);
			if(p[i]- p[nums.get(cur)] <= remain) {
				remain -= p[i]- p[nums.get(cur)];
				nums.set(cur, i);
//				System.out.println(i);
				cur++;
			} else {
				i--;
			}
		}
		
		
		bw.write(nums.get(0) == 0? "0":nums.toString().replaceAll("[\\[\\], ]", ""));
		bw.flush();
	}
}