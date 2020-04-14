package com.learning.tkzc.springboot;

import com.learning.tkzc.LearningTkzcAgentStart;
import com.learning.tkzc.config.TestProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LearningTkzcAgentStart.class)
public class MySpringBootTest {

    @Autowired
    private TestProperties testProperties;

    @Test
    public void test() {
        System.out.println(testProperties.getName());
        System.out.println(testProperties.getEnable());
    }

}
