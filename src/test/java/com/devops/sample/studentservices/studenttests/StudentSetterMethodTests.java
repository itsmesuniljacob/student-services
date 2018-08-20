package com.devops.sample.studentservices.studenttests;

import com.devops.sample.studentservices.topic.Topic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class StudentSetterMethodTests {

    @Test
    public void testSetId() {
        Topic topic = new Topic();
        topic.setId("Spring");
        assertTrue(topic.getId()=="Spring");
    }
}
