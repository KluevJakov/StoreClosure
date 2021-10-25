package com.github.KluevJakov.StoreClosure.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
public class Closure {
    @Id
    private Long id;
    private Long storeId;
    private String text;
    private Date startDate;
    private Date endDate;

    private enum closureType {CUSTOM, WEATHER, EMERGENCY}

}
