// package evenodd;

import java.util.Scanner;

class EvenOdd {
    private int n, arr[];

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        n = sc.nextInt(); arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        sc.close();
    }

    public void check() {
        for(int i=0; i<n; i++)
            if (arr[i]%2==0) System.out.println(arr[i]+" is even");
            else System.out.println(arr[i]+" is odd");
    }

}

public class driver {
    public static void main(String[] args) {
        EvenOdd obj = new EvenOdd();
        obj.input();
        obj.check();
    }
}
