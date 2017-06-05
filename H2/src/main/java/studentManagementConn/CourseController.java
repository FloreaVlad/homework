package studentManagementConn;

import connection.SQLconn;
import studentManagement.Course;

import java.sql.ResultSet;
import java.sql.Statement;

public class CourseController {

    private SQLconn connCourse = new SQLconn();
    private Statement statement;

    public void createCourse(Course course){
        try{
            statement = connCourse.getConn().createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }

        String sqlStatement = "INSERT INTO course (course_name, teacher, study_year) VALUES('" + course.getCourse_name() + "','"
                 + course.getTeacher() + "'," + course.getStudy_year() + ");";

        try{
            statement.execute(sqlStatement);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void updateCourse(String courseName, Course course){

        try {
            statement = connCourse.getConn().createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sqlStatement = "UPDATE course SET course_name = '" + course.getCourse_name() + "', "
                + "teacher = '" + "'," + "study_year = '" + course.getStudy_year() +"' WHERE course_name = '" + courseName +"'";

        try{
            statement.execute(sqlStatement);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void deleteCourse(String courseName){
        try {
            statement = connCourse.getConn().createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sqlStatement = "DELETE FROM course WHERE course_name= '" + courseName + "'";

        try{
            statement.execute(sqlStatement);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public Course readCourse(String courseName) {
        Course course = null;
        try {
            statement = connCourse.getConn().createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sqlStatement = "SELECT course_name,teacher,study_year FROM course WHERE course_name = '" + courseName + "'";

        try {
            ResultSet rs = statement.executeQuery(sqlStatement);
            while(rs.next()){
                course = new Course(rs.getString("course_name"), rs.getString("teacher"), rs.getInt("study_year"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            course = null;
        }
        return course;
    }
}
