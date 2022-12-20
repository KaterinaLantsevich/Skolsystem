import java.io.Serializable;
import java.util.*;

public class DistanceStudent implements Student, Serializable
{

    String nameOfStudent;
    long idNumber;
    School school;
    Set<Course> currentCourses;
    ArrayList<Course> coursesTaken;

    DistanceStudent(){
        this.currentCourses = new HashSet<>();
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
    public String getName()
    {
        return this.nameOfStudent;
    }

    @Override
    public long getID()
    {
        return this.idNumber;
    }

    @Override
    public void setId(long id)
    {
        this.idNumber = id;
    }

    @Override
    public void studentRegistration() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scan.nextLine();
        System.out.println("Enter your id: ");
        long id = scan.nextLong();
        scan.nextLine();
        this.setName(name);
        this.setId(id);
        System.out.println("CHOOSE STUDY-RATE: FULL TIME/PART-TIME");
        String studyRate = scan.nextLine();
        System.out.println("YOU CHOSE: " + studyRate);
        school.addStudent(this);
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

    @Override
    public Set<Course> getCurrentCourses()
    {
        return this.currentCourses;
    }
}
