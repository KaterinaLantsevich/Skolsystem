import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Path p1 = Paths.get("src/courses.txt");
        Path p2 = Paths.get("src/students.txt");
        School school = new School("GroupThreeAcademy", "GroupThreeStreet", p1, p2);
        schoolSystem schoolSystem = new schoolSystem(school);
        int option;
        String menuMessage = """
                WELCOME!\s
                1. REGISTER AS STUDENT
                2. GO TO COURSE CATALOGUE
                3. APPLY FOR COURSE
                4. EXIT PROGRAM""";
        Scanner scan = new Scanner(System.in);
        do
        {
            System.out.println(menuMessage);
            option = scan.nextInt();
            if(option == 1){
                schoolSystem.registerStudent();
            }
            else if(option == 2){
                schoolSystem.showCourseCatalogue();
            }
            else if(option == 3){
                // TODO kolla ifall studenten är behörig till kursen och lägg isåfall till kursen
                System.out.println("OKEJDÅ");
            }
        } while (option != 4);

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
}