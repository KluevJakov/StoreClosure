package com.github.KluevJakov.StoreClosure.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class Store {
    @Id
    private Long id;
    private String phone;
    private String name;
    @ManyToOne
    private Address address;

}
