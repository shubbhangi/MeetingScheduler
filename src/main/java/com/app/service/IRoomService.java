package com.app.service;

import java.util.List;

import com.app.model.Room;

public interface IRoomService {

	public Room save(Room room);
	
	public Room getOneById(int roomId);
	public void deleteById(int roomId);
	public List<Room> getRoomList();

	List<String> getRoomnoList();

	Room getRoomByRoomno(String room);
	
	
}
