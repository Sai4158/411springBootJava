package psu.edu.mvcsecurity.dao;

import psu.edu.mvcsecurity.entity.User;

public interface UserDao {

    User findByUserName(String userName);

    void save(User theUser);
}
