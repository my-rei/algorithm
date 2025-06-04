import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int answer=0;
        for(int i =3;i>0;i--) {
            String str = br.readLine();
            if(!str.equals("Fizz")&&!str.equals("Buzz")&&!str.equals("FizzBuzz")) {
                answer = i + Integer.parseInt(str);
            } 
        }
        bw.write(String.valueOf(answer % 15 == 0? "FizzBuzz":answer%3 == 0? "Fizz":answer%5==0? "Buzz":answer));
        bw.flush();
    }
}
