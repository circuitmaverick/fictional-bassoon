import java.util.Scanner;

public class removeduplicatearray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); int arr[] = new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        sc.close();
        for(int i=0; i<n; i++) {
            int key = arr[i];
            for(int j=i+1; j<n; j++) {
                if(arr[j] == key) {
                    // remove arr[j] and left shift
                    for(int k=j; k<n-1; k++) {
                        arr[k] = arr[k+1];
                    }
                    n--;
                }
            }
        }
        for(int i=0; i<n; i++) System.out.println(arr[i]);
    }
}
