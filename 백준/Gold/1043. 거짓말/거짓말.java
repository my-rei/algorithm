import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] people;
	static List<Integer>[] party;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		people = new int[N+1];
		create();
		party = new List[M];
		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		while(t-- > 0) {
			union(Integer.parseInt(st.nextToken()), 0);
		}
		for(int i = 0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			t = Integer.parseInt(st.nextToken());
			party[i] = new ArrayList<>();
			for(int j = 0;j<t;j++) {
				party[i].add(Integer.parseInt(st.nextToken()));
				union(party[i].get(0), party[i].get(j));
			}
		}
		
		int count = 0;
		for(int i = 0;i<M;i++) {
			boolean flag = true;
			for(int p:party[i]) {
				if(find(p)== 0) {flag = false; break;}
			}
			if(flag) count ++;
		}
		
//		System.out.println(Arrays.toString(people));
		bw.write(String.valueOf(count));
		bw.flush();
	}
	
	static void create() {
		for(int i = 0;i<=N;i++)
			people[i] = i;
	}
	
	static int find(int a) {
		if(people[a] == a) return a;
		else return (people[a] = find(people[a]));
	}
	
	static boolean union(int a, int b) {
		int pa = find(a), pb = find(b);
		if(pa == pb) return false;
		if(pa > pb) people[pa] = pb;
		else people[pb] = pa;
		return true;
	}
}