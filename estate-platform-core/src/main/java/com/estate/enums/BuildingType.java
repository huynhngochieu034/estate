package com.estate.enums;

public enum BuildingType {
    FURNITURE("Nội thất"),
    GROUNDFLOOR("Tầng trệt"),
    APARTMENT("Nguyên căn");

    private String value;

    BuildingType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
