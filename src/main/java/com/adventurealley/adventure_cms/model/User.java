package com.adventurealley.adventure_cms.model;

import javax.persistence.*;

@Entity // This tells Hibernate that an matching db table exist that can be mapped to this class.
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String username;
    private String password;

    @Column(name = "admin_access")
    private String adminAccess;



    // Getters and setters for all attributes
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getAdminAccess() { return adminAccess; }
    public void setAdminAccess(String admin_access) { this.adminAccess = admin_access; }
}

