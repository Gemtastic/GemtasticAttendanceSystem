/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.gemtastic.attendancesystem.services.CRUDservices.CourseEJBService;
import com.gemtastic.attendancesystem.services.CRUDservices.EmployeeEJBService;
import com.gemtastic.attendancesystem.services.CRUDservices.LectureEJBService;
import com.gemtastic.attendancesystem.services.CRUDservices.PositionEJBService;
import com.gemtastic.attendancesystem.services.CRUDservices.StudentEJBService;
import com.gemtastic.attendancesystem.services.CRUDservices.UserEJBService;
import com.gemtastic.attendancesystem.services.CRUDservices.UserTypeEJBService;
import com.gemtastic.attendencesystem.enteties.Courses;
import com.gemtastic.attendencesystem.enteties.Employees;
import com.gemtastic.attendencesystem.enteties.Lectures;
import com.gemtastic.attendencesystem.enteties.Position;
import com.gemtastic.attendencesystem.enteties.Students;
import com.gemtastic.attendencesystem.enteties.UserTypes;
import com.gemtastic.attendencesystem.enteties.Users;
import java.io.File;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Gemtastic
 */
public class TestCruds {

    public TestCruds() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCRUD() throws Exception {

        Map<String, Object> properties = new HashMap<>();
        properties.put(EJBContainer.MODULES, new File("target/classes"));

        try (EJBContainer ec = EJBContainer.createEJBContainer(properties)) {
            Context ctx = ec.getContext();
            
            
            
            List<Students> sList = new ArrayList<>();
            List<Employees> eList = new ArrayList<>();
            List<Courses> cList = new ArrayList<>();
            List<Lectures> lList = new ArrayList<>();

            CourseEJBService cCRUD = new CourseEJBService();
            EmployeeEJBService eCRUD = new EmployeeEJBService();
            LectureEJBService lCRUD = new LectureEJBService();
            PositionEJBService pCRUD = new PositionEJBService();
            StudentEJBService sCRUD = new StudentEJBService();
            UserTypeEJBService utCRUD = new UserTypeEJBService();
            UserEJBService uCRUD = new UserEJBService();

            Position position = new Position();
            position.setName("test");

            Students student = new Students();
            student.setEmail("test@test.com");
            student.setFirstname("Herp");
            student.setLastname("Derp");
            student.setPhone(0000000000);
            student.setRegDate(Date.valueOf(LocalDate.of(2015, 8, 01)));
            student.setSocSecNo(000000000000);

            UserTypes ut = new UserTypes();
            ut.setName("test");

            Employees employee = new Employees();
            employee.setEmail("test@test.com");
            employee.setFirstname("Derpelina");
            employee.setHireDate(Date.valueOf(LocalDate.of(2015, 8, 01)));
            employee.setLastname("Derpsson");
            employee.setPosition(position);

            Users user = new Users();
            user.setEmail("test@test.com");
            user.setEmployee(employee);
            user.setPassword("test");
            user.setType(ut);
            user.setUsername("test");

            Courses course = new Courses();
            course.setName("Test");
            course.setPoints(0);
            course.setStart(Date.valueOf(LocalDate.of(2015, 8, 01)));
            course.setStop(Date.valueOf(LocalDate.of(2015, 12, 01)));
            course.setTeacher(employee);
            course.setId(4);
            course.setStudentsList(sList);
            course.setLecturesList(lList);

            Lectures lecture = new Lectures();
            lecture.setCourse(course);
            lecture.setDate(Date.valueOf(LocalDate.of(2015, 8, 01)));
            lecture.setStart(Date.valueOf(LocalDate.of(2015, 8, 01)));
            lecture.setStop(Date.valueOf(LocalDate.of(2015, 8, 01)));

            // Test upsertion and find all
            assertNotNull(cCRUD.upsert(course));
            List<Courses> allCourses = cCRUD.findAll();
            assertNotNull(allCourses);
            assertEquals(1, allCourses.size());

            // Test find one
            Courses dbCourse = allCourses.get(0);
            Courses result = cCRUD.readOne(dbCourse);
            assertNotNull(result);

            //Test delete
            cCRUD.delete(result);
            assertNull(cCRUD.readOne(result));
        }
    }
}
