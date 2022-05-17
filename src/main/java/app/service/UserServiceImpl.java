package app.service;

import app.domain.User;
import app.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserInfo(long id) {
        return userMapper.getUserById(id);
    }

    @Override
    public User getUserInfo(String account) {
        return userMapper.getUserByAccount(account);
    }

    @Override
    public List<Map<String, Object>> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public boolean insertUser(User user) {
        // 이미 존재하는 유저인지 확인
        String account = user.getAccount();
        if( account == null || getUserInfo(account) != null) return false;

        userMapper.insertUser(user);
        return true;
    }

    @Override
    public boolean deleteUser(long id) {
        User user = getUserInfo(id);
        if(user == null) return false;

        userMapper.deleteUserById(id);
        return true;
    }

    @Override
    public boolean deleteUser(String account) {
        User user = getUserInfo(account);
        if(account == null || user == null) return false;

        userMapper.deleteUserByAccount(account);
        return true;
    }

    @Override
    public boolean updateUser(User beforeUser, User afterUser) {

        // 계정이 null 이거나 존재하지 않는 유저이면 변경불가능
        if(beforeUser.getAccount() == null || getUserInfo(beforeUser.getAccount()) == null) return false;

        // 변경 후 계정이 null 이거나 이미 존재하는 계정으로 변경 불가능
        if(afterUser.getAccount() == null || getUserInfo(afterUser.getAccount()) != null) return false;

        // id 가 유효하지 않으면 변경 불가능
        // id 가 유효해도 유효한 id 의 실제 account 가 일치하지 않으면 불가능
        if(getUserInfo(beforeUser.getId()) == null ||
        !getUserInfo(beforeUser.getId()).getAccount().equals(beforeUser.getAccount())) return false;

        afterUser.setId(beforeUser.getId());
        userMapper.updateUser(afterUser);
        return true;
    }


}
