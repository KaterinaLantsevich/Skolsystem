public class StudentFactory {

    public Student getStudent(String studentType) {
        if(studentType == null){
            return null;
        }
        if(studentType.equalsIgnoreCase("SCHOOL")) {
            return new AtSchoolStudent();
        } else if(studentType.equalsIgnoreCase("DISTANCE")) {
            return new DistanceStudent();
        }
        return null;
    }
}
