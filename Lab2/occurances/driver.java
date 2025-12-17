import java.util.Scanner;

class Elements {

    private int n, arr[];
    private boolean flags[];

    public void input() {
        System.out.print("Enter no. of elements: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); arr = new int[n]; flags = new boolean[n];
        for(int i=0; i<n; i++) { arr[i] = sc.nextInt(); flags[i] = false;}
        sc.close();
    }

    public void findOccurances() {
        for(int i=0; i<n; i++) {
            if(!flags[i]) {
                int count = 1;
                flags[i] = true;
                for(int j=i+1; j<n; j++) {
                    if(!flags[j] && arr[j] == arr[i]) {
                        count++; flags[j] = true;
                    }
                }
                System.out.println("Occurances of "+arr[i]+": "+count);
            }
        }
    }
}

public class driver {
    public static void main(String[] args) {
        Elements ele = new Elements();
        ele.input();
        ele.findOccurances();
    }
}
