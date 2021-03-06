package com.estate.dto;

public class UserDTO extends AbstractDTO {

    private String userName;
    private String fullName;
    private String password;
    private Integer status;
    private String checked;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getChecked() {
        return checked != null ? checked : "";
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }
}
