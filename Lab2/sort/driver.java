import java.util.Scanner;

class Elements {
    private int n, arr[];

    public void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        sc.close();
    }

    public void display() {
        for(int i=0; i<n; i++) System.out.println(arr[i]);
    }

    public void sort() {
        for(int i=0; i<n-1; i++) {
            for(int j=0; j<n-1-i; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}

public class driver {
    public static void main(String[] args) {
        Elements obj = new Elements();
        obj.input();
        obj.display();
        obj.sort();
        obj.display();
    }
}
