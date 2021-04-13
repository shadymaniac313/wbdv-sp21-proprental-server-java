package com.example.wbdvsp21proprentalserverjava.models;

import javax.persistence.Column;
import javax.persistence.Entity;
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

    public UserAuth() {
    }

    public UserAuth(String username, String pwd) {
        this.username = username;
        this.pwd = pwd;
    }

    @OneToOne
    @MapsId
    @JoinColumn(name = "USER_ID")
    private User user;

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
