package com.app;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.tomcat.jni.Mmap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Meeting;
import com.app.model.Room;
import com.app.model.User;
import com.app.service.IMeetingService;
import com.app.service.IUserService;

@Controller
@RequestMapping("/meetingurl")
public class MeetingController {
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private IMeetingService meetingService;
	
	@Autowired
	private IUserService userService;
	
	@GetMapping("/{meetingId}")
	public ResponseEntity<Meeting> getMeeting(
			@PathVariable(value = "meetingId", required=false) Integer meetingId){
		
		Meeting meeting = meetingService.getOneById(meetingId);
		return ResponseEntity.ok(meeting);
	}
	@DeleteMapping("/deleteRoom/{meetingId}")
	public ResponseEntity<String> deleteMeetingById(
			@PathVariable(value = "meetingId", required=false) Integer meetingId){
		
		meetingService.deleteById(meetingId);;	
		return ResponseEntity.ok("Meeting DELETED SUCCESSFULLY");
	}
	@GetMapping
	public ResponseEntity<List<Meeting>> getMeetingList(){
		
		List<Meeting> meetingList = meetingService.getMeetingList();
		
		return ResponseEntity.ok(meetingList);
	}
	
	@PostMapping("/getMeetingStatus")
	public ResponseEntity<List<Meeting>> getMeetingStaus(
			@RequestParam(value ="room_no" , required=false)String roomNo ,
			@RequestParam(value ="date" , required=false)String date,
			@RequestParam(value ="from_time" , required=false)String fromTime){
			
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date1 = LocalDate.parse(date, formatter);
		
		DateTimeFormatter timeformatter = DateTimeFormatter.ofPattern("HH.mm"); 
		LocalTime from = LocalTime.parse(fromTime, timeformatter);
		
    	List<Meeting> meeting = meetingService.getMeetingStatus(date1, from, roomNo);
		
		return ResponseEntity.ok(meeting);
	}
	
	@PostMapping("/getMeetingByDate")
	public ResponseEntity<List<Meeting>> getMeetingStaus(
			@RequestParam(value ="date" , required=false)String date){
			
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date1 = LocalDate.parse(date, formatter);

    	List<Meeting> meeting = meetingService.getMeetingByDate(date1);
		
		return ResponseEntity.ok(meeting);
	}
	
	
	@PostMapping("/getMeetingByRoom")
	public ResponseEntity<List<Meeting>> getMeetingByRoom(
			@RequestParam(value ="room_no" , required=false)String roomno){
				
    	List<Meeting> meeting = meetingService.getMeetingByRoom(roomno);
		return ResponseEntity.ok(meeting);
	}
	
}
			
