package com.app.service.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Room;
import com.app.model.User;
import com.app.repo.RoomRepository;
import com.app.service.IRoomService;

@Service
public class RoomServiceImpl implements IRoomService {

	@Autowired
	private EntityManager EntityManager;
	
	@Autowired
	private RoomRepository roomRepository;
	
	@Override
	public Room save(Room room) {
		// TODO Auto-generated method stub
		return roomRepository.save(room);
	}

	@Override
	public Room getOneById(int roomId) {
		// TODO Auto-generated method stub
		return roomRepository.getOne(roomId);
	}

	@Override
	public void deleteById(int roomId) {
		roomRepository.deleteById(roomId);
	}

	@Override
	public List<Room> getRoomList() {
		// TODO Auto-generated method stub
		return roomRepository.findAll();
	}

	@Override
	public Room getRoomByRoomno(String room) {
		return (Room) EntityManager.createQuery("from Room where room_no=:roomNo ")
				.setParameter("roomNo", room)
				
				.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getRoomnoList() {
		return (List<String>) EntityManager.createQuery("select room_no from Room ")
				.getResultList();
	}

}
