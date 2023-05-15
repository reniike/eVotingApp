package services;

import data.models.Poll;
import data.models.User;
import data.repositories.PollRepo;
import data.repositories.PollRepoImpl;
import data.repositories.UserRepository;
import data.repositories.UserRepositoryImpl;
import dtos.requests.LoginRequest;
import dtos.requests.RegisterUserRequest;
import dtos.requests.VoteRequest;
import dtos.responses.LoginResponse;
import dtos.responses.RegisterUserResponse;
import dtos.responses.VoteResponse;
import exceptions.OverVotingException;
import utils.Mapper;

public class UserServiceImpl implements UserService{
    private UserRepository userRepository = new UserRepositoryImpl();
    private PollRepo pollRepo = new PollRepoImpl();
    @Override
    public RegisterUserResponse registerNewUser(RegisterUserRequest request) {
//        return Mapper.map(userRepository.save(Mapper.map(request)));
        User user = Mapper.map(request);
        User returnedUser = userRepository.save(user);

        RegisterUserResponse response = Mapper.map(returnedUser);
        return response;
    }

    @Override
    public LoginResponse loginUser(LoginRequest loginRequest) {
        User returnedLoggedInUser = userRepository.findByEmail(loginRequest.getEmailAddress());
        validateUser(loginRequest);
        validatePassword(loginRequest);
        LoginResponse loginResponse = Mapper.mapUser(returnedLoggedInUser);
        return loginResponse;
    }

    @Override
    public VoteResponse castVote(VoteRequest voteRequest) throws OverVotingException {
        validateOverVoting(voteRequest.getVoterId());
        return Mapper.map(pollRepo.save(Mapper.map(voteRequest)));
    }

    private void validateOverVoting(int voterId) throws OverVotingException {
        if (pollRepo.findByVoterId(voterId) != null) throw new OverVotingException("User has already voted");
    }

    private User validatePassword(LoginRequest loginRequest){
        User returnedLoggedInUser = userRepository.findByEmail(loginRequest.getEmailAddress());
        if (returnedLoggedInUser.getPassword().equals(loginRequest.getPassword())){
            return returnedLoggedInUser;
        }
        throw new IllegalArgumentException("Wrong password");
    }

    private User validateUser(LoginRequest loginRequest){
        User returnedLoggedInUser = userRepository.findByEmail(loginRequest.getEmailAddress());
        if (returnedLoggedInUser == null) {
            throw new IllegalArgumentException("User doesn't exist");
        }
        else return returnedLoggedInUser;
    }

}
