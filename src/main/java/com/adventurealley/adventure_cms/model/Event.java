package com.adventurealley.adventure_cms.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "activity_id")
    private int activityId;

    @Column(name = "start_date_time")
    private LocalDateTime startDateTime;

    @Column(name = "host_user_id")
    private int hostUserId;

    @Transient
    private String startDate;

    @Transient
    private String startTime;


    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public int getActivityId() { return activityId; }
    public void setActivityId(int activityId) { this.activityId = activityId; }

    public LocalDateTime getStartDateTime() { return startDateTime; }
    public void setStartDateTime(LocalDateTime startDateTime) { this.startDateTime = startDateTime; }

    public int getHostUserId() { return hostUserId; }
    public void setHostUserId(int hostUserId) { this.hostUserId = hostUserId; }

    public String getStartDate() {

        String[] parts = convertAndSplitLocalDateTime();
        startDate = parts[0];
        return startDate;
    }

    public String getStartTime() {

        String[] parts = convertAndSplitLocalDateTime();
        startTime = parts[1];
        return startTime;
    }


    private String[] convertAndSplitLocalDateTime(){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD hh:mm:ss");
        String[] parts = startDateTime.format(formatter).split(" ");

        return parts;
    }

}
