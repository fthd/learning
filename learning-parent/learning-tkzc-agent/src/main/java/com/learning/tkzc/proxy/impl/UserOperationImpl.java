package com.learning.tkzc.proxy.impl;

import com.learning.tkzc.proxy.UserOperation;

/**
 * 用户操作实现类
 *
 * @author tangjx
 * @date 2020/8/11 10:16
 */
public class UserOperationImpl implements UserOperation {
    @Override
    public void userAdd() {
        System.out.println("用户添加操作...");
    }

    @Override
    public void userDel() {
        System.out.println("用户删除操作...");
    }
}
