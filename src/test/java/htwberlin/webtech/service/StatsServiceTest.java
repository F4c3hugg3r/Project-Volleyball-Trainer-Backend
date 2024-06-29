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
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class StatsServiceTest {

    @Autowired
    private StatsService service;

    @MockBean
    private StatRepository repo;

    final StatId statIda1 = new StatId(1, 1);
    final Stat a1 = new Stat(statIda1, 2);
    final StatId statIda2 = new StatId(2, 2);
    final Stat a2 = new Stat(statIda2, 1);
    final StatId statIdm2 = new StatId(13, 3);
    final Stat m2 = new Stat(statIdm2, 2);
    final StatId nonExistingId = new StatId(141345124, 3);
    final Stat nonExistingStat = new Stat(nonExistingId, 3);
    final Stat a1Updated = new Stat(statIda1, 3);

    @BeforeEach
    void setUpMockRepository() {
        doReturn(List.of(a1, a2, m2)).when(repo).findAll();
        doNothing().when(repo).deleteById(any(StatId.class));
        doReturn(a1).when(repo).save(a1);
        doReturn(false).when(repo).existsById(nonExistingId);
        doReturn(true).when(repo).existsById(statIda1);
    }

    @Test
    void testGetStats() {
        final Iterable<Stat> statsIterable = service.getStats();
        final List<Stat> stats = StreamSupport.stream(statsIterable.spliterator(), false).toList();
        assertEquals(List.of(a1, a2, m2), stats);
    }

    @Test
    void testDeleteStatsByPosition() {
        assertTrue(service.deleteStatsByPosition(3));
        assertFalse(service.deleteStatsByPosition(0));
    }

    @Test
    void testSaveStat() {
        assertEquals(a1, service.saveStats(a1));
    }

    @Test
    void testUpdateStats() {
        assertNull(service.updateStats(nonExistingStat));
        assertEquals(a1Updated, service.updateStats(a1));
    }

}