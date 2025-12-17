import java.util.Scanner;

class Matrix {
    private int dmns, mat[][];

    public Matrix(int dimension) {
        this.dmns = dimension;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        mat = new int[dmns][dmns];
        // take input of the matrix
        for(int i=0; i<dmns; i++)
            for(int j=0; j<dmns; j++)
                mat[i][j] = sc.nextInt();
        sc.close();
    }

    public void diagonalSum() {
        int lsum=0, rsum=0;
        for(int i=0; i<dmns; i++) {
            lsum+=mat[i][i];
            rsum+=mat[i][dmns-1-i];
        }
        System.out.println("Left diagonal sum: "+lsum);
        System.out.println("Right diagonal sum: "+rsum);
    }
}

public class driver {
    public static void main(String[] args) {
        Matrix mat = new Matrix(3);
        mat.input();
        mat.diagonalSum();
    }
}
