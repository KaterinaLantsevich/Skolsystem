import java.util.ArrayList;
import java.util.Scanner;

public class schoolSystem
{
    School school;
    schoolSystem(School s){
        this.school = s;
    }
    public Student registerStudent()
    {
        Scanner scan = new Scanner(System.in);
        StudentFactory studentFactory = new StudentFactory();
        System.out.println("Enter your name: ");
        String name = scan.nextLine();
        System.out.println("Enter your id: ");
        long id = scan.nextLong();
        scan.nextLine();
        System.out.println("Choose category: DISTANCE/SCHOOL");
        String category = scan.nextLine();
        Student student = studentFactory.getStudent(category);
        student.setName(name);
        student.setId(id);
        student.setSchoolForStudent(this.school);
        student.studentRegistration();
        return student;

    }

    public void showCourseCatalogue(){
        ArrayList<Course> courses = this.school.courses;
        for (Course c : courses){
            System.out.println(c);
        }
    }

    public void applyForCourse(Course course, Student student){
        student.addCourse(course);
        System.out.println("Course was added!");
    }

    public void enterCourseToApply(Student student)
    {
        String courseInfo;
        Scanner scan = new Scanner(System.in);

        while (true){
            System.out.println("What course do you want to apply to? (ENTER EXIT TO GO BACK TO MENU)");
            courseInfo = scan.nextLine();
            if(courseInfo.equalsIgnoreCase("EXIT")){
                return;
            }
            for (Course c : this.school.courses){
                if(c.getCourseCode().equalsIgnoreCase(courseInfo.strip()) || c.getCourseName().equalsIgnoreCase(courseInfo.strip())){
                    System.out.println("The course was found!");
                    applyForCourse(c, student);
                    return;
                }
            }
            System.out.println("The course you entered is not in the course catalogue!");
        }


    }
}
