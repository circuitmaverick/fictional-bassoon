import java.util.Scanner;

public class matrix {

    public static void main(String[] args) {
        int dmns = 3;
        Scanner sc = new Scanner(System.in);
        int mat[][] = new int[dmns][dmns];
        // take input of the matrix
        for(int i=0; i<dmns; i++)
            for(int j=0; j<dmns; j++)
                mat[i][j] = sc.nextInt();
        sc.close();
        // calculate left diagonal sum
        int lsum=0, rsum=0;
        for(int i=0; i<dmns; i++) {
            lsum+=mat[i][i];
            rsum+=mat[i][dmns-1-i];
        }
        System.out.println("Left diagonal sum: "+lsum);
        System.out.println("Right diagonal sum: "+rsum);
    }
}