package htwberlin.webtech.service;

import htwberlin.webtech.model.Stat;
import htwberlin.webtech.model.StatId;
import htwberlin.webtech.persistence.StatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatsService {

    public enum Position {
        none,
        Aussenangreifer1,
        Mittelblocker,
        Libero,
        Zuspieler,
        Diagonalangreifer,
        Aussenangreifer2
    }

    @Autowired
    private StatRepository repo;

    public Stat saveStats(Stat stat) {
        return this.repo.save(stat);
    }

    public Iterable<Stat> getStats() {
        return this.repo.findAll();
    }

    public Stat updateStats(Stat stat) {
        if(repo.existsById(stat.getId())) {
            repo.deleteById(stat.getId());
            stat.setAnzahl(stat.getAnzahl()+1);
            repo.save(stat);
            return stat;
        }
        else return null;
    }

    public boolean deleteStatsByPosition(Integer position) {
        Position positionEnum = switch(position) {
          case 1 -> Position.Aussenangreifer1;
          case 2 -> Position.Mittelblocker;
          case 3 -> Position.Zuspieler;
          case 4 -> Position.Diagonalangreifer;
          case 5 -> Position.Libero;
          case 6 -> Position.Aussenangreifer2;
            default -> Position.none;
        };

        switch(positionEnum) {
            case Position.Aussenangreifer1 -> {
                for(int i=1; i<=12; i++) {
                    for(int j=1; j<=4; j++) {
                        repo.deleteById(new StatId(i, j));
                    }
                }
                return true;
            }
            case Position.Mittelblocker -> {
                for(int i=13; i<=24; i++) {
                    for(int j=1; j<=4; j++) {
                        repo.deleteById(new StatId(i, j));
                    }
                }
                return true;
            }
            case Position.Zuspieler -> {
                for(int i=25; i<=36; i++) {
                    for(int j=1; j<=4; j++) {
                        repo.deleteById(new StatId(i, j));
                    }
                }
                return true;
            }
            case Position.Diagonalangreifer -> {
                for(int i=37; i<=48; i++) {
                    for(int j=1; j<=4; j++) {
                        repo.deleteById(new StatId(i, j));
                    }
                }
                return true;
            }
            case Position.Libero -> {
                for(int i=49; i<=60; i++) {
                    for(int j=1; j<=4; j++) {
                        repo.deleteById(new StatId(i, j));
                    }
                }
                return true;
            }
            case Position.Aussenangreifer2 -> {
                for(int i=61; i<=72; i++) {
                    for(int j=1; j<=4; j++) {
                        repo.deleteById(new StatId(i, j));
                    }
                }
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    public void removeAllStats() {
        repo.deleteAll();
    }
}
