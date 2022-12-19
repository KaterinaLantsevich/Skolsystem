import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        ArrayList<Student> studentsList = new ArrayList<>();
        Student student = null;
        Path p1 = Paths.get("src/courses.txt");
        Path p2 = Paths.get("src/students.txt");
        Set<Course> requiredPrerequisites = new HashSet<>();
        requiredPrerequisites.add(new Course("Svenska 1", "SVE1"));
        requiredPrerequisites.add(new Course("Engelska 1", "ENG1"));
        requiredPrerequisites.add(new Course("Matematik 1", "MAT1"));
        School school = new School("GroupThreeAcademy", "GroupThreeStreet", p1, p2 , requiredPrerequisites);
        schoolSystem schoolSystem = new schoolSystem(school);
        int option = 0;
        String menuMessage = """
                WELCOME!\s
                1. REGISTER AS STUDENT
                2. GO TO COURSE CATALOGUE
                3. APPLY FOR COURSE
                4. ABOUT THE SCHOOL
                5. EXIT PROGRAM""";
        Scanner scan = new Scanner(System.in);
        System.out.println(school);
        do
        {
            System.out.println(menuMessage);
            option = scan.nextInt();
            try
            {
                switch (option){
                    case 1:
                        if(student != null){
                            System.out.println("You have already registered!");
                        }
                        else{
                            student = schoolSystem.registerStudent();
                            studentsList = read(p2);
                            studentsList.add(student);
                            write(p2, studentsList);
                            System.out.println(school);
                        }
                        break;
                    case 2:
                        schoolSystem.showCourseCatalogue();
                        break;
                    case 3:
                        if(student != null){
                            schoolSystem.enterCourseToApply(student);
                        }
                        else {
                            System.out.println("You need to register as a student!");
                        }
                        break;
                    case 4:
                        System.out.println(school);
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
        } while (option != 5);
        /*
        SchoolStuffFactory schoolStuffFactory = new SchoolStuffFactory();
        SchoolStuff schoolStuff1 = schoolStuffFactory.getSchoolStuff("Teacher");
        schoolStuff1.printOut();
        SchoolStuff schoolStuff2 = schoolStuffFactory.getSchoolStuff("Administration");
        schoolStuff2.printOut();
        SchoolStuff schoolStuff3 = schoolStuffFactory.getSchoolStuff("Coordinator");
        schoolStuff3.printOut();

         */

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

    static void write(Path path, ArrayList<Student> studentList) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(String.valueOf(path)))) {
            oos.writeObject(studentList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}