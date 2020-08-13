package com.learning.tkzc.single;

/**
 * 枚举单例模式
 *
 * @author tangjx
 * @date 2020/8/13 14:42
 */
public enum EnumSingleMode {

    INSTANCE;

    public static EnumSingleMode getInstance() {
        return INSTANCE;
    }

}
