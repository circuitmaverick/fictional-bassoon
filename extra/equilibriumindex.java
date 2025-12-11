import java.util.Scanner;

public class equilibriumindex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); int arr[] = new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        sc.close();
        // find the equilibrium index
        int lsum=0, rsum=0, i=0; boolean eq = false;
        for(i=0; i<n; i++) {
            lsum = 0; rsum = 0;
            // calculate right sum
            for(int r=i+1; r<n; r++) rsum+=arr[r];
            // calculate left sum
            for(int l=i-1; l>=0; l--) lsum+=arr[l];
            // check if both sum are equal
            if(lsum == rsum) {
                eq = true;
                break;
            }
        }
        if(eq) System.err.println("Equilibrium index: "+i);
        else System.out.println("The array is not equilibrium.");
    }
}
