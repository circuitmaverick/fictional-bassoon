import java.util.Scanner;

public class arraylargest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array: "); int size = sc.nextInt();
        int arr[] = new int[size];
        System.out.println("Enter the elements: ");
        for(int i=0; i<size; i++) arr[i] = sc.nextInt(); // array input
        sc.close(); int max=arr[0];
        for(int i=0; i<size-1; i++)
            if(arr[i] > max) max = arr[i];
        // display the array
        System.out.println("Max: "+max);
    }
}
