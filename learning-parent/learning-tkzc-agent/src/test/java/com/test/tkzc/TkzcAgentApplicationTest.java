package com.test.tkzc;

import com.learning.TkzcAgentApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * SpringBoot的测试环境启动类
 *
 * @author tangjx
 * @date 2020/8/10 17:57
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TkzcAgentApplication.class)
public class TkzcAgentApplicationTest {


    @Test
    public void test01() {
        System.out.println("测试中......");
    }

}
