package studentManagementConn;

import connection.SQLconn;
import studentManagement.Student;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentController {

    SQLconn connStudent = new SQLconn();


    public void createStudent(Student student){
        Statement statement = null;
        try{
            statement = connStudent.getConn().createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }

        String sqlStatement = "INSERT INTO student (stud_name, birth_date, address)" +
                        "VALUES ('"+ student.getStud_name() + "','" + student.getBirth_date() + "','" + student.getAddress() +"');";

        try{
            statement.execute(sqlStatement);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void deleteStudent(String studentName){
        Statement statement = null;
        try{
            statement = connStudent.getConn().createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }

        String sqlStatement = "DELETE FROM student WHERE stud_name ='" + studentName + "';";

        try{
            statement.execute(sqlStatement);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void updateStudent(String studentName, Student student){
        Statement statement = null;
        try{
            statement = connStudent.getConn().createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }

        String sqlStatement = "UPDATE student SET stud_name='" + student.getStud_name() + "',birth_date = '"
                + student.getBirth_date() + "', address = '" + student.getAddress() + "' WHERE stud_name ='" + studentName + "';";

        try{
            statement.execute(sqlStatement);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public Student readStudent(String studentName){
        Statement statement = null;
        Student student = null;
        try{
            statement = connStudent.getConn().createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }

        String sqlStatement = "SELECT stud_name,birth_date,address FROM student WHERE stud_name = '" + studentName + "';";

        try {
            ResultSet rs = statement.executeQuery(sqlStatement);
            while(rs.next()){
                student = new Student(rs.getString("stud_name"), rs.getDate("birth_date"), rs.getString("address"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return student;
    }

    public void insertStudentToCourse(String studentName, String courseName){
        Statement statement = null;
        try{
            statement = connStudent.getConn().createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }

        String sqlStatement = "INSERT INTO course_enroll (student_id, course_id) " +
                "VALUES ((SELECT student_id FROM student WHERE stud_name ='" + studentName + "'),(" +
                "SELECT course_id FROM course WHERE course_name = '" + courseName + "'));";

        try{
            statement.execute(sqlStatement);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Student> selectStudentsFromCourse(String courseName){
        List<Student> students = new ArrayList<Student>();

        Statement statement = null;
        try{
            statement = connStudent.getConn().createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }

        String sqlStatement = "SELECT student_name,birth_date,address FROM student JOIN course_enroll ce" +
                "ON student.student_id = ce.student_id  WHERE ce.course_id = (SELECT course_id FROM course WHERE course_name = '" + courseName + "')";

        try{
            ResultSet rs = statement.executeQuery(sqlStatement);
            while(rs.next()){
                Student student = new Student(rs.getString("student_name"), rs.getDate("birth_date"), rs.getString("address"));
                students.add(student);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return students;
    }
}
