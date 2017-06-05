import org.junit.Assert;
import org.junit.Test;
import studentManagement.Student;
import studentManagementConn.StudentController;

import java.util.Date;

public class StudentFunctions {

    @Test
    public void createAndReadStudent(){
        StudentController studentController = new StudentController();
        studentController.createStudent(new Student("TestName", new Date(), "TestAddress"));
        Student studentObj = studentController.readStudent("TestName");
        boolean flag = (studentObj != null);
        Assert.assertTrue(flag);
    }

    @Test
    public void alterStudent(){
        StudentController studentController = new StudentController();
        studentController.createStudent(new Student("TestName1", new Date(), "TestAddress1"));
        studentController.updateStudent("TestName1", new Student("TestName2", new Date(), "TestAddress2"));
        Student studentObj = studentController.readStudent("TestName2");
        boolean flag = (studentObj != null);
        Assert.assertTrue(flag);
    }

    @Test
    public void deleteStudent(){
        StudentController studentController = new StudentController();
        studentController.createStudent(new Student("TestName3", new Date(), "TestAddress3"));
        studentController.deleteStudent("TestName3");
        Student studentObj = studentController.readStudent("TestName3");
        boolean flag = (studentObj != null);
        Assert.assertFalse(flag);
    }
}
