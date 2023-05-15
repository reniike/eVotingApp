package services;

import dtos.requests.LoginRequest;
import dtos.requests.RegisterUserRequest;
import dtos.responses.LoginResponse;
import dtos.responses.RegisterUserResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {
    private UserService userService;

    @BeforeEach
    public void startEachWith() {
        userService = new UserServiceImpl();
    }

    @Test
    @DisplayName("Register user test")
    public void testSaveNewUser_idIsNotEqualsZero(){
        RegisterUserRequest registerFirstUserRequest;
        registerFirstUserRequest = new RegisterUserRequest();
        registerFirstUserRequest.setFirstName("first name");
        registerFirstUserRequest.setLastName("my last name");
        registerFirstUserRequest.setNationality("Nigerian");
        registerFirstUserRequest.setEmailAddress("me@gmail.com");
        registerFirstUserRequest.setAge(79);
//        registerFirstUserRequest.setVoter_sIdentificationNumber("6987646789");
        registerFirstUserRequest.setHomeAddress("y34e5rty");

        RegisterUserRequest registerSecondUserRequest;
        registerSecondUserRequest = new RegisterUserRequest();
        registerSecondUserRequest.setFirstName("first");
        registerSecondUserRequest.setLastName("last");
        registerSecondUserRequest.setHomeAddress("address");
        registerSecondUserRequest.setPassword("1111");
        registerSecondUserRequest.setAge(5);
        registerSecondUserRequest.setEmailAddress("email@email");
        registerSecondUserRequest.setNationality("nigerian");

        RegisterUserResponse response = userService.registerNewUser(registerFirstUserRequest);
        RegisterUserResponse response1 = userService.registerNewUser(registerSecondUserRequest);
        System.out.println(response.toString());
        System.out.println(response1.toString());
        assertEquals(1, response.getUserId());
        assertEquals(2, response1.getUserId());
    }

    @Test
    @DisplayName("Login user test")
    public void registeredUserCanLogInTest(){
        RegisterUserRequest registerUserRequest;
        registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setFirstName("first name");
        registerUserRequest.setLastName("my last name");
        registerUserRequest.setNationality("Nigerian");
        registerUserRequest.setEmailAddress("me@gmail.com");
        registerUserRequest.setAge(79);
//        registerUserRequest.setVoter_sIdentificationNumber("6987646789");
        registerUserRequest.setHomeAddress("y34e5rty");
        registerUserRequest.setPassword("1234");
        registerUserRequest.setPhoneNumber("09087777");
        registerUserRequest.setJobDescription("job description");


         userService.registerNewUser(registerUserRequest);

        LoginRequest loginRequest;
        loginRequest = new LoginRequest();
        loginRequest.setEmailAddress("me@gmail.com");
        loginRequest.setPassword("1234");

        LoginResponse loginResponse = userService.loginUser(loginRequest);
        System.out.println(loginResponse.toString());
        String excepted = "LoginResponse{" + "voter's identification number=" + loginResponse.getVoter_sIdentificationNumber() +
                ", name='" + loginResponse.getName() + '\'' +
                ", emailAddress='" + loginResponse.getEmailAddress() + '\'' +
//                ", votersIdentificationNumber='" + loginResponse.getVotersIdentificationNumber() + '\'' +
                ", phoneNumber='" + loginResponse.getPhoneNumber() + '\'' +
                '}';

        assertEquals(excepted, loginResponse.toString());
    }

    @Test
    @DisplayName("User log in with wrong password throws an exception")
    public void testThatUserCan_tLogInWithWrongPassword(){
        RegisterUserRequest registerUserRequest;
        registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setFirstName("first name");
        registerUserRequest.setLastName("my last name");
        registerUserRequest.setNationality("Nigerian");
        registerUserRequest.setEmailAddress("me@gmail.com");
        registerUserRequest.setAge(79);
//        registerUserRequest.setVoter_sIdentificationNumber("6987646789");
        registerUserRequest.setHomeAddress("y34e5rty");
        registerUserRequest.setPassword("1234");
        registerUserRequest.setPhoneNumber("09087777");
        registerUserRequest.setJobDescription("job description");

        userService.registerNewUser(registerUserRequest);

        LoginRequest loginRequest;
        loginRequest = new LoginRequest();
        loginRequest.setEmailAddress("me@gmail.com");
        loginRequest.setPassword("124");

        assertThrows(IllegalArgumentException.class ,()-> userService.loginUser(loginRequest));

    }

    @Test
    @DisplayName("Test that user can log in with correct password")
    public void testThatUserCanLogInWithCorrectPassword(){
            RegisterUserRequest registerUserRequest;
            registerUserRequest = new RegisterUserRequest();
            registerUserRequest.setFirstName("first name");
            registerUserRequest.setLastName("my last name");
            registerUserRequest.setNationality("Nigerian");
            registerUserRequest.setEmailAddress("me@gmail.com");
            registerUserRequest.setAge(79);
//            registerUserRequest.setVoter_sIdentificationNumber("6987646789");
            registerUserRequest.setHomeAddress("y34e5rty");
            registerUserRequest.setPassword("1234");
            registerUserRequest.setPhoneNumber("09087777");
            registerUserRequest.setJobDescription("job description");

            userService.registerNewUser(registerUserRequest);

            LoginRequest loginRequest;
            loginRequest = new LoginRequest();
            loginRequest.setEmailAddress("me@gmail.com");
            loginRequest.setPassword("1234");

            LoginResponse loginResponse = userService.loginUser(loginRequest);
            System.out.println(loginResponse.toString());

             String excepted = "LoginResponse{" + "voter's identification number=" + loginResponse.getVoter_sIdentificationNumber() +
                ", name='" + loginResponse.getName() + '\'' +
                ", emailAddress='" + loginResponse.getEmailAddress() + '\'' +
//                ", votersIdentificationNumber='" + loginResponse.getVotersIdentificationNumber() + '\'' +
                ", phoneNumber='" + loginResponse.getPhoneNumber() + '\'' +
                '}';

        assertEquals(excepted, loginResponse.toString());
    }

    @Test
    @DisplayName("Unregistered user can't log in")
    public void anExceptionIsThrown_whenAnUnregisteredUserCantLogIn(){
        LoginRequest loginRequest;
        loginRequest = new LoginRequest();
        loginRequest.setEmailAddress("me@gmail.com");
        loginRequest.setPassword("1234");

        assertThrows(IllegalArgumentException.class ,()-> userService.loginUser(loginRequest));
    }

    @Test
    @DisplayName("Test That user can vote")
    public void testThatUserCanVote(){
        RegisterUserRequest registerUserRequest;
        registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setFirstName("first name");
        registerUserRequest.setLastName("my last name");
        registerUserRequest.setNationality("Nigerian");
        registerUserRequest.setEmailAddress("me@gmail.com");
        registerUserRequest.setAge(79);
//        registerUserRequest.setVoter_sIdentificationNumber("6987646789");
        registerUserRequest.setHomeAddress("y34e5rty");
        registerUserRequest.setPassword("1234");
        registerUserRequest.setPhoneNumber("09087777");
        registerUserRequest.setJobDescription("job description");

        userService.registerNewUser(registerUserRequest);

        LoginRequest loginRequest;
        loginRequest = new LoginRequest();
        loginRequest.setEmailAddress("me@gmail.com");
        loginRequest.setPassword("1234");

        userService.loginUser(loginRequest);
//        userService.vote();
    }


    @Test
    @DisplayName("User can't vote twice")
    public void anExceptionIsThrown_whenTheSameUserTriesToVoteTwice(){

    }

    @Test
    @DisplayName("User less than 18 can't vote")
    public void anExceptionIsThrown_WhenAUserLessThanEighteenTriesToVote(){

    }

//    @Test
//    @DisplayName("User already exists")
//    public void anExceptionIsThrown_WhenUserTriesToRegister(){
//
//    }


}