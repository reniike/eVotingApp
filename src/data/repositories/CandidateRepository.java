package data.repositories;

import data.models.Candidate;
import data.models.Party;
import data.models.User;

import java.util.List;

public interface CandidateRepository {
    Candidate save(Candidate candidate);
    Candidate findById(int candidateId);
    Candidate findByEmail(String emailAddress);
    Candidate findByObject(Candidate candidate);
    List<Candidate> findAllCandidate();
    int count();
    void delete(int candidateId);
    void delete(Candidate candidate);
    int deleteAll();

}
