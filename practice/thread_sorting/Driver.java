import java.util.Arrays;
import java.util.Scanner;

class Matrix {
    private int[][] mat;
    private int rows, cols;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        mat = new int[rows][cols];
    }

    public void inputData() {
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<rows; i++)
            for(int j=0; j<cols; j++)
                mat[i][j] = sc.nextInt();
    }

    public synchronized void show() {
        for(int[] row: mat) {
            for(int val: row) System.out.print("\t"+val);
            System.out.println("\n");
        }
    }

    public synchronized void sortRows() {
        for(int[] row: mat)
            Arrays.sort(row);
    }

    public synchronized void sortCols() {
        for(int i=0; i<cols; i++) {
            int temp[] = new int[rows];

            for(int j=0; j<rows; j++) temp[j] = mat[j][i];

            Arrays.sort(temp);

            for(int j=0; j<rows; j++) mat[j][i] = temp[j];
        }
    }
}

class RowSorterThread extends Thread {
    private Matrix mat;
    public RowSorterThread(String name, Matrix mat) {
        super(name);
        this.mat = mat;
    }

    @Override
    public void run() {
        System.out.println(getName() + " sorting rows....");
        mat.sortRows();
        mat.show();
    }
}

class ColumnSorterThread extends Thread {
    private Matrix mat;

    public ColumnSorterThread(String name, Matrix mat) {
        super(name);
        this.mat = mat;
    }

    @Override
    public void run() {
        System.out.println(getName() + " sorting coloumns....");
        mat.sortCols();
        mat.show();
    }
}

public class Driver {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the dimensions (rowsxcoloumns):\t");
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        Matrix mat = new Matrix(rows, cols);
        mat.inputData();
        System.out.println("BEFORE SORTING MATRIX:");
        mat.show();

        RowSorterThread rt = new RowSorterThread("RowSorter", mat);
        ColumnSorterThread ct = new ColumnSorterThread("ColumnSorter", mat);

        try {
            rt.start();
            rt.join();
            ct.start();
            ct.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
            System.out.println(e);
        } finally {
            System.out.println("MATRIX:");
            mat.show();
        }
    }
}
