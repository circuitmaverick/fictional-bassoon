import java.util.Scanner;

public class arraysort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array: "); int size = sc.nextInt();
        int arr[] = new int[size];
        System.out.println("Enter the elements: ");
        for(int i=0; i<size; i++) arr[i] = sc.nextInt(); // array input
        sc.close();
        for(int i=0; i<size-1; i++)
            for(int j=0; j<size-i-1; j++)
                if(arr[j] < arr[j+1]) {
                    arr[j] += arr[j+1];
                    arr[j+1] = arr[j] - arr[j+1];
                    arr[j] -= arr[j+1];
                }
        // display the array
        System.out.println("Sorted array: ");
        for(int i=0; i<size; i++) System.out.print(arr[i]+" ");
        System.out.println("");
    }
}
