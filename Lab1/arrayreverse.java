import java.util.Scanner;

public class arrayreverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int size = sc.nextInt();
        int arr[] = new int[size];
        System.out.println("Enter array elements: ");
        for(int i=0; i<size; i++) arr[i] = sc.nextInt(); // array input
        for(int i=0; i<size/2; i++) {
            arr[i] += arr[size-1-i];
            arr[size-1-i] = arr[i] - arr[size-1-i];
            arr[i] -= arr[size-1-i];
        }

        // display the array
        for(int i=0; i<size; i++) System.out.println(arr[i]);
    }
}
