package data.repositories;

import data.models.Candidate;
import data.models.User;

import java.util.ArrayList;
import java.util.List;

public class CandidateRepositoryImpl implements CandidateRepository{
    private int lastCandidateSaved;
    private List<Candidate> candidates = new ArrayList<>();

    @Override
    public Candidate save(Candidate candidate) {
        boolean isSaved = candidate.getCandidateId() !=  0;
        if (isSaved) return update(candidate);
        return saveNewCandidate(candidate);
    }

    private Candidate saveNewCandidate(Candidate candidate){
        candidate.setCandidateId(generateCandidateId());
        candidates.add(candidate);
        lastCandidateSaved++;
        return candidate;
    }

    private Candidate update(Candidate candidate){
        for (Candidate savedCandidate: candidates) {
            if (candidate.getCandidateId() == savedCandidate.getCandidateId()){
                candidates.remove(savedCandidate);
                candidates.add(candidate);
                return candidate;
            }
        }
        return null;
    }
    private int generateCandidateId() {
        return lastCandidateSaved + 1;
    }


    @Override
    public Candidate findById(int candidateId) {
        for (Candidate candidate: candidates) {
            if (candidateId == candidate.getCandidateId()){
                return candidate;
            }
        }
        return null;
    }

    @Override
    public Candidate findByEmail(String emailAddress) {
        for (Candidate candidate : candidates){
            if (candidate.getEmailAddress().equals(emailAddress)) return candidate;
        }
        return null;
    }

    @Override
    public Candidate findByObject(Candidate candidate) {
        for (Candidate aCandidate: candidates) {
            if (aCandidate.equals(candidate)){
                return aCandidate;
            }
        }
        return null;
    }


    @Override
    public int count() {
        return candidates.size();
    }

    @Override
    public List<Candidate> findAllCandidate() {
        return candidates;
    }


    @Override
    public void delete(Candidate candidate) {
        findByObject(candidate);
        candidates.remove(candidate);
    }

    @Override
    public void delete(int id) {
        candidates.removeIf(candidate -> candidate.getCandidateId() == id);
    }


    @Override
    public int deleteAll() {
        candidates.clear();
        return count();
    }

}
