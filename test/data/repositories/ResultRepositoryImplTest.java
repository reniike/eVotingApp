package data.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultRepositoryImplTest {
    ResultRepository voteRepository;

    @BeforeEach
    public void startWith(){
        voteRepository = new ResultRepositoryImpl();
    }

}