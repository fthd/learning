package com.learning.tkzc.agent;

import com.learning.tkzc.boot.BootService;
import org.junit.Test;

import java.util.ServiceLoader;

public class JavaAgentTest {


    /**
     * 验证JavaAgent的premain机制
     */
    @Test
    public void test01() {
        System.out.println("正式代码执行中......");
    }


    /**
     * 测试Java SPI机制
     * 该机制用途广泛，数据库驱动也采用该机制实现
     * 好处：无需修改代码就可以实现类的切换
     */
    @Test
    public void test02() {
        ServiceLoader<BootService> serviceLoader = ServiceLoader.load(BootService.class);
        for (BootService bootService : serviceLoader) {
            bootService.print();
        }
    }

}
