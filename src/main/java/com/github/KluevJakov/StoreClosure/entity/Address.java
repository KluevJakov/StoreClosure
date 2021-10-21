package com.github.KluevJakov.StoreClosure.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Address {
    private Long id;
    private String city;
    private String street;
    private String house;
}
