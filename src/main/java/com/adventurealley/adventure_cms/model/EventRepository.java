package com.adventurealley.adventure_cms.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;


public interface EventRepository extends JpaRepository<Event, Integer> {

    public List<Event> findAll();

    // Alternatively this: ("SELECT * FROM event WHERE event.start_date_time > ?0 AND event.activity_id=?1", nativeQuery =true)
    // Explanation of the query.
    // first e represents a value of type Event. Thos could have been e.activity_i if we wanted a specific column.
    // second e represents the item tyoe in table Event witch is events
    // the third e represents the value we want to compare our query parameter to. Here it is a LocalDateTime obj.
    // NB in this JPQL (JavaPersistensQueryLanguage) queries we use ?1 to represent the first parameter where native query use ?0 to represent the first queryparameter.
    @Query("select e from Event e where e.startDateTime > ?1 and e.activityId =?2")
    public List<Event> findEventsAfter(LocalDateTime dateTime, int activityId);

    //@Query("select e from Event e where e.activityId =?2")
    //public List<Event> findEventsAfter(int activityId);

}


