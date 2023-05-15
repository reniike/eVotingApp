package data.repositories;

import data.models.User;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository{
    private int lastUserSaved;
    private final List<User> users = new ArrayList<>();

    @Override
    public User save(User user) {
        boolean isSaved = user.getVoter_sIdentificationNumber() !=  0;
        if (isSaved) return update(user);
        return saveNewUser(user);
    }

    private User saveNewUser(User user){
        user.setVoter_sIdentificationNumber(generateUserId());
        users.add(user);
        lastUserSaved++;
        return user;
    }

    private User update(User user){
        for (User savedUser: users) {
            if (user.getVoter_sIdentificationNumber() == savedUser.getVoter_sIdentificationNumber()){
                users.remove(savedUser);
                users.add(user);
                return user;
            }
        }
        return null;
    }
    private int generateUserId() {
        return lastUserSaved + 1;
    }

    @Override
    public User findById(int userId) {
        for (User user: users) {
          if (userId == user.getVoter_sIdentificationNumber()){
              return user;
          }
        }
        return null;
    }
    @Override
    public User findByEmail(String emailAddress) {
        for (User user : users) {
            if (user.getEmailAddress().equals(emailAddress)){
                return user;
            }
        }
        return null;
    }

    @Override
    public int count() {
        return users.size();
    }


    @Override
    public List<User> findAll() {
        return users;
    }

//    @Override
//    public void delete(User user) {
//        findByObject(user);
//        users.remove(user);
//    }

    @Override
    public void delete(int id) {
        users.removeIf(user -> user.getVoter_sIdentificationNumber() == id);
    }

    @Override
    public int deleteAll() {
        users.clear();
        return count();
    }


}
