package com.learning.tkzc.single;

/**
 * 懒汉式单例模式
 *
 * @author tangjx
 * @date 2020/8/13 14:24
 */
public class LazySingleMode {

    private static volatile LazySingleMode lazySingleMode = null;

    private LazySingleMode() {
        System.out.println("创建单例模式！");
    }

    public static LazySingleMode getInstance() {
        if(lazySingleMode == null) {
            synchronized (LazySingleMode.class) {
                if(lazySingleMode == null) {
                    lazySingleMode = new LazySingleMode();
                }
            }
        }
        return lazySingleMode;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> LazySingleMode.getInstance()).start();
        }
        for (int i = 0; i < 10; i++) {
            new Thread(() -> System.out.println(EnumSingleMode.getInstance().hashCode())).start();
        }
    }

}
