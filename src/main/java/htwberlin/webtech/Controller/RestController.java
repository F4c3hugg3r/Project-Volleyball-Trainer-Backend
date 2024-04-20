package htwberlin.webtech.Controller;

import htwberlin.webtech.Entities.Question;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RestController {

    @GetMapping(path = "/question")
    public ResponseEntity<Question> getQuestion() {
        Question question = new Question();
        return ResponseEntity.ok(question);
    }
}
