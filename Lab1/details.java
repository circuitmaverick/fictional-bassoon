import java.util.*;

public class details {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String name, section, branch;
        int rollno;
        System.out.print("Enter name, roll no, section, and branch: ");
        name = sc.nextLine();
        rollno = sc.nextInt();
        section = sc.next();
        branch = sc.next();
        sc.close();
        System.out.println(name);
        System.out.println(rollno);
        System.out.println(section);
        System.out.println(branch);
    }
}