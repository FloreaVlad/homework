package studentManagement;

public class Course {

    private int course_id;

    private String course_name;

    private String teacher;

    private int study_year;

    public Course(String course_name, String teacher, int study_year){
        this.course_name = course_name;
        this.teacher = teacher;
        this.study_year = study_year;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getStudy_year() {
        return study_year;
    }

    public void setStudy_year(int study_year) {
        this.study_year = study_year;
    }
}
