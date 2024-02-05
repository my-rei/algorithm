import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		Set<String> s = new HashSet<>();
		for(int i = 0;i<n;i++) {
			s.add(br.readLine());
		}
		List<String> nonP = new ArrayList<>();
		for(int i =0;i<m;i++) {
			String name = br.readLine();
			if(s.contains(name)) 
				nonP.add(name);
		}
		Collections.sort(nonP);
		sb.append(nonP.size()+"\n");
		sb.append(nonP.toString().replaceAll("[\\[\\]]", "").replaceAll(", ", "\n"));
		
		System.out.println(sb);
	}
}
