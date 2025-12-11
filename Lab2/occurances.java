import java.util.Scanner;

public class occurances {
    public static void main(String[] args) {
        System.out.print("Enter no. of elements: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); int arr[] = new int[n]; boolean flags[] = new boolean[n];
        for(int i=0; i<n; i++) { arr[i] = sc.nextInt(); flags[i] = false;}
        sc.close();
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
