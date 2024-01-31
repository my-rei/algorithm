
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Set<String> s = new HashSet<>();
		
		int M = Integer.parseInt(br.readLine());
		while(M-->0) {
			String[] order = br.readLine().split(" ");
			
			switch(order[0]) {
			case "add":
				s.add(order[1]);
				break;
			case "remove":
				if (s.contains(order[1]))
					s.remove(order[1]);
				break;
			case "check":
				sb.append((s.contains(order[1])? 1:0)+"\n");
				break;
			case "toggle":
				if (s.contains(order[1]))
					s.remove(order[1]);
				else
					s.add(order[1]);
				break;
			case "all":
				for(int i = 1;i<=20;i++)
					s.add(String.valueOf(i));
				break;
			case "empty":
				s.clear();
				break;
			}
		}
		System.out.println(sb);
	}
}