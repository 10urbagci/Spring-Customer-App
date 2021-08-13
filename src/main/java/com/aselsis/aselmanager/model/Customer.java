package com.aselsis.aselmanager.model;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String surname;

    private Integer age;

    private String email;

    public Customer() {
    }
}
