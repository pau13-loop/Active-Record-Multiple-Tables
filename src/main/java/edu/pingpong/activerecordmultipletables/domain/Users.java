package edu.pingpong.activerecordmultipletables.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_users")
public class Users {

    @Id
    @Column(name = "user_name")
    public String user_name;

    @Column(name = "user_prop")
    public String userProp;

    public Users() {}

    public Users(String user_name, String userProp) {
        this.user_name = user_name;
        this.userProp = userProp;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUserProp() {
        return userProp;
    }

    public void setUserProp(String userProp) {
        this.userProp = userProp;
    }

    
}
