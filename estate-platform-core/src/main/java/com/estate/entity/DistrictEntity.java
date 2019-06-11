package com.estate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="district")
public class DistrictEntity  extends BaseEntity{
    private static final long serialVersionUID = 5011269144935601733L;

    @Column
    private String name;

    @Column
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
