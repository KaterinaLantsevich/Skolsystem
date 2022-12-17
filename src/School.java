import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class School
{
    String schoolName;
    String adress;
    ArrayList<Course> courses;
    ArrayList<Student> students;

    School(String name, String adress, Path p1, Path p2){
        this.schoolName = name;
        this.adress = adress;
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
        getCourses(p1);
        getStudents(p2);
    }

    public void getStudents(Path p){
        StudentFactory factory = new StudentFactory();
        String id;
        String studentName;
        String studentType;
        String tempLine = "";
        String[] studentInfo = new String[2];
        try (FileReader fr = new FileReader(String.valueOf(p));
             BufferedReader br = new BufferedReader(fr))
        {
            while ((tempLine = br.readLine()) != null)
            {
                studentInfo = tempLine.split(",");
                id = studentInfo[0].strip();
                studentName = studentInfo[1].strip();
                studentType = studentInfo[2].strip();
                Student student = factory.getStudent(studentType);
                if (student == null){
                    System.out.println("Något fel med studentType");
                }
                else {
                    student.setName(studentName);
                    student.setId(Long.parseLong(id));
                    addStudent(student);
                }
            }


        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void getCourses(Path p){
        String courseName;
        String courseCode;
        String tempLine = "";
        String[] courseInfo = new String[2];
        try (FileReader fr = new FileReader(String.valueOf(p));
             BufferedReader br = new BufferedReader(fr))
        {
            while ((tempLine = br.readLine()) != null)
            {
                courseInfo = tempLine.split(",");
                courseName = courseInfo[0];
                courseCode = courseInfo[1];
                addCourse(new Course(courseName, courseCode));
            }

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void addCourse(Course course){
        this.courses.add(course);
    }

    public void addStudent(Student student){
        this.students.add(student);
    }
}
