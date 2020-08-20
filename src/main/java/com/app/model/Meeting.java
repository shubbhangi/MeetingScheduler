package com.app.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.transaction.Transactional;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "meeting")
@Transactional
@DynamicUpdate
public class Meeting implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name = "meeting_id")
	private Integer meetingId;
	
	@Column(name = "room_no")
	private String roomNo;
	
	@Column(name = "date")
	private LocalDate date;
	
	private LocalTime toTime;
	
	private LocalTime fromTime;
	
	@Column(name = "agenda")
	private String agenda;
	
	@Column(name = "status")
	private String status;

//	@OneToOne(cascade = javax.persistence.CascadeType.ALL)
//	@JoinColumn(name ="meeting_id")
//	private User user;
	
	public Meeting() {
		super();
	}

	

	public Integer getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(Integer meetingId) {
		this.meetingId = meetingId;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getToTime() {
		return toTime;
	}

	public void setToTime(LocalTime toTime) {
		this.toTime = toTime;
	}

	public LocalTime getFromTime() {
		return fromTime;
	}

	public void setFromTime(LocalTime fromTime) {
		this.fromTime = fromTime;
	}

	public String getAgenda() {
		return agenda;
	}

	public void setAgenda(String agenda) {
		this.agenda = agenda;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "Meeting [meetingId=" + meetingId + ", roomNo=" + roomNo + ", date=" + date + ", toTime=" + toTime
				+ ", fromTime=" + fromTime + ", agenda=" + agenda + ", status=" + status + "]";
	}

	
}
