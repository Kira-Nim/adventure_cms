package com.adventurealley.adventure_cms.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {

    public List<Activity> findAll();

}
