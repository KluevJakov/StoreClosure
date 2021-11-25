package com.github.KluevJakov.StoreClosure.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
public class Changelog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long storeId;
    private Date changeDate;
    private String changedBy;
    private closureTypeEnum reason;

    public enum closureTypeEnum {CUSTOM, WEATHER, EMERGENCY, OPEN}

    public Changelog(Long storeId, Date changeDate, String changedBy, closureTypeEnum reason) {
        this.storeId = storeId;
        this.changeDate = changeDate;
        this.changedBy = changedBy;
        this.reason = reason;
    }
}
