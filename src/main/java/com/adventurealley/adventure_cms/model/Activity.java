package com.adventurealley.adventure_cms.model;

import javax.persistence.*;
import java.text.DecimalFormat;
import java.time.LocalDateTime;

@Entity // This tells Hibernate that an matching db table exist that can be mapped to this class.
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String description;
    private float price;

    @Column(name="duration_minutes")
    private int durationMinutes;

    @Column(name = "min_age")
    private int minAge;

    @Column(name = "max_participants")
    private int maxParticipants;

    @Column(name = "photo_url")
    private String photoURL;


    // Getters and setters for all attributes
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public float getPrice() { return price; }

    public void setPrice(float price) { this.price = price; }

    public int getMinAge() { return minAge; }
    public void setMinAge(int minAge) { this.minAge = minAge; }

    public int getMaxParticipants() { return maxParticipants; }
    public void setMaxParticipants(int maxParticipants) { this.maxParticipants = maxParticipants; }

    public int getDurationMinutes() { return durationMinutes; }
    public void setDuration(int duration) { this.durationMinutes = duration; }

    public String getPhotoURL() { return photoURL; }
    public void setPhotoURL(String photoURL) { this.photoURL = photoURL; }
}
