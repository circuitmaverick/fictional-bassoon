import java.util.Scanner;

public class palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: "); int n = sc.nextInt(); sc.close();
        // reverse the number n
        int r = 0, q=n;
        while(q>0) {
            r = r*10 + q%10;
            q/=10;
        }
        if(r == n)System.out.println("The given number is palindrome.");
        else System.out.println("The given number is not palindrome.");
    }
}
