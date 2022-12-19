import java.io.File;
import java.io.Serializable;
import java.util.*;

public class Course implements Serializable
{

    //File file = new File("Courses.txt");
    //Map<Integer,String> courseMap = new HashMap<>();
    String courseCode;
    String courseName;
    Set<Course> requiredPrerequisites;



    Course(String name, String code){
        this.courseName = name;
        this.courseCode = code;
        this.requiredPrerequisites = new HashSet<>();
    }

    public String getCourseCode()
    {
        return courseCode;
    }

    public void setCourseCode(String courseCode)
    {
        this.courseCode = courseCode;
    }

    public String getCourseName()
    {
        return courseName;
    }

    public void setCourseName(String courseName)
    {
        this.courseName = courseName;
    }

    public Set<Course> getRequiredPrerequisites()
    {
        return requiredPrerequisites;
    }

    public void setRequiredPrerequisites(Set<Course> requiredPrerequisites)
    {
        this.requiredPrerequisites = requiredPrerequisites;
    }

    @Override
    public String toString()
    {
        return "Course{" +
                "courseCode='" + courseCode + '\'' +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
