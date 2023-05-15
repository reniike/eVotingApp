package data.repositories;

import data.models.Candidate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CandidateRepositoryImplTest {
    CandidateRepository candidateRepository;

    @BeforeEach
    public void startEachWith(){
       candidateRepository = new CandidateRepositoryImpl();
    }

    @Test
    @DisplayName("Save test")
    public void saveOneCandidate_countIsOneTest(){
        Candidate candidate = new Candidate();
        candidateRepository.save(candidate);

        assertEquals(1, candidateRepository.count());
    }

    @Test
    @DisplayName("Find by ID test")
    public void findCandidateByIdTest(){
        Candidate candidate = new Candidate();
        candidateRepository.save(candidate);
        Candidate candidate2 = new Candidate();
        candidateRepository.save(candidate2);

        assertEquals(candidate2, candidateRepository.findById(2));
    }

    @Test
    @DisplayName("Find by email test")
    public void findCandidateByEmailTest(){
        Candidate candidate = new Candidate();
        candidate.setEmailAddress("jennifer@gmail.com");

        Candidate savedCandidate = candidateRepository.save(candidate);
        Candidate foundCandidate = candidateRepository.findByEmail("jennifer@gmail.com");
        assertEquals(savedCandidate, foundCandidate);
    }

    @Test
    @DisplayName("Find by object test")
    public void findCandidateByObjectTest(){
        Candidate candidate = new Candidate();
        Candidate savedCandidate = candidateRepository.save(candidate);
        Candidate foundCandidate = candidateRepository.findByObject(savedCandidate);

        assertEquals(foundCandidate, savedCandidate);
    }

    @Test
    @DisplayName("Find all test")
    public void findAllCandidateTest(){
        Candidate candidate = new Candidate();
        candidateRepository.save(candidate);
        Candidate candidate2 = new Candidate();
        candidateRepository.save(candidate2);

        assertNotNull(candidateRepository.findAllCandidate());
    }

    @Test
    @DisplayName("Delete candidate by id test")
    public void deleteCandidateByIdTest(){
        Candidate candidate = new Candidate();

        Candidate savedCandidate =  candidateRepository.save(candidate);
        candidateRepository.delete(savedCandidate.getCandidateId());

        assertNull(candidateRepository.findById(1));
    }

    @Test
    @DisplayName("Delete all test")
    public void deleteAllCandidatesTest(){
        Candidate candidate = new Candidate();
        candidateRepository.save(candidate);
        Candidate candidate2 = new Candidate();
        candidateRepository.save(candidate2);

        candidateRepository.deleteAll();
        assertTrue(candidateRepository.findAllCandidate().isEmpty());
    }
}