package com.sby.shiro;

import com.sby.po.User;
import org.apache.shiro.SecurityUtils;

/**
 * Created by zheng on 2018/6/20.
 */
public final class SessionUtils {
     public static final String SESSION_USER_KEY = "session_user_key";
    /**
     * 获取session中的用户
     *
     * @param
     * @return PermAccountPO
     * @since 2016年11月14日 上午11:18:48
     * @author zhouguobao
     */
    public static User getSessionUser() {
        Object user = (User) SecurityUtils.getSubject().getSession().getAttribute(SESSION_USER_KEY);
        if (null == user) {
            return null;
        }
        return (User) user;
    }

    /**
     * 获取session中的用户Id
     *
     * @param
     * @return Long
     * @since 2016年11月14日 上午11:19:05
     * @author zhouguobao
     */
    public static Long getSessionUserId() {
        return getSessionUser() == null ? null : getSessionUser().getId();
    }

    /**
     * setSessionUser:(存放PermAccountDTO到session中，dto比po中少字段，使用时请注意).
     *
     * @author YangKang
     * @date 2017年6月30日 下午2:34:24
     * @param use
     */
    public static void setSessionUser(User use) {
        SecurityUtils.getSubject().getSession().setAttribute(SESSION_USER_KEY, use);
    }
}
