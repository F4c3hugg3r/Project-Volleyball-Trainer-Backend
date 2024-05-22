package htwberlin.webtech.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Stat {
     private Integer questionId;
     private Integer rating;
     private Integer anzahl;
}