import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] fruits = new int[N];
		for(int i = 0;i<N;i++)
			fruits[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(fruits);
		
		int curLength = L;
		for(int i = 0;i<N;i++) {
			if(curLength >= fruits[i])
				curLength += 1;
			else
				break;
		}
		
		System.out.println(curLength);
		
	}
}
