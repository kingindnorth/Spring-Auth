package com.smart.smartcontact.entites;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank(message = "Name field cannot be empty")
    @Size(min = 4, max = 20 , message = "Name must be between 4 characters to 20 characters")
    private String name;

    @Column(unique = true)
    // @Email(message = "please enter a valid email id")
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",message = "Please enter a valid email address")
    private String email;

    @NotBlank(message = "Password filed must not be empty")
    // @Size(min = 6, max = 30, message = "your password must contain minimum 6 to maximum 30 characters")
    private String password;
    
    private String role;
    private boolean active;
    private String imageUrl;

    @Column(length = 500)
    private String about;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<Contact> contacts = new ArrayList<>();

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }    
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }    
    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
    


}
//	@NotBlank(message = "Name field is required !!")
	// @Size(min = 2,max = 20,message = "min 2 and max 20 characters are allowed !!")