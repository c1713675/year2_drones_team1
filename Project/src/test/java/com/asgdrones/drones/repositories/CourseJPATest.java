package com.asgdrones.drones.repositories;

import com.asgdrones.drones.domain.Address;
import com.asgdrones.drones.domain.Course;
import com.asgdrones.drones.domain.Instructor;
import com.asgdrones.drones.domain.Login;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@DirtiesContext
@AutoConfigureTestEntityManager
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CourseJPATest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private CourseRepoJPA courseRepoJPA;

    @Test
    public void CourseRepoTest(){
        Address address = new Address(1L,"CF244AN","Cardiff","Abby Lane",4,"");
        Login login = new Login(1L,"jbuckland","1234","customer");
        Instructor instructor = new Instructor(1L,"james","buckland","01895430027",login,address);
        Course course = new Course(1L,"Course1","Type2",instructor);
        this.entityManager.merge(course);
        List<Course> courseList = courseRepoJPA.findAll();
        assertThat(courseList.get(0).getCourseName()).isEqualTo("Course1");
        assertThat(courseList.get(0).getCourseType()).isEqualTo("Type2");
        assertThat(courseList.get(0).getInstructor()).isEqualTo(instructor);

    }
}
