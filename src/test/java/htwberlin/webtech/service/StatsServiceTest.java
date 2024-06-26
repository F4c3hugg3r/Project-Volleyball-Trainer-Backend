package htwberlin.webtech.service;

import htwberlin.webtech.model.Stat;
import htwberlin.webtech.model.StatId;
import htwberlin.webtech.persistence.StatRepository;
import org.assertj.core.api.IterableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class StatsServiceTest {

    @Autowired
    private StatsService service;

    @MockBean
    private StatRepository repo;

    @BeforeEach
    void setUpMockRepository() {
        final StatId statIda1 = new StatId(1, 1);
        final Stat a1 = new Stat(statIda1, 2);
        final StatId statIda2 = new StatId(2, 2);
        final Stat a2 = new Stat(statIda2, 1);
        final StatId statIdm2 = new StatId(13, 3);
        final Stat m2 = new Stat(statIdm2, 2);
        doReturn(List.of(a1, a2, m2)).when(repo).findAll();
//        doReturn(m2).when(repo).deleteById(statIdm2);
//        doReturn(false).when(repo).
    }

    @Test
    void testGetStats() {
        Iterable<Stat> stats = service.getStats();
    }
}
