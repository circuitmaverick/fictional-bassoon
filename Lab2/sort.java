import java.util.Scanner;

public class sort {
    public static void main(String[] args) {
        System.out.println("Enter the no. of elements: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); int arr[] = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();
        sc.close();
        // bubble sort
        for(int i=0; i<n-1; i++)
            for(int j=0; j<n-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    arr[j]+=arr[j+1];
                    arr[j+1] = arr[j] - arr[j+1];
                    arr[j]-=arr[j+1];
                }
            }
        // display the array
        for(int i=0; i<n; i++)
            System.out.println(arr[i]);
    }
}
