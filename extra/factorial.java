import java.util.Scanner;

public class factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = sc.nextInt(), fact = 1; sc.close();
        for(int i=1; i<=n; i++) fact*=i;
        System.out.println(fact);
    }
}
