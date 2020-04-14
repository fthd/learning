package com.learning.tkzc.file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileTest {

    @Test
    public void test01() throws IOException {
        File file = new File("E:/aa/a.txt");

        file.getParentFile().mkdirs();
        System.out.println(file.exists());
        file.createNewFile();
    }

}
