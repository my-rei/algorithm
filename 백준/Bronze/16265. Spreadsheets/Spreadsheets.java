import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the number of test cases
        int t = scanner.nextInt();
        
        // Process each test case
        for (int i = 0; i < t; i++) {
            int k = scanner.nextInt();
            System.out.println(columnName(k));
        }
        
        scanner.close();
    }
    
    // Function to convert a given number to its corresponding column name
    private static String columnName(int n) {
        StringBuilder result = new StringBuilder();
        
        while (n > 0) {
            n--; // Adjust from 1-based index to 0-based index
            int remainder = n % 26;
            result.append((char)(remainder + 'A'));
            n = n / 26;
        }
        
        return result.reverse().toString();
    }
}