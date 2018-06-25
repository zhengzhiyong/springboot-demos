package com.sby.service;

import com.github.pagehelper.PageInfo;
import com.sby.po.User;

/**
 * Created by zheng on 2018/6/20.
 */
public interface UserService {

    /**
     *
     * @param account
     * @param password
     * @return
     */
    User getUserInfo(String account,String password);

    /**
     *
     * @param start
     * @param pageSize
     * @return
     */
    PageInfo<User> getUserList(int start, int pageSize);

    /**
     *
     * @param user
     */
    void updateUser(User user);

    /**
     *
     * @param id
     */
    void deleteUserById(Long id);

    /**
     *
     * @param id
     * @return
     */
    User getUser(Long id);

    /**
     *
     * @param user
     */
    void save(User user);

}
