import java.io.*;
import java.util.*;

public class Main {
	static int N, maxRes=Integer.MIN_VALUE;
	static char[] exp;
	static char[] op;
	static int[] num;
	static boolean[] selected;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		exp = br.readLine().toCharArray();
		num = new int[N/2+1];
		op = new char[N/2];
		
		for(int i = 0;i<N;i++) {
			if(i%2==0) num[i/2] = exp[i]-'0';
			else op[i/2] = exp[i];
		}
		
		selected = new boolean[N/2];
		dfs(0,0);
		bw.write(Integer.toString(maxRes));
		bw.flush();
	}
	
	static void dfs(int depth, int cur) {
		maxRes = Math.max(calculate(), maxRes);
		
		if(depth == N/2) return;
		for(int i = cur;i<N/2;i++) {
			if((i == 0 || i>0&&!selected[i-1]) && (i==N/2-1 || i<N/2-1&&!selected[i+1])) {
				selected[i] = true;
				dfs(depth+1, i+1);
				selected[i] = false;
			}
		}
	}
	
	
	static int calculate() {
		List<Integer> nums = new ArrayList<>();
		List<Character> ops = new ArrayList<>();
		
		nums.add(num[0]);
		for(int i = 0;i<N/2;i++) {
			if(selected[i]) {
				nums.remove(nums.size()-1);
				nums.add(getCal(num[i], op[i], num[i+1]));
			} else {
				ops.add(op[i]);
				nums.add(num[i+1]);
			}
		}
		int res = nums.get(0);
		for(int i = 0;i<ops.size();i++) {
//			System.out.println(res+" "+ops.get(i)+" "+nums.get(i+1));
			res = getCal(res, ops.get(i), nums.get(i+1));
		}
		
		return res;
	}
	
	static int getCal(int num1, char opr, int num) {
//		System.out.println(num1+" "+opr+" "+num);
		if(opr == '+') 
			return num1+num;
		else if (opr == '-')
			return num1-num;
		else if (opr == '*')
			return num1*num;
		
		return num1;
	}
}