class Course {
    private String course_name, instructor;
    private int credits;

    public Course(String course_name, String instructor, int credits) {
        this.course_name = course_name;
        this.instructor = instructor;
        this.credits = credits;
    }

    public void displayDetails() {
        System.out.println("Course name: "+course_name+
                            "\nInstructor: "+instructor+
                            "\nCredits: "+credits
        );
    }
}

class OnlineCourse extends Course {
    private String platform;
    private int duration;

    public OnlineCourse(String course_name, String instructor, int credits, String platform, int duration) {
        super(course_name, instructor, credits);
        this.platform = platform;
        this.duration = duration;
    }

    public boolean checkCertEligibility(int threshold) {
        return duration > threshold;
    }

    public void show() {
        displayDetails();
        System.out.println("Platform: "+platform+
                            "\nDuration: "+duration+" minutes"
        );
    }
}

public class Driver {
    public static void main(String[] args) {
        OnlineCourse course = new OnlineCourse("Object Oriented Programming in Java", "Dr. Rajat Kumar Behra", 3, "Google Meet", 180);
        course.show();
        if(course.checkCertEligibility(90)) System.out.println("Course eligible for certificate!");
        else System.out.println("Course not eligible for certificate.");
    }
}
