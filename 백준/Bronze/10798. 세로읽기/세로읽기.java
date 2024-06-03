import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		char[][] str = new char[5][];
		int maxLeng = 0;
		for(int i = 0;i<5;i++) {
			str[i] = br.readLine().toCharArray();
			maxLeng = Math.max(maxLeng, str[i].length);
		}
		
		for(int i = 0;i<maxLeng;i++) {
			for(int j = 0;j<5;j++) {
				if(i < str[j].length) {
					sb.append(str[j][i]);
				}
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		
	}
}