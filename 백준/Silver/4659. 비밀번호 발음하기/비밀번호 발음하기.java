import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String target = "";
		
		while(!(target = br.readLine()).equals("end")) {
			if(check(target)) {
				sb.append("<").append(target).append("> is acceptable.\n");
			} else {
				sb.append("<").append(target).append("> is not acceptable.\n");
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
	
	static boolean check(String str) {
		boolean hasM=false;
		int countM = 0, countJ = 0;
		char last='\0';
		
		for(int i = 0;i<str.length();i++) {
			if(isMoeum(str.charAt(i))) {countM++; countJ=0; hasM=true;}
			else {countJ++; countM=0;}
			if(countM==3 || countJ==3) return false;
			if(last==str.charAt(i) && last != 'e' && last != 'o') return false;
			last = str.charAt(i);
		}

		return hasM;
	}
	
	static boolean isMoeum(char c) {
		return (c=='a')||(c=='e')||(c=='i')||(c=='o')||(c=='u');
	}
}