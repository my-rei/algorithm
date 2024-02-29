import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Solution {
	static int N, M, K;
	static Map<String, Status> map, tmpMap;
	static int[] dr = { 1, 0, -1, 0 }, dc = { 0, 1, 0, -1 };

	static class Status {
		int code, life, time;
		// -1 죽음 0 비활성화 1활성화 2갓번식

		public Status(int code, int life) {
			this.code = code;
			this.life = life;
			this.time = life;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new HashMap<>();
			tmpMap = new HashMap<>();
			int count = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					int val = Integer.parseInt(st.nextToken());
					if (val > 0) {
						map.put(i + " " + j, new Status(0, val));
						tmpMap.put(i + " " + j, new Status(0, val));
					}
				}
			}

//			System.out.println(map.containsKey(getString(new int[] {0,0})));

			Queue<String> cells = new ArrayDeque<>(); // 번식 모체
			Status s = null, oldS = null;
			Queue<String> removes = new ArrayDeque<>();
//			System.out.println(K + " " + tmpMap.keySet().toString());

			while (K-- > 0) {
				while (!cells.isEmpty()) {
					// 첫 활성화 셀 번식
					int[] c = getCor(cells.peek());
					s = map.get(cells.peek()); // 모체 정보
					for (int d = 0; d < 4; d++) {
						String str = getString(new int[] { c[0] + dr[d], c[1] + dc[d] });
						if (!map.containsKey(str)) {
							Status nS = new Status(2, s.life);
							tmpMap.put(str, nS);
							map.put(str, nS);
						} else {
							// 위치겹친다면
							oldS = map.get(str);
							if (oldS.code == 2 && oldS.life < s.life) {
								// 동시배양상태고 생명력이 클때만
								Status nS = new Status(2, s.life);
								nS.code = 2;
								nS.time = s.life;
								tmpMap.put(str, nS);
								map.put(str, nS);
							}
						}
					}
					cells.poll();
				}
				// tmpMap: 고려대상 셀
				for (Entry<String, Status> entry : tmpMap.entrySet()) {
					s = entry.getValue();
					String key = entry.getKey();
					// 활성화상태일때
					if (s.code == 1) {
						if (s.time == 1) {
							// 죽음
							s.code = -1;
//							System.out.println(K+" dead =" + key);
							removes.add(key);
							map.put(key, s);
						} else {
							// 활성화시간 감소
							s.time -= 1;
							tmpMap.put(key, s);
						}
					}
					// 비활성화상태일때
					else if (s.code == 0) {
						if (s.time == 1) {
							// 활성화 상태 진입
							cells.add(key);
							s.code = 1;
							s.time = s.life;
//							System.out.println(K+" alive = " + key);
							tmpMap.put(key, s);
							map.put(key, s);
						} else {
							// 비활성화시간 감소
							s.code = 0;
							s.time -= 1;
							tmpMap.put(key, s);
						}
					} 
					else if (s.code == 2) {
						s.code = 0;
						tmpMap.put(key, s);
					}
				}
				while (!removes.isEmpty()) {
					tmpMap.remove(removes.poll());
				}
//
//				System.out.println(K+"-queue "+cells.toString());
//				System.out.println(K + "-tmpMap " + tmpMap.keySet().toString());
//				System.out.println(K + "-map " + map.keySet().toString());
			}

			sb.append("#" + test + " " + tmpMap.size() + "\n");
		}

		bw.write(sb.toString());
		bw.flush();
	}

	static String getString(int[] in) {
		String res = "";
		for (int i = 0; i < in.length - 1; i++) {
			res += in[i] + " ";
		}
		res += in[in.length - 1];
		return res;
	}

	static int[] getCor(String str) {
		String[] s = str.split(" ");
		int[] res = new int[2];
		for (int i = 0; i < res.length; i++) {
			res[i] = Integer.parseInt(s[i]);
		}
		return res;
	}
}