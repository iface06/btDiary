package de.aw3s.btDiary.application.registerUser;


import java.util.List;

public interface RegisterUserDao {
    List<User> findUserByEmailAddress(String emailAddress);
    User store(User user);
}
