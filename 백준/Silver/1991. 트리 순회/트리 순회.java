import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb;

	static class Node {
		char val;
		Node left, right, parent;

		public Node(char val) {
			this.val = val;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		Map<Character, Node> nodeMap = new HashMap<>();
		for (int i = 0; i < N; i++) {
			nodeMap.put((char) ('A' + i), new Node((char) ('A' + i)));
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char c = st.nextToken().charAt(0), l = st.nextToken().charAt(0), r = st.nextToken().charAt(0);
			Node n = nodeMap.get(c);
			if (l != '.') {
				n.left = nodeMap.get(l);
				nodeMap.get(l).parent = n;
			}
			if (r != '.') {
				n.right = nodeMap.get(r);
				nodeMap.get(r).parent = n;
			}
		}

		Node root = nodeMap.get('A');
		preOrder(root);
		sb.append("\n");
		inOrder(root);
		sb.append("\n");
		postOrder(root);
		bw.write(sb.toString());
		bw.flush();
	}

	static void preOrder(Node cur) {
		sb.append(cur.val);
		if (cur.left != null)
			preOrder(cur.left);

		if (cur.right != null)
			preOrder(cur.right);

	}

	static void inOrder(Node cur) {
		if(cur.left != null)
			inOrder(cur.left);
		sb.append(cur.val);
		if(cur.right!=null)
			inOrder(cur.right);
	}

	static void postOrder(Node cur) {
		if(cur.left != null)
			postOrder(cur.left);
		if(cur.right!=null)
			postOrder(cur.right);
		sb.append(cur.val);
	}

	static Node findLeft(Node cur) {
		if (cur.left == null)
			return cur;
		else
			return findLeft(cur.left);
	}

	static Node findRight(Node cur) {
		if (cur.right == null)
			return cur;
		else
			return findRight(cur.right);
	}
}