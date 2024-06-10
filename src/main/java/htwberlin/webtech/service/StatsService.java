package htwberlin.webtech.service;

import htwberlin.webtech.model.Stat;
import htwberlin.webtech.persistence.StatRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StatsService {

    @Autowired
    private StatRepository repo;

    public Stat saveStats(Long id, Integer rating, Integer anzahl) {
//        stats.stream()
//                .filter(stat -> Objects.equals(stat.getId(), id) && Objects.equals(stat.getRating(), rating))
//                .forEach(stat -> stat.setAnzahl(stat.getAnzahl() + anzahl));
        return repo.save(new Stat(id,rating,anzahl));
    }

    public Iterable<Stat> getStats() {
        return repo.findAll();
    }

//    public boolean checkExistence(Long id, Integer rating) {
////        return stats.stream()
////                .anyMatch(stat -> Objects.equals(stat.getId(), id) && Objects.equals(stat.getRating(), rating));
//        return false;
//    }

    public void removeStat(Long id) {
//        stats.removeIf(stat -> stat.getId().equals(id) && stat.getRating().equals(rating));
        repo.deleteById(id);
    }
}
