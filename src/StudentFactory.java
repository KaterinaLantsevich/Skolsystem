public class StudentFactory {

    public Student getStudent(String studentType) {
        if(studentType.equalsIgnoreCase("SCHOOL"))
            return new AtSchoolStudent();
        if(studentType.equalsIgnoreCase("DISTANCE"))
            return new DistanceStudent();
        return null;
    }
}
