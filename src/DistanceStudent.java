import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DistanceStudent implements Student, Serializable
{

    String nameOfStudent;
    long idNumber;
    School school;
    ArrayList<Course> currentCourses;
    ArrayList<Course> coursesTaken;

    DistanceStudent(){
        this.currentCourses = new ArrayList<>();
        this.coursesTaken = new ArrayList<>();
    }
    @Override
    public void setSchoolForStudent(School school)
    {
        this.school = school;
    }

    @Override
    public void setName(String name)
    {
        this.nameOfStudent = name;
    }

    @Override
    public void setId(long id)
    {
        this.idNumber = id;
    }

    @Override
    public void studentRegistration() {
        school.addStudent(this);
        /*
        Map<Integer,String> studentMap = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your first and last name: ");
        while (scan.hasNextLine()) {
            nameOfStudent = scan.nextLine();
            System.out.println("Enter your ID: ");
            if (scan.hasNextInt()) {
                idNumber = scan.nextInt();
                //studentMap.put(idNumber,nameOfStudent);
                System.out.println("You have been successfully registered");
                break;
            } else {
                System.out.println("You made mistake");
                scan.next();
                studentRegistration();
            }
        }

         */
    }

    @Override
    public void addCourse(Course course)
    {
        this.currentCourses.add(course);
    }

    @Override
    public void finishCourse(Course course)
    {
        for(Course c : this.currentCourses){
            if(c == course){
                this.currentCourses.remove(c);
                this.coursesTaken.add(course);
                return;
            }
        }
        System.out.println("Something went wrong in finishCourse");

    }
}
