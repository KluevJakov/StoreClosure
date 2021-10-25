package com.github.KluevJakov.StoreClosure.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
public class Changelog {
    @Id
    private Long id;
    private Long storeId;
    private Date changeDate;
    private String changedBy;
    private String reason;

    private enum closureType {CUSTOM, WEATHER, EMERGENCY, OPEN}
}
