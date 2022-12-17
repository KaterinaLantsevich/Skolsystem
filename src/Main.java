import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        StudentFactory studentFactory = new StudentFactory();
        Student schoolStudent = studentFactory.getStudent("SCHOOL");
        Student distanceStudent = studentFactory.getStudent("DISTANCE");

        System.out.println("Choose category: DISTANCE/SCHOOL");
        String category = scan.nextLine();
        if(category.equalsIgnoreCase("SCHOOL")) {
            schoolStudent.studentRegistration();
        }else if(category.equalsIgnoreCase("DISTANCE")) {
            distanceStudent.studentRegistration();
        }



        SchoolStuffFactory schoolStuffFactory = new SchoolStuffFactory();
        SchoolStuff schoolStuff1 = schoolStuffFactory.getSchoolStuff("Teacher");
        schoolStuff1.printOut();
        SchoolStuff schoolStuff2 = schoolStuffFactory.getSchoolStuff("Administration");
        schoolStuff2.printOut();
        SchoolStuff schoolStuff3 = schoolStuffFactory.getSchoolStuff("Coordinator");
        schoolStuff3.printOut();

    }
}