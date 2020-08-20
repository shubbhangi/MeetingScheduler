package com.app.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.app.model.Meeting;

public interface IMeetingService {

	public Meeting save(Meeting meeting);
	
	public Meeting getOneById(int meetingId);
	public void deleteById(int meetingId);
	public List<Meeting> getMeetingList();
	
	public List<Meeting> getMeetingStatus(LocalDate date1,LocalTime from,String roomno);
	
	List<Meeting> getMeetingByDate(LocalDate date1);
	List<Meeting> getMeetingByRoom(String roomNo);
}
