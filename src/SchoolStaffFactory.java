public class SchoolStaffFactory {


    public SchoolStaff getSchoolStuff(String schoolStuffType) {
        if (schoolStuffType == null) {
            return null;
        }
        if (schoolStuffType.equalsIgnoreCase("TEACHER")) {
            return new Teacher();
        } else if (schoolStuffType.equalsIgnoreCase("ADMINISTRATION")) {
            return new Administration();
        } else if (schoolStuffType.equalsIgnoreCase("COORDINATOR")) {
            return new StudiesCoordinator();
        }

        return null;
    }
}
