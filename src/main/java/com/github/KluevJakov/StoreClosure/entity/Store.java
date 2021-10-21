package com.github.KluevJakov.StoreClosure.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Store {
    private Long id;
    private String phone;
    private String name;
    private Address address;

}
