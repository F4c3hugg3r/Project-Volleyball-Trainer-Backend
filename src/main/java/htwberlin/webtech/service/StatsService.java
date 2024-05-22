package htwberlin.webtech.service;

import htwberlin.webtech.model.Stat;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StatsService {

    @Getter
    private static final Set<Stat> stats = new HashSet<>();

    public static void updateStats(Integer id, Integer rating, Integer anzahl) {
        stats.stream()
                .filter(stat -> Objects.equals(stat.getQuestionId(), id) && Objects.equals(stat.getRating(), rating))
                .forEach(stat -> stat.setAnzahl(stat.getAnzahl() + anzahl));
    }

    public static boolean checkExistence(Integer id, Integer rating) {
        return stats.stream()
                .anyMatch(stat -> Objects.equals(stat.getQuestionId(), id) && Objects.equals(stat.getRating(), rating));
    }

    public static void addStat(final Stat stat) {
        stats.add(stat);
    }

    public static void removeStat(Integer id, Integer rating) {
        stats.removeIf(stat -> stat.getQuestionId().equals(id) && stat.getRating().equals(rating));
    }
}
