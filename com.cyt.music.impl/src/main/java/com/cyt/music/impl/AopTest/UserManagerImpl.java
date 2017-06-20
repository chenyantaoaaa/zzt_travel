package com.cyt.music.impl.AopTest;

/**
 * Created by chen on 2017/2/12.
 */
public class UserManagerImpl implements UserManager {
    public String findUserById(int userId) {
        System.out.println("---------UserManagerImpl.findUserById()--------");
        if (userId <= 0) {
            throw new IllegalArgumentException("该用户不存在!");
        }
        return "张三";
    }
}
