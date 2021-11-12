package com.github.KluevJakov.StoreClosure.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Closure {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long storeId;
    private String text;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date startDate;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date endDate;
    private closureTypeEnum closureType;

    public enum closureTypeEnum {CUSTOM, WEATHER, EMERGENCY}

}
