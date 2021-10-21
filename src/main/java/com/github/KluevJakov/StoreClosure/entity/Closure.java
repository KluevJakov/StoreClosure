package com.github.KluevJakov.StoreClosure.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@Getter
@Setter
public class Closure {
    private Long id;
    private Long storeId;
    private String text;
    private Date startDate;
    private Date endDate;

    private enum closureType {CUSTOM, WEATHER, EMERGENCY}

}
