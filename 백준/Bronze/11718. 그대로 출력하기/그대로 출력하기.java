import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
String str;
while((str=br.readLine()) != null){
	sb.append(str+"\n");
}

		bw.write(sb.toString());
		bw.flush();
		
	}
}