import java.util.Scanner;

public class AtSchoolStudent implements Student{
    /*private String firstName;
    private String lastName;
    private String idNumber;*/



    @Override
    public void studentRegistration() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your first name: ");
        String firstName = scan.nextLine();
        System.out.println("Enter your last name: ");
        String lastName = scan.nextLine();
        System.out.println("Enter your ID: ");
        String idNumber = scan.nextLine();
    }
}
