/**
 * @author D0Loop
 * @since 2022-02-02 [2022.2월.02]
 */

public enum Job {
    STUDENT("학생"), LECTURER("강사");

    private String title;

    Job(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
