package data.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VoteRepositoryImplTest {
    VoteRepository voteRepository;

    @BeforeEach
    public void startWith(){
        voteRepository = new VoteRepositoryImpl();
    }

    @Test
    @DisplayName("")
}