import java.util.Scanner;

public class araryduplicate {
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
        // find if duplicate elements present
        boolean flag = false;
        for(int i=0; i<size-1; i++)
            if(arr[i] == arr[i+1]) {
                flag = true;
                break;
            }
        if(flag) System.out.println("Duplicate elements present.");
        else System.out.println("Duplicate elements not present.");
    }
}
