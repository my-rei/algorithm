import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
	static class Word {
		String content;
		int number;
		public Word(String c, int n) { this.content = c; this.number = n; }
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<String, Integer> words = new HashMap<>();
		
		for(int i = 0;i<N;i++) {
			String s = br.readLine();
			if(s.length() < M) continue;
			if(words.containsKey(s)) {
				words.put(s, words.get(s)+1);
			} else {
				words.put(s, 1);
			}
		}
		
		List<Word> list = new ArrayList<>();
		for(Entry<String, Integer> entry : words.entrySet()) {
			list.add(new Word(entry.getKey(), entry.getValue()));
		}
		Collections.sort(list, new Comparator<Word>(){
			@Override
			public int compare(Word o1, Word o2) {
				if(o1.number != o2.number) return Integer.compare(o1.number, o2.number) * -1;
				else if(o1.content.length() != o2.content.length()) return Integer.compare(o1.content.length(), o2.content.length()) * -1;
				return o1.content.compareTo(o2.content);
			}
		});
		
		for(Word w : list) {
			sb.append(w.content).append("\n");
		}
		
		
		bw.write(sb.toString());
		bw.flush(); 
	}
	
}