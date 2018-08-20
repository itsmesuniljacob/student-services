package com.devops.sample.studentservices.studenttests;

import com.devops.sample.studentservices.StudentServicesApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class StudentMainApplicationTests {

    @Test
    public void ApplicationStart() {
        StudentServicesApplication.main(new String[] {});

    }
}
