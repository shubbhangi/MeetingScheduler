package com.app.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "room")
public class Room implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name = "id")
	private int id;
	
	@Column(name = "room_no")
	private String roomNo;
	
	@Column(name = "room_type")
	private String roomType;
	
	@Column(name = "create_date")
	private LocalDateTime createDate;
	public Room() {
		super();
	}
	public Room(int id, String roomNo, String roomType, LocalDateTime createDate) {
		super();
		this.id = id;
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.createDate = createDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public LocalDateTime getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "Room [id=" + id + ", roomNo=" + roomNo + ", roomType=" + roomType + ", createDate=" + createDate + "]";
	}
	
	
}
