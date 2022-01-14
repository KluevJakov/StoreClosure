package com.github.KluevJakov.StoreClosure.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Getter
@Setter
public class Closure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long storeId;
    private String text;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private ZonedDateTime startDate;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private ZonedDateTime endDate;
    @Enumerated(EnumType.ORDINAL)
    private closureTypeEnum closureType;

    public enum closureTypeEnum {CUSTOM, WEATHER, EMERGENCY}

    public Closure() {
    }

    public Closure(Long storeId, ZonedDateTime startDate, ZonedDateTime endDate, closureTypeEnum closureType) {
        this.storeId = storeId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.closureType = closureType;
    }
}
