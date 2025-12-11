import java.util.Scanner;

public class duplicateCharString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine(); sc.close();
        char[] s = str.toCharArray();
        for(int i=0; i<s.length; i++) {
            if(s[i] != ' ') {
                boolean flag = false;
                for(int j=i+1; j<s.length; j++) {
                    if(s[j] == s[i]) {
                        flag = true;
                        s[j] = ' ';
                    }
                }
                if(flag) System.out.println(s[i]);
                s[i] = ' ';
            }
        }
    }
}
