package za.co.shrinkspace.mvp.models;

import java.io.Serializable;

public class Business implements Serializable {
    private String uid;
    private String names;
    private String email;
    private String phone;
    private String about;
    private String status;
    private boolean isOnline;
    private String createdAt;
    private String sector;
    private String profession;

    public Business() {
    }

    public Business(String uid, String names, String email, String phone, String about, String status, boolean isOnline, String createdAt, String sector, String profession) {
        this.uid = uid;
        this.names = names;
        this.email = email;
        this.phone = phone;
        this.about = about;
        this.status = status;
        this.isOnline = isOnline;
        this.createdAt = createdAt;
        this.sector = sector;
        this.profession = profession;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
