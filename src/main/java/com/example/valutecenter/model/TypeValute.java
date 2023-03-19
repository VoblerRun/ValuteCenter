package com.example.valutecenter.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "type_valute")
public class TypeValute {
    @Id
    @Getter
    @Setter
    private String symbols;
    @Column(name = "name_valute")
    @Getter
    @Setter
    private String name;

}
