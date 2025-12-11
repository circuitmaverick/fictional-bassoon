import java.util.Scanner;

public class fibonacci {

    public static void main(String[] args) {
        System.out.print("Enter number of terms: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); sc.close();
        int i=0, j=1; System.out.println(j);
        for(int x=2; x<=n; x++) {
            int temp = j;
            j+=i;
            i=temp;
            System.out.println(j);
        }
    }
}