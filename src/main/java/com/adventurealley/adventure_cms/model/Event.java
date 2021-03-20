package com.adventurealley.adventure_cms.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SerializedName("id")
    @Expose
    private Integer id;

    @Column(name = "activity_id")
    @SerializedName("activityId")
    @Expose
    private int activityId;

    @Column(name = "start_date_time")
    @SerializedName("startDateTime")
    @Expose
    private LocalDateTime startDateTime;

    @Column(name = "host_user_id")
    @SerializedName("hostUserId")
    @Expose
    private int hostUserId;

    @Transient
    @SerializedName("startDate")
    @Expose
    private String startDate;

    @Transient
    @SerializedName("startTime")
    @Expose
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
        startDate = "Dato: " + parts[0];
        return startDate;
    }

    public String getStartTime() {
        String[] parts = convertAndSplitLocalDateTime();
        startTime = "Tid: " + parts[1];
        return startTime;
    }


    private String[] convertAndSplitLocalDateTime(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD hh:mm:ss");
        String[] parts = startDateTime.format(formatter).split(" ");

        return parts;
    }

}
