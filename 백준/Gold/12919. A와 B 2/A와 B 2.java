import java.io.*;
import java.util.*;

public class Main {
	static String S, T;
	static int f=0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		S = br.readLine(); T = br.readLine();
		newGame(T);
		bw.write(String.valueOf(f));
		bw.flush();
	}
	
	static void newGame(String now) {
		if(now.length() == S.length() && now.equals(S)) {
			f =1;
		}
		if(now.length() <= S.length()) return;
		if(now.charAt(now.length()-1) == 'A') newGame(now.substring(0, now.length()-1));
		if(now.charAt(0) == 'B') {
			String rev = "";
			for(char c:now.toCharArray()) rev = c+rev;
			newGame(rev.substring(0, rev.length()-1));
		}
	}

	static void game(String now) {
		if(now.length() == T.length() && now.equals(T)) {
			f=1;
		}
		if(now.length() >= T.length()) return;
		
		game(now+"A");
		String rev = "";
		for(char c:now.toCharArray()) rev = c+rev;
		game("B"+rev);
	}
}