package studentManagement;

import java.util.Date;

public class Student {

    private int stud_id;

    private String stud_name;

    private Date birth_date;

    private String address;

    public Student(String stud_name, Date birth_date, String address) {
        this.stud_name = stud_name;
        this.birth_date = birth_date;
        this.address = address;
    }

    public int getStud_id() {
        return stud_id;
    }

    public void setStud_id(int stud_id) {
        this.stud_id = stud_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getStud_name() {
        return stud_name;
    }

    public void setStud_name(String stud_name) {
        this.stud_name = stud_name;
    }
}
