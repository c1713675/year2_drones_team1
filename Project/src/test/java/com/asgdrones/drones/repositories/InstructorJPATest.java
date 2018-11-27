package com.asgdrones.drones.repositories;

import com.asgdrones.drones.domain.Instructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
@AutoConfigureTestDatabase
public class InstructorJPATest {
    @Autowired
    private InstructorRepoJPA instructorRepoJPA;

    @Test
    public void testFindByUsername(){
        Integer instructorID = this.instructorRepoJPA.findByUsername("hfitch3").get(0);

        assertEquals((long) instructorID, 4);
    }
}
