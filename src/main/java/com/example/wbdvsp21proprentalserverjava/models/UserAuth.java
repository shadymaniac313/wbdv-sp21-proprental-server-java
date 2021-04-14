package com.example.wbdvsp21proprentalserverjava.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "auth")
public class UserAuth {

    @Id
    @Column(name = "USER_ID")
    private int userId;
    private String username;
    private String pwd;
    @OneToOne(fetch = FetchType.LAZY, cascade= CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "USER_ID")
    @JsonBackReference
    private User user;


    public UserAuth() {
    }

    public UserAuth(String username, String pwd) {
        this.username = username;
        this.pwd = pwd;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
