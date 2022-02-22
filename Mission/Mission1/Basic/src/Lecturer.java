/**
 * @author D0Loop
 * @since 2022-02-02 [2022.2월.02]
 */

public class Lecturer extends AbstractPerson {

    public static Person of(String name, int age) {
        return new Lecturer(name, age, Job.LECTURER);
    }

    private Lecturer(String name, int age, Job job) {
        super(name, age, job);
    }
}
