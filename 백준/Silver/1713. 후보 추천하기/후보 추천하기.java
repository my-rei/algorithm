import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	static Node[] pictures;
	static int cnt = 0;
	static int maxPic;

	public static class Node {
		public int rec = 0;
		public String num;
		public int when;

		public Node(String n) {
			this.num = n;
		}

		public Node(String n, int r, int w) {
			this.rec = r;
			this.when = w;
			this.num = n;
		}
	}

	public static boolean isIn(String stNum) {
		// 학생이 있는지 확인
		for (Node n : pictures)
			if (n != null && n.num.equals(stNum))
				return true;
		return false;
	}

	public static void addRec(String stNum) {
		// 추천수 증가
		for (Node n : pictures)
			if (n != null && n.num.equals(stNum))
				n.rec = n.rec + 1;
	}

	public static void putSt(String stNum) {
		// 최소 추천 학생 삭제 후 게시
		if (cnt < maxPic) {
			pictures[cnt] = new Node(stNum, 1, cnt++);
		} else {
			Node minTarget = pictures[0];
			for (Node n : pictures) {
				if (minTarget.rec > n.rec)
					minTarget = n;
				else if (minTarget.rec == n.rec) {
					if (minTarget.when > n.when)
						minTarget = n;
				}
			}

			minTarget.num = stNum;
			minTarget.rec = 1;
			minTarget.when = cnt++;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		maxPic = Integer.parseInt(br.readLine());
		int T = Integer.parseInt(br.readLine());
		pictures = new Node[maxPic];

		String[] students = br.readLine().split(" ");
		for (String s : students) {
			if (isIn(s)) {
				addRec(s);
			} else {
				putSt(s);
			}
		}
		
		List<Node> res = new ArrayList<>();
		for(Node p:pictures) {
			if(p != null) res.add(p);
		}
		Collections.sort(res, (e1, e2) -> Integer.compare(Integer.parseInt(e1.num), Integer.parseInt(e2.num)));
		for (int i = 0; i < res.size(); i++) {
			System.out.print(res.get(i).num + " ");
		}
	}

}
