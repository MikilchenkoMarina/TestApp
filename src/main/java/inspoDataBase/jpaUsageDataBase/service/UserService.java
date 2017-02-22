package inspoDataBase.jpaUsageDataBase.service;

import inspoDataBase.entity.User;
import inspoDataBase.jpaUsageDataBase.jpaRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author mmikilchenko on 22.02.2017.
 */
@Transactional
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void addUser(User user) {
        userRepository.saveAndFlush(user);
    }

    public User findUserByUserId(Integer userId) {
        return userRepository.findByUserId(userId);
    }

    public void deleteUserById(int userId) {
        userRepository.deleteByUserId(userId);
    }

    public void printUserList(List<User> usersList) {
        for (User user : usersList) {
            System.out.println(user.toString());
        }
    }
}
