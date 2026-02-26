import java.util.Scanner;

class StringHandler {
    private String s;

    public void input(Scanner sc) {
        System.out.print("Enter a string: ");
        s = sc.nextLine();
    }

    public String changeCases() {
        char chArr[] = s.toCharArray();
        for(int i = 0; i < chArr.length; i++) {
            char c = chArr[i];
            if(c >= 'A' && c <= 'Z') chArr[i] = (char)(c + 32); else if(c >= 'a' && c <= 'z') chArr[i] = (char)(c - 32);
        }
        return new String(chArr);
    }

    public String reverse() {
        StringBuffer sb = new StringBuffer(s);
        return sb.reverse().toString();
    }

    public int compare(String cmpStr) {
        return s.compareTo(cmpStr);
    }

    public String insertString(String insertStr) {
        return s+insertStr;
    }

    public String uppercase() {
        return s.toUpperCase();
    }

    public String lowercase() {
        return s.toLowerCase();
    }

    public int getPosition(char key) {
        return s.indexOf(key);
    }

    public boolean isPalindrome() {
        StringBuffer sb = new StringBuffer(s);
        return (sb.reverse().toString() == s);
    }

    public int countWords() {
        int count = 1;
        for(char c: s.toCharArray()) count = (c == ' ' ? count+1 : count);
        return count;
    }

    public int countVowels() {
        int count = 0;
        for(char c: s.toLowerCase().toCharArray()) count = (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ? count+1 : count);
        return count;
    }

    public int countConsonants() {
        int count = 0;
        for(char c: s.toLowerCase().toCharArray()) count = (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == ' ' ? count : count+1);
        return count;
    }
}

public class Driver {
    public static void main(String[] args) {
        StringHandler sh = new StringHandler();

        Scanner sc = new Scanner(System.in);
        sh.input(sc);

        while(true) {
            /* MENU */
            System.out.println("------------------------------MENU------------------------------");
            System.out.println("1\tChange cases of the string");
            System.out.println("2\tReverse the string");
            System.out.println("3\tCompare two strings");
            System.out.println("4\tInsert a string");
            System.out.println("5\tChange the string to uppercase and lowercase");
            System.out.println("6\tCheck position of a character in a string");
            System.out.println("7\tCheck palindrome string");
            System.out.println("8\tCheck number of words, vowels and consonants in the string");
            System.out.println("\n\nPRESS ANY OTHER KEY TO EXIT\n");
            System.out.println("------------------------------X-X-X------------------------------");
            System.out.print("\n\nSELECT OPTION\t>\t");
            int c = sc.nextInt();

            /* SWITCH TO HANDLE SELECTED OPTION */
            switch (c) {
                case 1:
                    System.out.println("Cases changed:\t"+sh.changeCases());
                    break;
                case 2:
                    System.out.println("Reversed string:\t"+sh.reverse());
                    break;
                case 3:
                    System.out.print("Enter the second string to compare with: "); sc.nextLine();
                    String cmpstr = sc.nextLine();
                    System.out.println("The comparison ASCII value is:\t"+sh.compare(cmpstr));
                    break;
                case 4:
                    System.out.print("Enter the string to insert: "); sc.nextLine();
                    String insert = sc.nextLine();
                    System.out.println("After insertion:\t"+sh.insertString(insert));
                    break;
                case 5:
                    System.out.println("UPPERCASE:\t"+sh.uppercase());
                    System.out.println("lowercase:\t"+sh.lowercase());
                    break;
                case 6:
                    System.out.print("Enter the character: ");
                    char key = sc.next().charAt(0);
                    int index = sh.getPosition(key);
                    System.out.println( index == -1 ? "NOT FOUND" : "Found first at index : "+index);
                    break;
                case 7:
                    System.out.println(sh.isPalindrome() ? "PALINDROME STRING" : "NOT A PALINDROME STRING");
                    break;
                case 8:
                    System.out.println("Words:\t" + sh.countWords());
                    System.out.println("Vowels:\t" + sh.countVowels());
                    System.out.println("Consonants:\t" + sh.countWords());
                    break;
                default:
                    return;
            }
        }
    }
}
