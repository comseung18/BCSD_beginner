package app.repository;

import app.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface UserMapper {
    User getUserById(Long id);
    User getUserByAccount(String account);
    void insertUser(User user);
    void deleteUserById(Long id);
    void deleteUserByAccount(String account);
    void updateUser(User user);
    List<Map<String, Object>> getAllUser();
}
