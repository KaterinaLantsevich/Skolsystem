import java.util.ArrayList;
import java.util.Scanner;

public class schoolSystem
{
    School school;
    schoolSystem(School s){
        this.school = s;
    }
    public void registerStudent()
    {
        Scanner scan = new Scanner(System.in);
        StudentFactory studentFactory = new StudentFactory();
        /*
        Student schoolStudent = studentFactory.getStudent("SCHOOL");
        Student distanceStudent = studentFactory.getStudent("DISTANCE");
         */
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

    }

    public void showCourseCatalogue(){
        ArrayList<Course> courses = this.school.courses;
        for (Course c : courses){
            System.out.println(c);
        }
    }

}
