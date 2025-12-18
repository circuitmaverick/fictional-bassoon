import java.util.Scanner;

class Student {
    private int rollno;
    private float cgpa;
    private String name;

    public void input(Scanner read) {
        System.out.println("Enter the roll no.: "); this.rollno = read.nextInt(); read.nextLine();
        System.out.println("Enter the name: "); this.name = read.nextLine();
        System.out.println("Enter the cgpa: "); this.cgpa = read.nextFloat();
    }

    public float getCGPA() {
        return cgpa;
    }

    public String getName() {
        return name;
    }

    public void display() {
        System.out.println("--------Student--------");
        System.out.println("Roll No.: "+rollno);
        System.out.println("Name: "+name);
        System.out.println("CGPA: "+cgpa);
        System.out.println("-----------------------");
    }

}

public class driver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of students: ");
        int n = sc.nextInt(); Student students[] = new Student[n];
        // create the student list
        for(int i=0; i<n; i++) {
            System.out.println("Enter details of student "+i+1+"----------");
            students[i] = new Student();
            students[i].input(sc);
        }
        sc.close();
        // display the students and find one with the lowest cgpa
        Student lowest = students[0];
        for(int i=0; i<n; i++) {
            students[i].display();
            if(students[i].getCGPA() < lowest.getCGPA()) lowest = students[i];
        }
        // display the lowest student name
        System.out.println("Lowest CGPA: "+lowest.getName());
    }
}
