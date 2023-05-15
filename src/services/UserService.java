package services;

import dtos.requests.LoginRequest;
import dtos.requests.RegisterUserRequest;
import dtos.requests.VoteRequest;
import dtos.responses.LoginResponse;
import dtos.responses.RegisterUserResponse;
import dtos.responses.VoteResponse;
import exceptions.OverVotingException;

public interface UserService {
    RegisterUserResponse registerNewUser(RegisterUserRequest request);
    LoginResponse loginUser(LoginRequest loginRequest);

    VoteResponse castVote(VoteRequest voteRequest) throws OverVotingException;
}
