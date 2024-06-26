package kr.co.neo.restfulservice.service;

import kr.co.neo.restfulservice.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class UserService {
    private static List<User> users = new ArrayList<>();

    private static int userCount = 3;

//    static {
//        users.add(new User(1, "kenneth", new Date() ,"test1","1111111-111111"));
//        users.add(new User(2, "alice", new Date(),"test2","2222222-222222"));
//        users.add(new User(3, "elena", new Date(),"test3","3333333-333333"));
//    }


    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }


    public User findOne(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }

        }

        return null;
    }

    public User deleteById(int id) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }

}
