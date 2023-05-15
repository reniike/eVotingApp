package data.repositories;

import data.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTest {
    private UserRepository userRepository;


    @BeforeEach
    public void setUp() {
        userRepository = new UserRepositoryImpl();
    }

    @Test
    @DisplayName("Create new User Test")
    public void saveOneUser_countIsOneTest(){
        User newUser = new User();
        userRepository.save(newUser);
        assertEquals(1, userRepository.count());
    }

    @Test
    @DisplayName("Generate ID test")
    public void saveOneUser_idIsOneTest(){
        User newUser = new User();
        userRepository.save(newUser);
        assertEquals(1, newUser.getVoter_sIdentificationNumber());
    }

    @Test
    @DisplayName("Find by ID test")
    public void saveOneUser_findUserById_returnsSavedUserTest(){
        User newUser = new User();
        userRepository.save(newUser);
        User foundUser = userRepository.findById(1);
        assertEquals(1, foundUser.getVoter_sIdentificationNumber());
        assertEquals(newUser, foundUser);
    }

    @Test
    @DisplayName("Update Test")
    public void saveTwoUsersWithSameId_countIsOneTest(){
        User newUser = new User();
        newUser.setFirstName("First Name");
        User savedUser = userRepository.save(newUser);
        assertEquals(newUser, savedUser);

        User aNewUser = new User();
        aNewUser.setFirstName("A new user's firstName");
        aNewUser.setVoter_sIdentificationNumber(1);
        userRepository.save(aNewUser);

        User foundUser = userRepository.findById(1);

        assertEquals(1, userRepository.count());
        assertEquals(aNewUser, foundUser);
        assertNotEquals(newUser, foundUser);
    }

    @Test
    @DisplayName("Delete by ID test")
    public void testThatUserCanBeDeletedById(){
        User newUser = new User();
        userRepository.save(newUser);
        userRepository.delete(newUser.getVoter_sIdentificationNumber());

        User foundId = userRepository.findById(newUser.getVoter_sIdentificationNumber());
        assertEquals(null, foundId);
    }

//    @Test
//    @DisplayName("Delete by Object test")
//    public void testThatUserCanBeDeletedById_object(){
//        User newUser = new User();
//        userRepository.save(newUser);
//        userRepository.delete(newUser);
//
//        User foundUser = userRepository.findByObject(newUser);
//        assertEquals(null, foundUser);
//    }

    @Test
    @DisplayName("Delete all test")
    public void testThatAllUsersCanBeDeleted(){
        User newUser = new User();
        userRepository.save(newUser);
        User newUser2 = new User();
        userRepository.save(newUser2);
        User newUser3 = new User();
        userRepository.save(newUser3);

        userRepository.deleteAll();
        assertEquals(0, userRepository.count());
        assertTrue(userRepository.findAll().isEmpty());
    }
}