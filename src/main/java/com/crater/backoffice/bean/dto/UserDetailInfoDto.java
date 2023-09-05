package com.crater.backoffice.bean.dto;

import java.time.LocalDateTime;

public class UserDetailInfoDto {
    private int serNo;
    private String userId;
    private String email;
    private String userPassword;
    private int version;
    private LocalDateTime crtDt;
    private String crtUserId;
    private LocalDateTime updDt;
    private String updUserId;

    public UserDetailInfoDto(int serNo, String userId, String email, String userPassword, int version, LocalDateTime crtDt, String crtUserId, LocalDateTime updDt, String updUserId) {
        this.serNo = serNo;
        this.userId = userId;
        this.email = email;
        this.userPassword = userPassword;
        this.version = version;
        this.crtDt = crtDt;
        this.crtUserId = crtUserId;
        this.updDt = updDt;
        this.updUserId = updUserId;
    }

    public int getSerNo() {
        return serNo;
    }

    public UserDetailInfoDto setSerNo(int serNo) {
        this.serNo = serNo;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public UserDetailInfoDto setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDetailInfoDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public UserDetailInfoDto setUserPassword(String userPassword) {
        this.userPassword = userPassword;
        return this;
    }

    public int getVersion() {
        return version;
    }

    public UserDetailInfoDto setVersion(int version) {
        this.version = version;
        return this;
    }

    public LocalDateTime getCrtDt() {
        return crtDt;
    }

    public UserDetailInfoDto setCrtDt(LocalDateTime crtDt) {
        this.crtDt = crtDt;
        return this;
    }

    public String getCrtUserId() {
        return crtUserId;
    }

    public UserDetailInfoDto setCrtUserId(String crtUserId) {
        this.crtUserId = crtUserId;
        return this;
    }

    public LocalDateTime getUpdDt() {
        return updDt;
    }

    public UserDetailInfoDto setUpdDt(LocalDateTime updDt) {
        this.updDt = updDt;
        return this;
    }

    public String getUpdUserId() {
        return updUserId;
    }

    public UserDetailInfoDto setUpdUserId(String updUserId) {
        this.updUserId = updUserId;
        return this;
    }
}
