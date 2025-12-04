import java.util.Scanner;

public class grade {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int marks;
        String grade;
        System.out.print("Enter marks: "); marks = sc.nextInt(); sc.close();
        if(marks < 0 && marks > 100) System.out.print("Marks out of range!");
        else {
            if(marks >= 90) grade = "O";
            else if(marks >= 80) grade = "E";
            else if(marks >= 70) grade = "A";
            else if(marks >= 60) grade = "B";
            else if(marks >= 50) grade = "C";
            else grade = "F";
            System.out.println(grade);
        }
    }
}
