// package evenodd;

import java.util.Scanner;

class EvenOdd {
    private int arr[] = new int[10];

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter elements: ");
        for(int i=0; i<10; i++) arr[i] = sc.nextInt();
        sc.close();
    }

    public void check() {
        for(int i=0; i<10; i++)
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
