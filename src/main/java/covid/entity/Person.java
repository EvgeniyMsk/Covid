package covid.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;
    private String father;
    private String address;
    private String phone;
    @ManyToOne
    @JsonIgnore
    private CovidInfo covidInfo;
}
