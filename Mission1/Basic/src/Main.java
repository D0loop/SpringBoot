/**
 * @author D0Loop
 * @since 2022-02-02 [2022.2월.02]
 */

public class Main {

    public static void main(String[] args) {

        Person student = Student.of("박수덕", 32);
        Person lecturer = Lecturer.of("박지호", 0);

        student.speak();
        lecturer.speak();
    }
}
