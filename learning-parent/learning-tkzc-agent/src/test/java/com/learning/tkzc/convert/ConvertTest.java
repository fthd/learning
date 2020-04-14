package com.learning.tkzc.convert;

import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.Arrays;
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


    @Test
    public void test03() {
        System.out.println(-4 << 1);

        System.out.println(Integer.numberOfLeadingZeros(-10));
        System.out.println(Integer.numberOfTrailingZeros(-4));

        System.out.println(1 << (32 - Integer.numberOfLeadingZeros(1024 - 1)));
        System.out.println(1 << (32 - Integer.numberOfLeadingZeros(3- 1)));

    }


    @Test
    public void test04() {
        System.out.println("DATAMIRRORING_REGISTER".toLowerCase());

        StringBuilder sb = new StringBuilder();
        Arrays.asList("QA_hhh_a".split("_")).forEach(temp -> sb.append(StringUtils.capitalize(temp)));
        String str = StringUtils.uncapitalize(sb.toString());
        System.out.println(str);
    }

}
