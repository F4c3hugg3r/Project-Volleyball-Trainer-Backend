package htwberlin.webtech.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import htwberlin.webtech.model.Stat;
import htwberlin.webtech.model.StatId;
import htwberlin.webtech.service.StatsService;
import netscape.javascript.JSObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StatController.class)
public class StatControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StatsService service;

    final StatId statIda1 = new StatId(1, 1);
    final Stat a1 = new Stat(statIda1, 1);
    final StatId statIda2 = new StatId(2, 1);
    final Stat a2 = new Stat(statIda2, 1);
    final Iterable<Stat> stats = List.of(a1, a2);

    final StatId statIda3 = new StatId(3, 1);
    final Stat a3 = new Stat(statIda3, 1);

    final StatId statIda1Updated = new StatId(1, 1);
    final Stat a1Updated = new Stat(statIda1Updated, 2);

    ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUpMockRepository() {
        when(service.getStats()).thenReturn(stats);
        when(service.saveStats(a1)).thenReturn(a1);
        when(service.updateStats(a1)).thenReturn(a1Updated);
        when(service.updateStats(a3)).thenReturn(null);
        when(service.deleteStatsByPosition(1)).thenReturn(true);
        when(service.deleteStatsByPosition(0)).thenReturn(false);
    }

    @Test
    void testGetStats() throws Exception {
        final String expectation = objectMapper.writeValueAsString(stats);
        this.mockMvc.perform(get("/stats"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(equalTo(expectation)));
    }

    @Test
    void testCreateStat() throws Exception {
        String statJson = objectMapper.writeValueAsString(a1);
        String expectation = objectMapper.writeValueAsString(a1);

        this.mockMvc.perform(post("/stats")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(statJson))
                        .andExpect(status().isCreated())
                        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                        .andExpect(content().json(expectation));
    }

    @Test
    void testUpdateStatExisting() throws Exception {
        String statJson = objectMapper.writeValueAsString(a1);
        String expectation = objectMapper.writeValueAsString(a1Updated);

        this.mockMvc.perform(put("/stats")
                .contentType(MediaType.APPLICATION_JSON)
                .content(statJson))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expectation));
    }

    @Test
    void testUpdateStatNotExisting() throws Exception {
        String statJson = objectMapper.writeValueAsString(a3);
        String expectation = objectMapper.writeValueAsString(a3);

        this.mockMvc.perform(put("/stats")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(statJson))
                .andExpect(status().isNotFound());
    }

    @Test
    void testDeleteAllStats() throws Exception {
        this.mockMvc.perform(delete("/stats"))
                .andExpect(status().isNoContent());
    }

    @Test
    void testDeleteStatsByPositionExisting() throws Exception {
        this.mockMvc.perform(delete("/stats/"+1))
                .andExpect(status().isNoContent());
    }

    @Test
    void testDeleteStatsByPositionNotExisting() throws Exception {
        this.mockMvc.perform(delete("/stats/"+0))
                .andExpect(status().isNotFound());
    }
}
