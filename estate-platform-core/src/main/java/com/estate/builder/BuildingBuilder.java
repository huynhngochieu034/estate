package com.estate.builder;

public class BuildingBuilder {

    private String buildingName;
    private String district;
    private String ward;
    private String street;
    private Integer basementNumber;
    private Integer buildingArea;
    private String direction;
    private String level;
    private String managerName;
    private String managerPhoneNumber;;
    private String[] typeArrays = new String[]{};

    private String staffName;
    private Long staffId;
    private Integer areaFrom;
    private Integer areaTo;
    private Integer costFrom;
    private Integer costTo;

    public String getBuildingName() {
        return buildingName;
    }

    public String getDistrict() {
        return district;
    }

    public String getWard() {
        return ward;
    }

    public String getStreet() {
        return street;
    }

    public Integer getBasementNumber() {
        return basementNumber;
    }

    public Integer getBuildingArea() {
        return buildingArea;
    }

    public String getDirection() {
        return direction;
    }

    public String getLevel() {
        return level;
    }

    public String getManagerName() {
        return managerName;
    }

    public String getManagerPhoneNumber() {
        return managerPhoneNumber;
    }



    public String[] getTypeArrays() {
        return typeArrays;
    }

    public String getStaffName() {
        return staffName;
    }



    public Integer getAreaFrom() {
        return areaFrom;
    }

    public Integer getAreaTo() {
        return areaTo;
    }

    public Integer getCostFrom() {
        return costFrom;
    }

    public Integer getCostTo() {
        return costTo;
    }

    public Long getStaffId() {
        return staffId;
    }

    public BuildingBuilder(Builder builder) {
        this.buildingName = builder.buildingName;
        this.district = builder.district;
        this.ward = builder.ward;
        this.street = builder.street;
        this.buildingArea = builder.buildingArea;
        this.basementNumber = builder.basementNumber;
        this.direction = builder.direction;
        this.level = builder.level;
        this.managerName = builder.managerName;
        this.managerPhoneNumber = builder.managerPhoneNumber;
        this.typeArrays = builder.typeArrays;
        this.areaFrom = builder.areaFrom;
        this.areaTo = builder.areaTo;
        this.costFrom = builder.costFrom;
        this.costTo = builder.costTo;
        this.staffName = builder.staffName;
        this.staffId = builder.staffId;
    }


    public static class Builder {
        private String buildingName;
        private String district;
        private String ward;
        private String street;
        private Integer basementNumber;
        private Integer buildingArea;
        private String direction;
        private String level;
        private String managerName;
        private String managerPhoneNumber;;
        private String[] typeArrays = new String[]{};

        private String staffName;
        private Long staffId;
        private Integer areaFrom;
        private Integer areaTo;
        private Integer costFrom;
        private Integer costTo;

        public Builder setBuildingName(String buildingName) {
            this.buildingName = buildingName;
            return this;
        }

        public Builder setDistrict(String district) {
            this.district = district;
            return this;
        }

        public Builder setWard(String ward) {
            this.ward = ward;
            return this;
        }

        public Builder setStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder setBasementNumber(Integer basementNumber) {
            this.basementNumber = basementNumber;
            return this;
        }

        public Builder setBuildingArea(Integer buildingArea) {
            this.buildingArea = buildingArea;
            return this;
        }

        public Builder setDirection(String direction) {
            this.direction = direction;
            return this;
        }

        public Builder setLevel(String level) {
            this.level = level;
            return this;
        }

        public Builder setManagerName(String managerName) {
            this.managerName = managerName;
            return this;
        }

        public Builder setManagerPhoneNumber(String managerPhoneNumber) {
            this.managerPhoneNumber = managerPhoneNumber;
            return this;
        }

        public Builder setTypeArrays(String[] typeArrays) {
            this.typeArrays = typeArrays;
            return this;
        }

        public Builder setStaffName(String staffName) {
            this.staffName = staffName;
            return this;
        }

        public Builder setAreaFrom(Integer areaFrom) {
            this.areaFrom = areaFrom;
            return this;
        }

        public Builder setAreaTo(Integer areaTo) {
            this.areaTo = areaTo;
            return this;
        }

        public Builder setCostFrom(Integer costFrom) {
            this.costFrom = costFrom;
            return this;
        }

        public Builder setCostTo(Integer costTo) {
            this.costTo = costTo;
            return this;
        }
        public Builder setStaffId(Long staffId) {
            this.staffId = staffId;
            return this;
        }

        public BuildingBuilder build() {
            return new BuildingBuilder(this);
        }



    }
}
