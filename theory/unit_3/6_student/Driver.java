import java.util.ArrayList;
import java.util.Scanner;

class Course {
    private String ID, name, prerequisite, description;
    private enum type { lab, theory };
    private type courseType;
    private int credits, units;

    public String __ID__() {
        return ID;
    }

    public void input(Scanner reader) {
        System.out.print("ID: "); ID = reader.next(); reader.nextLine();
        System.out.print("Name: "); name = reader.nextLine();
        System.out.print("Prerequisite: "); prerequisite = reader.nextLine();
        System.out.print("Description: "); description = reader.nextLine();
        System.out.print("Credits: "); credits = reader.nextInt();
        System.out.print("Units: "); units = reader.nextInt();
        System.out.println("Lab ? (Y/N)"); char lab = reader.next().charAt(0);
        if(lab == 'y' || lab=='Y') courseType=type.lab;
        else courseType = type.theory;
    }

    public void show() {
        System.out.println("----COURSE ID: "+ID+"----");
        System.out.println("Name: "+name);
        System.out.println("Type: "+courseType);
        System.out.println("Prerequisite:" + prerequisite);
        System.out.println("Description: "+description);
        System.out.println("Credits: "+credits);
        System.out.println("Units: "+units);
    }
}

class Student {
    private String name, grade;
    private ArrayList<Course> courses = new ArrayList<Course>();

    public Student(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }

    public void show() {
        System.out.println("----STUDENT----");
        System.out.println("Name: "+name);
        System.out.println("Grade: "+grade.toUpperCase());
        for(Course course: courses) course.show();
    }

    public void addCourse(Scanner reader) {
        Course course = new Course();
        course.input(reader);
        courses.add(course);
    }

    public void delCourse(String ID) {
        for(Course course: courses)
            if(course.__ID__() == ID) courses.remove(course);
    }
}

public class Driver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student student = new Student("Akash", "O");
        student.addCourse(sc);
        student.addCourse(sc);
        student.show();
        student.delCourse("EC20001");
        student.show();
    }
}
