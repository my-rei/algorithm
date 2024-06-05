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
		
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		String[] str = br.readLine().split(" ");
		
		for(int i = str.length-1;i>-1;i--) {
			int index = Integer.parseInt(str[i]);
			list.add(index, i+1);
		}
		
		bw.write(list.toString().replaceAll("[\\[\\],]", ""));
		bw.flush();
		
	}
}