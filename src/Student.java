import java.util.ArrayList;
import java.util.Set;

public interface Student {
    void setSchoolForStudent(School school);
    void setName(String name);
    String getName();
    long getID();
    void setId(long id);
    void studentRegistration();
    void addCourse(Course course);
    void finishCourse(Course course);
    Set<Course> getCurrentCourses();
}
