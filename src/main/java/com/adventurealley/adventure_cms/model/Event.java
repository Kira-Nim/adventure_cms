package com.adventurealley.adventure_cms.model;

import javax.persistence.*;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "activity_id")
    private int activityId;

    @Column(name = "start_date_time")
    private int startDateTime;

    @Column(name = "end_date_time")
    private int endDateTime;

    @Column(name = "host_user_id")
    private int hostUserId;


    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public int getActivityId() { return activityId; }
    public void setActivityId(int activityId) { this.activityId = activityId; }

    public int getStartDateTime() { return startDateTime; }
    public void setStartDateTime(int startDateTime) { this.startDateTime = startDateTime; }

    public int getEndDateTime() { return endDateTime; }
    public void setEndDateTime(int endDateTime) { this.endDateTime = endDateTime; }

    public int getHostUserId() { return hostUserId; }
    public void setHostUserId(int hostUserId) { this.hostUserId = hostUserId; }
}
