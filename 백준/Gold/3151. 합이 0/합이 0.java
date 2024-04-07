import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] students;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		students = new int[N];
		for(int i = 0;i<N;i++) {
			students[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(students);
//		System.out.println(Arrays.toString(students));
		int s = 0, e = N-1; long count = 0;
		while(s+1 < N-1) {
			count += findMid(s, e);
			
//			System.out.println(s+" "+e+"  => "+findMid(s,e));
			e--;
			if(students[e] < 0 || s+1 == e) {
				s++;
				e = N-1;
			}
			if(students[s] > 0) break;
		}
		
		bw.write(String.valueOf(count));
		bw.flush();
	}
	
	static long findMid(int s1, int e1) {
		int s = s1+1, e = e1, sum = students[s1]+students[e1], fix, count = 0; 
		while(s < e) {
			int mid = (s+e)/2;
			if(sum+students[mid] < 0) {
				s = mid+1;
			} else {
				e = mid;
			}
		}
		int m = e;
//		int fix = sum+students[e];
//		while(s < e1 && (fix = sum+students[s++]) == 0) {
//			count++;
//		}
//		count = sum+students[e]==0?1:0;
//		return count;
		if(sum+students[s] != 0) return 0;
//		System.out.println("s="+s1+" e="+e1+"  mid="+m+"   count="+count+" ("+students[s1]+","+students[m]+","+students[e1]+")");
//		System.out.println(Math.min(e1, getUpper(students[s]))+" "+Math.max(s, getLower(students[s]))+" mid="+s);
		return Math.min(e1, getUpper(students[s]))-Math.max(s, getLower(students[s]));
	}
	
	static int getUpper(int value) {
		int end = students.length;
	    int start = 0;
	    while(start<end){
	        int mid = (start+end)/2;
	        if(value<students[mid]){ 
	            end = mid; 
	        }else{ 
	            start = mid+1; 
	        }
	    }
	    return end;
	}
	static int getLower(int value) {
		int end = students.length;
	    int start = 0;
	    while(start<end){
	        int mid = (start+end)/2;
	        if(value>students[mid]){ 
	            start = mid+1; 
	        }else{ 
	            end = mid; 
	        }
	    }
	    return start;
	}
}