import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		
		List<String> nums = Arrays.asList(str.split("\\+|-"));
		List<Character> exp = new ArrayList<>();
		for(char c:str.toCharArray()) {
			if(c == '+'||c=='-')
				exp.add(c);
		}
		
//		System.out.println(nums.toString());
//		System.out.println(exp.toString());
		List<Integer> plusNums = new ArrayList<>();
		plusNums.add(Integer.parseInt(nums.get(0)));
		for(int i = 0;i<exp.size();i++) {
			if(exp.get(i) == '+') {
				int res = plusNums.get(plusNums.size()-1) + Integer.parseInt(nums.get(i+1));
//				System.out.println(Integer.parseInt(nums.get(i)) +" "+ Integer.parseInt(nums.get(i+1)));
				plusNums.remove(plusNums.size()-1);
				plusNums.add(res);
			} else {
				plusNums.add(Integer.parseInt(nums.get(i+1)));
			}
//			System.out.println(plusNums.toString());
		}
		
		long ans = plusNums.get(0);
		for(int i = 1;i<plusNums.size();i++) {
			ans -= plusNums.get(i);
		}
//		System.out.println(plusNums.toString());
		bw.write(String.valueOf(ans));
		bw.flush();
	}
}