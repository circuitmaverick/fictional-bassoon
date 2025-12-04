import java.util.Scanner;

public class name {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first name: ");
        String fname = sc.next();
        System.out.print("Enter last name: ");
        String lname = sc.next();
        sc.close();
        System.out.println(lname+" "+fname);
    }
}
