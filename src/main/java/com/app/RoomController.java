package com.app;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Room;
import com.app.model.User;
import com.app.service.IRoomService;


@Controller
@RequestMapping("/roomurl")
public class RoomController {

	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private IRoomService roomService;
	
	@PostMapping("/saveroom")
	public ResponseEntity<Room> addRoom (
			@RequestParam(value = "room_no" ,required = false)String roomNo ,
			@RequestParam(value = "room_type" ,required = false)String roomType){
		
		Room room = new Room();
		room.setRoomNo(roomNo);
		room.setRoomType(roomType);
		room.setCreateDate(LocalDateTime.now());
		room = roomService.save(room);
		return ResponseEntity.ok(room);
		
	}
	@GetMapping("/{roomId}")
	public ResponseEntity<Room> getRoom(
			@PathVariable(value = "roomId", required=false) int roomId){
		
		Room room = roomService.getOneById(roomId);
		return ResponseEntity.ok(room);
	}
	
	@DeleteMapping("/deleteRoom/{roomId}")
	public ResponseEntity<String> deleteRoomById(
			@PathVariable(value = "roomId", required=false) int roomId){
		
		roomService.deleteById(roomId);;	
		return ResponseEntity.ok("Room DELETED SUCCESSFULLY");
	}
	@GetMapping
	public ResponseEntity<List<Room>> getRoomList(){
		
		List<Room> roomList = roomService.getRoomList();
		
		return ResponseEntity.ok(roomList);
	}		
	
	@GetMapping("/roomnolist")
	public ResponseEntity<List<String>> getRoomNoList(){
		
		List<String> roomList = roomService.getRoomnoList();
		
		return ResponseEntity.ok(roomList);
	}
	
}
