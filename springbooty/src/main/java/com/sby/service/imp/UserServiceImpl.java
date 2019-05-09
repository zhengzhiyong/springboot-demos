package com.sby.service.imp;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sby.dao.mapper.UserMapper;
import com.sby.md5.MD5;
import com.sby.po.User;
import com.sby.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zheng on 2018/6/20.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserInfo(String account, String password) {
        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        return user;
        //return userMapper.getUserInfo(account,password);
    }

    @Override
    public PageInfo<User> getUserList(int start, int pageSize){
        PageHelper.startPage((start/pageSize+1),pageSize);
        Page<User> users =  userMapper.getUserList();
        return new PageInfo(users);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        if (null == user){
            return;
        }
        userMapper.updateUser(user);
    }

    @Transactional
    @Override
    public void deleteUserById(Long id) {
        if (null == id){
            return;
        }
        userMapper.deleteUserById(id);
    }

    @Override
    public User getUser(Long id) {
        if (null == id){
            return null;
        }
        return userMapper.getUser(id);
    }

    @Transactional
    @Override
    public void save(User user) {
        user.setPassword(MD5.md5("12345678"));
        user.setId(userMapper.getMaxId());
        //userMapper.save(userMapper.getMaxId(),user.getName(),user.getNickName(),MD5.md5("12345678"),user.getAccount());
        userMapper.save(user);
    }
}
