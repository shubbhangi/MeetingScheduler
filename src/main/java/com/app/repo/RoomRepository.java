package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.app.model.Room;

public interface RoomRepository extends JpaRepository<Room, Integer>, JpaSpecificationExecutor<Room> {

}
