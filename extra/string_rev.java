import java.util.Scanner;

public class string_rev {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine(); char s[] = str.toCharArray(); sc.close();
        for(int i=0; i<s.length/2; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 -i] = temp;
        }
        System.out.println(s);
    }
}
