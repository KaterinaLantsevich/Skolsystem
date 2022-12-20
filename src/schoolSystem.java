import java.io.*;
import java.nio.file.Path;
import java.util.*;

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
        System.out.println("Choose category: DISTANCE/SCHOOL");
        String category = scan.nextLine();
        Student student = studentFactory.getStudent(category);
        student.setSchoolForStudent(this.school);
        student.studentRegistration();
        return student;

    }

    public void showCourseCatalogue(){
        Set<Course> courses = this.school.courses;
        System.out.println("These are the courses " + this.school.schoolName + " offers: ");
        for (Course c : courses){
            System.out.println(" - " + c.courseName + " (" + c.courseCode + ")");
        }
    }

    public void applyForCourse(Course course, Student student, Path p){
        Set<Course> courses = student.getCurrentCourses();
        Set<String> courseIds = new HashSet<>();
        Set<Course> reqCourses = this.school.requiredPrerequisites;
        Set<Course> coursesToComplete = new HashSet<>();

        for(Course c : courses){
            courseIds.add(c.courseCode);
        }

        for(Course reqCourse: reqCourses){
            // kolla om kursen de har sökt är en av de kurser som kan läsas av vem som helst
            if(course.courseCode.equalsIgnoreCase(reqCourse.courseCode)){
                student.addCourse(course);
                updateStudent(student, p);
                System.out.println("Course was added!");
                return;
            }
            else if(!courseIds.contains(reqCourse.courseCode)){
                coursesToComplete.add(reqCourse);
            }
        }
        if(coursesToComplete.isEmpty()){
            student.addCourse(course);
            updateStudent(student, p);
            System.out.println("Course was added!");
        }
        else {
            System.out.println("You are missing the following courses: ");
            for(Course c : coursesToComplete){
                System.out.println(c);
            }
        }
    }

    public void enterCourseToApply(Student student, Path p)
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
                    applyForCourse(c, student, p);
                    return;
                }
            }
            System.out.println("The course you entered is not in the course catalogue!");
        }


    }

    public Student welcomeMenu(Path studentsFilePath)
    {
        ArrayList<Student> studentsList = new ArrayList<>();
        Student student = null;
        String name = "";
        long id;
        int option = 0;
        String menuMessage = """
                WELCOME!\s
                1. LOG IN AS STUDENT
                2. SIGN UP AS STUDENT
                3. EXIT PROGRAM""";
        Scanner scan = new Scanner(System.in);
        do
        {
            System.out.println(menuMessage);
            option = scan.nextInt();
            try
            {
                switch (option){
                    case 1:
                        while(true){
                            studentsList = read(studentsFilePath);
                            scan.nextLine();
                            System.out.println("Enter your name: (ENTER EXIT TO GO BACK TO MENU)");
                            name = scan.nextLine();
                            System.out.println(name);
                            if(name.equalsIgnoreCase("EXIT")){
                                break;
                            }
                            System.out.println("Enter your id: ");
                            id = scan.nextLong();
                            System.out.println(id);
                            for(Student s : studentsList){
                                if(s.getName().equalsIgnoreCase(name) && s.getID() == id){
                                    System.out.println("LOG IN SUCCESSFUL");
                                    return s;
                                }
                            }
                            System.out.println("The name or id you entered is not registered as a student.");
                        }
                        break;
                    case 2:
                        if(student != null){
                            System.out.println("You have already logged in!");
                        }
                        else{
                            student = registerStudent();
                            studentsList = read(studentsFilePath);
                            studentsList.add(student);
                            write(studentsFilePath, studentsList);
                            System.out.println(school);
                        }
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Please choose one of the options!");
                }
            }
            catch (NumberFormatException | InputMismatchException e){
                System.out.println("Please choose one of the options! ");
            } catch (Exception e){
                e.printStackTrace();
            }
        } while (option != 3);
        return student;
    }

    public static ArrayList<Student> read(Path p){
        ArrayList<Student> studentsList = new ArrayList<>();
        try(ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(String.valueOf(p))
        )){
            studentsList = (ArrayList<Student>) ois.readObject();
        }
        catch (EOFException e) {
            // End of file reached, exit the loop
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return studentsList;
    }

    public static void write(Path path, ArrayList<Student> studentList)
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(String.valueOf(path)))) {
            oos.writeObject(studentList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(Student student, Path p){
        int index = 0;
        ArrayList<Student> studentArrayList = read(p);
        for (Student s: studentArrayList){
            if(s.getName().equalsIgnoreCase(student.getName()) && s.getID() == student.getID()){
                studentArrayList.set(index, student);
                write(p, studentArrayList);
            }
            index ++;
        }
    }
}
