package htwberlin.webtech.service;

import htwberlin.webtech.model.Stat;
import htwberlin.webtech.model.StatId;
import htwberlin.webtech.persistence.StatRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StatsService {

    @Autowired
    private StatRepository repo;

    public Stat saveStats(StatId statId, Integer anzahl) {
        return this.repo.save(new Stat(statId, anzahl));
    }

    public Iterable<Stat> getStats() {
        return this.repo.findAll();
    }

//    public boolean checkExistence(Long id, Integer rating) {
////        return stats.stream()
////                .anyMatch(stat -> Objects.equals(stat.getId(), id) && Objects.equals(stat.getRating(), rating));
//        return false;
//    }

    public void removeAllStats() {
//        final boolean exists = repo.existsById(statId);
//        if (exists) repo.deleteById(statId);
//        return exists;
        repo.deleteAll();
    }
}
