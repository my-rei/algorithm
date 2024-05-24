import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] color = {"black", "brown", "red", "orange", "yellow", "green",
				"blue", "violet", "grey", "white"};
		
		String A = br.readLine();
		String B = br.readLine();
		String C = br.readLine();

		long result = (Arrays.asList(color).indexOf(A) * 10) + Arrays.asList(color).indexOf(B);
		result *= Math.pow(10, Arrays.asList(color).indexOf(C));
		bw.write(String.valueOf(result));
        bw.flush();
	}

}