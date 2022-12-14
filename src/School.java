import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class School implements Serializable
{
    String schoolName;
    String adress;
    //ArrayList<Course> courses;
    Set<Course> courses;
    ArrayList<Student> students;
    Set<Course> requiredPrerequisites;
    School(String name, String adress, Path p1, Path p2, Path preReq){
        this.schoolName = name;
        this.adress = adress;
        this.courses = new HashSet<>();
        this.students = new ArrayList<>();
        this.requiredPrerequisites = new HashSet<>();
        readRequiredPrerequisites(preReq);
        readCourses(p1);
        readStudents(p2);
    }

    public void readStudents(Path p){
        try(ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(String.valueOf(p))
        )){
            this.students = (ArrayList<Student>) ois.readObject();
        }
        catch (EOFException e) {
            // End of file reached, exit the loop
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        }

    public void readRequiredPrerequisites(Path p){
        Course course;
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
                courseName = courseInfo[0].strip().toUpperCase();
                courseCode = courseInfo[1].strip().toUpperCase();
                course = new Course(courseName, courseCode);
                addPrerequisite(course);
            }

        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }
    public void readCourses(Path p){
        Course course;
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
                courseName = courseInfo[0].strip().toUpperCase();
                courseCode = courseInfo[1].strip().toUpperCase();
                course = new Course(courseName, courseCode);
                course.setRequiredPrerequisites(this.requiredPrerequisites);
                addCourse(course);
            }

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void addCourse(Course course){
        this.courses.add(course);
    }
    public void addPrerequisite(Course preRequisite){
        this.requiredPrerequisites.add(preRequisite);
    }

    public void addStudent(Student student){
        this.students.add(student);
    }

    @Override
    public String toString()
    {
        return "School{" +
                "schoolName='" + schoolName + '\'' +
                ", adress='" + adress + '\'' +
                ", courses=" + courses +
                ", students=" + students +
                ", requiredPrerequisites=" + requiredPrerequisites +
                '}';
    }
}
