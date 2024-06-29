package htwberlin.webtech.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@EqualsAndHashCode
@ToString
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Stat implements Serializable {

     @EmbeddedId
     private StatId id;

     private Integer anzahl;

}