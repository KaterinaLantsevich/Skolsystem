import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DistanceStudent implements Student {
    @Override
    public void studentRegistration() {
        String nameOfStudent;
        int idNumber;
        Map<Integer,String> studentMap = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your first and last name: "); //TODO her v main
        while (scan.hasNextLine()) {
            nameOfStudent = scan.nextLine();
            System.out.println("Enter your ID: ");
            if (scan.hasNextInt()) {
                idNumber = scan.nextInt();
                //studentMap.put(idNumber,nameOfStudent);
                System.out.println("You have been successfully registered");
                break;
            } else {
                System.out.println("You made mistake");
                scan.next();
                studentRegistration();
            }
        }
    }
}
