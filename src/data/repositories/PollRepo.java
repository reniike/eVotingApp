package data.repositories;

import data.models.Poll;
import data.models.User;

public interface PollRepo {
    Poll save(Poll poll);

    Poll findByVoterId(int voterId);
}
