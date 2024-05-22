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

import java.util.List;
import java.util.Set;

@Controller
@AllArgsConstructor
@RequestMapping("/quiz")
public class RestController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<Stat>> getStat() {
        return ResponseEntity.ok(StatsService.getStats());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Stat> addStat(@Valid @RequestBody Stat body) {
        StatsService.addStat(body);
        return new ResponseEntity<>(body, HttpStatus.CREATED);
    }


}
