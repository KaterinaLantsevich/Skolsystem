import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class AtSchoolStudent implements Student, Serializable
{
    String nameOfStudent;
    long idNumber;
    School school;
    Set<Course> currentCourses;
    ArrayList<Course> coursesTaken;


    AtSchoolStudent(){
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
    public void setId(long id)
    {
        this.idNumber = id;
    }

    @Override
    public void studentRegistration() {
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
