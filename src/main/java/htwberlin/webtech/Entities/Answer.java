package htwberlin.webtech.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Answer {
    private String text;
    private String answerId;
    private String picture;
    private String number;
}
