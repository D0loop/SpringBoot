/**
 * @author D0Loop
 * @since 2022-02-02 [2022.2월.02]
 */

public class Student extends AbstractPerson {

    public static Person of(String name, int age) {
        return new Student(name, age, Job.STUDENT);
    }

    private Student(String name, int age, Job job) {
        super(name, age, job);
    }
}
