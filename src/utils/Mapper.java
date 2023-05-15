package utils;

import data.models.Poll;
import data.models.User;
import dtos.requests.LoginRequest;
import dtos.requests.RegisterUserRequest;
import dtos.requests.VoteRequest;
import dtos.responses.LoginResponse;
import dtos.responses.RegisterUserResponse;
import dtos.responses.VoteResponse;

public class Mapper {
    public static User map(RegisterUserRequest request){
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setAge(request.getAge());
        user.setNationality(request.getNationality());
        user.setEmailAddress(request.getEmailAddress());
        user.setPassword(request.getPassword());
        user.setPhoneNumber(request.getPhoneNumber());
//        user.setVoter_sIdentificationNumber(request.getVoter_sIdentificationNumber());
        user.setJobDescription(request.getJobDescription());


        return user;
    }

    public static RegisterUserResponse map(User user) {
        RegisterUserResponse response = new RegisterUserResponse();
        response.setUserId(user.getVoter_sIdentificationNumber());
        response.setName(user.getFirstName() + " " + user.getLastName());
        response.setEmailAddress(user.getEmailAddress());
        response.setNationality(user.getNationality());
        return response;
    }

    public static User map(LoginRequest loginRequest) {
        User user = new User();
        loginRequest.setPassword(user.getPassword());
        loginRequest.setEmailAddress(user.getEmailAddress());
        return user;
    }

    public static LoginResponse mapUser(User returnedLoggedInUser) {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setName(returnedLoggedInUser.getFirstName() + " " + returnedLoggedInUser.getLastName());
//        loginResponse.setVotersIdentificationNumber(returnedLoggedInUser.getVoter_sIdentificationNumber());
        loginResponse.setVoter_sIdentificationNumber(returnedLoggedInUser.getVoter_sIdentificationNumber());
        loginResponse.setPhoneNumber(returnedLoggedInUser.getPhoneNumber());
        loginResponse.setEmailAddress(returnedLoggedInUser.getEmailAddress());
        return loginResponse;
    }


    public static VoteResponse map(Poll poll){
        VoteResponse voteResponse = new VoteResponse();
        voteResponse.setId(poll.getId());
        voteResponse.setPartyName(poll.getPartyName());
        voteResponse.setVoteId(poll.getVoterId());
        return voteResponse;
    }

    public static Poll map(VoteRequest voteRequest) {
        Poll poll = new Poll();
        voteRequest.setPartyName(poll.getPartyName());
        voteRequest.setVoterId(poll.getVoterId());
        return poll;
    }
}
