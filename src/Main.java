import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        Path p1 = Paths.get("src/courses.txt");
        Path p2 = Paths.get("src/students.txt");
        Path p3 = Paths.get("src/reqCourses.txt");
        School school = new School("GroupThreeAcademy", "GroupThreeStreet", p1, p2 , p3);
        schoolSystem schoolSystem = new schoolSystem(school);
        Student student = schoolSystem.welcomeMenu(p2);
        int option = 0;
        String menuMessage = """
                \s
                1. ABOUT THE SCHOOL
                2. GO TO COURSE CATALOGUE
                3. APPLY FOR COURSE
                4. SHOW MY COURSES
                5. EXIT PROGRAM""";
        Scanner scan = new Scanner(System.in);
        do
        {
            System.out.println(menuMessage);
            option = scan.nextInt();
            try
            {
                switch (option)
                {
                    case 1 -> System.out.println(school);
                    case 2 -> schoolSystem.showCourseCatalogue();
                    case 3 -> schoolSystem.enterCourseToApply(student, p2);
                    case 4 -> printCatalogueSet(student.getCurrentCourses());
                    case 5 -> System.out.println("GOODBYE!");
                    default -> System.out.println("Please choose one of the options!");
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
    private static void printCatalogueSet(Set<Course> courses){
        System.out.println("These are the courses you have applied to :");
        for (Course c : courses){
            System.out.println(" - " + c.courseName + " (" + c.courseCode + ")");
        }
    }
}