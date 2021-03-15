package com.adventurealley.adventure_cms.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity // This tells Hibernate that an matching db table exist that can be mapped to this class.
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String description;

    @Column(name = "start_date_time")
    private LocalDateTime startDateTime;

    @Column(name = "end_date_time")
    private LocalDateTime end_date_time;

    private float price;

    @Column(name = "host_user_id")
    private int hostUserId;

    @Column(name = "min_age")
    private int minAge;

    @Column(name = "max_participants")
    private int maxParticipants;


    // Getters and setters for all attributes
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDateTime getStartDateTime() { return startDateTime; }

    public void setStartDateTime(LocalDateTime startDateTime) { this.startDateTime = startDateTime; }

    public LocalDateTime getEnd_date_time() { return end_date_time; }
    public void setEnd_date_time(LocalDateTime end_date_time) { this.end_date_time = end_date_time; }

    public float getPrice() { return price; }
    public void setPrice(float price) { this.price = price; }

    public int getHostUserId() { return hostUserId; }
    public void setHostUserId(int hostUserId) { this.hostUserId = hostUserId; }

    public int getMinAge() { return minAge; }
    public void setMinAge(int minAge) { this.minAge = minAge; }

    public int getMaxParticipants() { return maxParticipants; }
    public void setMaxParticipants(int maxParticipants) { this.maxParticipants = maxParticipants; }

}
