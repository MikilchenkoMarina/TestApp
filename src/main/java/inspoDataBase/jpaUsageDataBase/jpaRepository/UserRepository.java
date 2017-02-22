package inspoDataBase.jpaUsageDataBase.jpaRepository;


import inspoDataBase.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by mmikilchenko on 09.02.2017.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    User saveAndFlush(User user);

    List<User> findAll();

    User findByUserId(Integer userId);

    @Query("SELECT u FROM User u WHERE LOWER(u.userName) = LOWER(:userName)")
    List<User> findByUserName(@Param("userName") String userName);

    void deleteByUserId(Integer userId);

}
