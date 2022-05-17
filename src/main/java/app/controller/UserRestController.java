package app.controller;

import app.domain.User;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/userinfo")
    public User getUserInfo(@RequestParam String id){
        return userService.getUserInfo(Long.parseLong(id));
    }

    @RequestMapping("/users")
    public List<Map<String, Object>> getAllUser(){
        return userService.getAllUser();
    }

    @RequestMapping(value = "/insert-user", method = RequestMethod.POST)
    public boolean insertUser(@RequestParam String name, @RequestParam String account, @RequestParam String email)
    {
        User user = new User();
        user.setEmail(email);
        user.setAccount(account);
        user.setName(name);
        return userService.insertUser(user);
    }

    @RequestMapping(value = "/delete-user", method = RequestMethod.POST)
    public boolean deleteUser(@RequestParam String account)
    {
        return userService.deleteUser(account);
    }

    @RequestMapping(value = "/update-user", method = RequestMethod.POST)
    public boolean updateUser(@RequestParam String beforeAccount, @RequestParam String name, @RequestParam String account, @RequestParam String email)
    {
        User user = userService.getUserInfo(beforeAccount);
        User afterUser = new User();
        afterUser.setId(user.getId());

        if(account != null) afterUser.setAccount(account);
        else afterUser.setAccount(user.getAccount());

        if(email != null) afterUser.setEmail(email);
        else afterUser.setEmail(user.getEmail());

        if(name != null) afterUser.setName(name);
        else afterUser.setName(user.getName());

        return userService.updateUser(user, afterUser);
    }

}
