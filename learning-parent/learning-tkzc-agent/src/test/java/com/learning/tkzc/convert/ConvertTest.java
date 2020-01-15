package com.learning.tkzc.convert;

import org.junit.Test;

import java.util.Map;

public class ConvertTest {

    @Test
    public void test01() {
        Object user = new User(01, "test", "test");
        Map map = ConvertUtils.objectToMap(user);
        map.forEach((k, v) -> {
            System.out.println(k + "=" + v);
        });
        map.put("username", "test222");

        Object obj = ConvertUtils.mapToObect(map, user);
        System.out.println(obj);

    }

    @Test
    public void test02() {
        String a = "AbBB";
        String b = "aBBB";
        String c = "_ABBB";
        String d = "_aBBB";
        print(a);
        print(b);
        print(c);
        print(d);
    }

    private void print(String columnName) {
        System.out.println(columnName.substring(0, 1).toLowerCase() + columnName.substring(1));
    }

}
