package app.service;

import app.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    User getUserInfo(long id);
    User getUserInfo(String account);
    List<Map<String, Object>> getAllUser();
    boolean insertUser(User user);
    boolean deleteUser(long id);
    boolean deleteUser(String account);
    boolean updateUser(User beforeUser, User afterUser);
}
