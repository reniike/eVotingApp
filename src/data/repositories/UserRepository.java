package data.repositories;

import data.models.User;
import java.util.List;

public interface UserRepository {
        User save(User user);
        User findById(int userId);
//        User findByObject(User user);
        User findByEmail(String emailAddress);
        int count();
//        Poll vote();
        List<User> findAll();
//        void delete(User user);
        void delete(int id);
        int deleteAll();

}
