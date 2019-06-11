package com.estate.dto;

public class DistrictDTO extends AbstractDTO<DistrictDTO> {
    private static final long serialVersionUID = 2556736443948966306L;

    private String name;
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
