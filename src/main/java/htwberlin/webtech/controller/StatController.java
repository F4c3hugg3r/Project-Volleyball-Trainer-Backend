package htwberlin.webtech.controller;

import htwberlin.webtech.model.Stat;
import htwberlin.webtech.service.StatsService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/stats")
public class StatController {

    private final StatsService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Stat>> getStats() {
        return ResponseEntity.ok(service.getStats());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Stat> createStat(@Valid @RequestBody Stat body) {
        Stat stat = new Stat(body.getId(), body.getAnzahl());
            service.saveStats(stat);
        return new ResponseEntity<>(stat, HttpStatus.CREATED);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Stat> updateStat(@Valid @RequestBody Stat body) {
        Stat stat = new Stat(body.getId(), body.getAnzahl());
        final Stat updatedStat = service.updateStats(stat);
        if (updatedStat == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(updatedStat);
    }

    @DeleteMapping(path = "/{position}")
    public ResponseEntity<Void> deleteStatsByPosition(@PathVariable("position") final Integer position) {
        return service.deleteStatsByPosition(position) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    //TODO evtl Eigenen Stat erstellen

    @DeleteMapping
    public ResponseEntity<Void> deleteAllStats() {
        service.removeAllStats();
        return ResponseEntity.noContent().build();
    }
}
