import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class User {
		int lv; String nn;
		User(int l, String s){
			lv = l; nn = s;
		}
	}
	static class Room {
		int lv;
		List<User> player;
		Room(int l){
			lv = l;
			player = new ArrayList<>();
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		List<Room> list = new ArrayList<>();
		while(p-->0) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			String n = st.nextToken();
			boolean flag = false;
			// 들어갈 방 찾기
			for(int i = 0;i<list.size();i++) {
				Room r = list.get(i);
				if(r.player.size() < m && Math.abs(r.lv-l) <= 10) {
					r.player.add(new User(l, n));
					flag = true;
					break;
				}
			}
			if(!flag) {
				Room r = new Room(l);
				r.player.add(new User(l, n));
				list.add(r);
			}
		}
		
		for(int i = 0;i<list.size();i++) {
			List<User> pl = list.get(i).player;
			if(pl.size() == m) sb.append("Started!\n");
			else sb.append("Waiting!\n");
			pl.sort((u1, u2) -> u1.nn.compareTo(u2.nn));
			for(User u : pl) {
				sb.append(u.lv+" "+u.nn+"\n");
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
	}

}