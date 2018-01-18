package com.app1.smallApp1.models;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user", schema = "public")
public class User implements Serializable{
    private static final long serialVersionUID = -3009157732242241606L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    protected User(){}

    public User(String name, String email){
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString(){
        return String.format("User[id=%d, Name='%s', email='%s']", id, name, email);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
