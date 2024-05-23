import java.io.*;
import java.util.*;
 
public class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
      int N = Integer.parseInt(br.readLine());
      int dasom = Integer.parseInt(br.readLine());
 
      PriorityQueue<Integer> pQueue = new PriorityQueue<>((o1,o2)->o2.compareTo(o1));
 
      for(int i=0;i<N-1;i++) pQueue.offer(Integer.parseInt(br.readLine()));
 
      int cnt = 0;
      while(!pQueue.isEmpty() && dasom++<=pQueue.peek()){
         pQueue.offer(pQueue.poll()-1);
         ++cnt;
      }
 
      bw.write(String.valueOf(cnt));
     bw.flush();
   }
}