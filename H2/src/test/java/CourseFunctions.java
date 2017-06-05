import org.junit.Assert;
import org.junit.Test;
import studentManagement.Course;
import studentManagementConn.CourseController;

public class CourseFunctions {

    @Test
    public void createAndReadCourse(){
        CourseController courseController = new CourseController();
        courseController.createCourse(new Course("Test12", "Test12", 12));
        Course courseObj = courseController.readCourse("Test12");
        boolean flag = (courseObj != null);
        Assert.assertTrue(flag);
    }

    @Test
    public void alterCourse(){
        CourseController courseController = new CourseController();
        courseController.createCourse(new Course("Test13", "Test13", 13));
        courseController.updateCourse("Test13", new Course("Test14", "Test14", 14));
        Course courseObj = courseController.readCourse("Test14");
        boolean flag = (courseObj != null);
        Assert.assertTrue(flag);
    }

    @Test
    public void deleteCourse(){
        CourseController courseController = new CourseController();
        courseController.createCourse(new Course("Test16", "Test16", 16));
        courseController.deleteCourse("Test16");
        Course courseObj = courseController.readCourse("Test16");
        boolean flag = (courseObj != null);
        Assert.assertFalse(flag);
    }


}
