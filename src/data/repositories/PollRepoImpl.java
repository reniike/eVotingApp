package data.repositories;

import data.models.Poll;

import java.util.ArrayList;
import java.util.List;

public class PollRepoImpl implements PollRepo {

    private List<Poll> polls = new ArrayList<>();
    private int count;

    @Override
    public Poll save(Poll poll) {
        boolean voteHasNotBeenCasted = poll.getId() == 0;
        if (voteHasNotBeenCasted) {
            poll.setId(generateId());
            polls.add(poll);
            count++;
        }
        return poll;
    }

    @Override
    public Poll findByVoterId(int voterId) {
        for (var poll : polls) if (poll.getVoterId() == voterId) return poll;
        return null;
    }

    private int generateId() {
        return count+1;
    }
}
