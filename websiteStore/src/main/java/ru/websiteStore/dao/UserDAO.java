package ru.websiteStore.dao;

import java.util.ArrayList;
import java.util.List;
import ru.websiteStore.model.User;

public class UserDAO {

    private final List<User> list = new ArrayList<>();

    public User getUserById(int id) {

        User result = new User();
        result.setId(-1);

        for (User user : list) 
            if (user.getId() == id) 
                result = user;
            
        return result;
    }

    public User getUserByLoginPassword(final String login, final String password) {

        User result = new User();
        result.setId(-1);

        for (User user : list) 
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) 
                result = user;
            
        return result;
    }

    public boolean add(final User user) {

        for (User u : list) 
            if (u.getLogin().equals(user.getLogin()) 
            		&& u.getPassword().equals(user.getPassword())) 
            return false;
            
        return list.add(user);
    }

    public User.ROLE getRoleByLoginPassword(final String login, final String password) {
        User.ROLE result = User.ROLE.UNKNOWN;

        for (User user : list) 
            if (user.getLogin().equals(login) 
            		&& user.getPassword().equals(password)) 
            result = user.getRole();

        return result;
    }

    public boolean userIsExist(final String login, final String password) {

        boolean result = false;

        for (User user : list) 
            if (user.getLogin().equals(login) 
            		&& user.getPassword().equals(password)) {
                result = true;
                break;
            }

        return result;
    }

}
