package com.example.valutecenter.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "valutes")
@Getter
@EqualsAndHashCode
public class Valute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Setter
    private String name;

    @Setter
    private String value;

    private int unit;


}