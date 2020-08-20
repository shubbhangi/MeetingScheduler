package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.app.model.Meeting;

public interface MeetingRepository extends JpaRepository<Meeting, Integer>, JpaSpecificationExecutor<Meeting> {

}
