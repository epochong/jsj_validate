package com.epchong.Service;

import com.epchong.dao.AccountDao;
import com.epchong.po.User;

/**
 * @author epochong
 * @date 2019/9/5 16:26
 * @email epochong@163.com
 * @blog epochong.github.io
 * @describe
 */
public class AccountService {
    private AccountDao accountDao = new AccountDao();

    public boolean userLogin(String userName, String password) {
        User user = accountDao.userLogin(userName,password);
        if (user == null) {
            return false;
        }
        return true;
    }
}
