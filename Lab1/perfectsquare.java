import java.util.Scanner;

public class perfectsquare {
    public static void main(String[] args) {
        System.out.println("Enter the number: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(); boolean flag = false; sc.close();
        for(int i=1; i<num/2; i++) {
            if(i*i == num) { flag = true; break; }
        }
        if(flag) System.out.println("Given number is a perfect square");
        else System.out.println("Given number is not a perfect square");
    }
}
