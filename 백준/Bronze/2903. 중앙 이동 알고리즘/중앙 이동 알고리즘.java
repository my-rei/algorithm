import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf((int)Math.pow(Math.pow(2, Integer.parseInt(br.readLine())) +1, 2)));
        bw.flush();
    }
}