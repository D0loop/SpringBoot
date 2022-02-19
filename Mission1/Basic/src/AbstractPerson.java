/**
 * @author D0Loop
 * @since 2022-02-02 [2022.2월.02]
 */

public abstract class AbstractPerson implements Person {

    private String name;
    private int age;
    private Job job;

    public AbstractPerson(String name, int age, Job job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }

    @Override
    public void speak() {
        System.out.println(name + "은(는) " + job.getTitle() + " 입니다.");
    }
}
