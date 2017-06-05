package main;

import studentManagement.Course;
import studentManagement.Student;
import studentManagementConn.CourseController;
import studentManagementConn.StudentController;

import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args){
        System.out.println("Message");

        CourseController courseController = new CourseController();
        StudentController studentController = new StudentController();

        //courseController.createCourse(new Course("Test", "Test", 12));
        //studentController.createStudent(new Student("Dummy", new Date(), "Address"));
        List<Student> students = studentController.selectStudentsFromCourse("Test");

        System.out.println(students.toString());
    }

}
