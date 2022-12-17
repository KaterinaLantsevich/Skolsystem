import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Course {

    //File file = new File("Courses.txt");
    //Map<Integer,String> courseMap = new HashMap<>();
    String courseCode;
    String courseName;


    Course(String name, String code){
        this.courseName = name;
        this.courseCode = code;
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
