package com.smart.smartcontact.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CONTACT")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String nickName;
    private String work;
    private String email;
    private String phone;
    private String image;

    @Column(length = 1000)
    private String description;

    @ManyToOne
    private User user;

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setNickName(String nickName){
        this.nickName = nickName;
    }
    public String getNickName(){
        return nickName;
    }
    public void setWork(String work){
        this.work = work;
    }
    public String getWork(){
        return work;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getPhone(){
        return phone;
    }
    public void setImage(String image){
        this.image = image;
    }
    public String getImage(){
        return image;
    }

}
