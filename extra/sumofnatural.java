import java.util.Scanner;

public class sumofnatural {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); sc.close();
        int sum=0;
        while(n>0) { sum+=n; n--; }
        System.err.println(sum);
    }
}
