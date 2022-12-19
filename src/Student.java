public interface Student {
    void setSchoolForStudent(School school);
    void setName(String name);
    void setId(long id);
    void studentRegistration();
    void addCourse(Course course);
    void finishCourse(Course course);
}
