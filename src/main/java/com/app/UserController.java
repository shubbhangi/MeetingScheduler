package com.app;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

import com.app.model.Empty;
import com.app.model.Meeting;
import com.app.model.ResponseObject;
import com.app.model.User;
import com.app.service.IMeetingService;
import com.app.service.IUserService;
import com.app.service.impl.MeetingServiceImpl;



@Controller
@RequestMapping("/userurl")
public class UserController {

	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private IUserService userService ;
	
	@Autowired
	private IMeetingService meetingService;	
	
	@Autowired
	private ResponseObject responseObject;
	
	@Autowired
	private Empty empty;
	
	@PostMapping("/saveuser")
	public ResponseEntity<User> addUser(
			@RequestParam(value ="user_name" , required=false)String username ,
			@RequestParam(value ="mobile_number" , required=false)String mobilenumber){
		
		User user = new User();
		
		user.setUserName(username);
		user.setMobileNumber(mobilenumber);
		user.setCreateDate(LocalDateTime.now());
		user = userService.save(user);
		return ResponseEntity.ok(user);
	}
	@PostMapping("/saveall")
	public ResponseEntity<ResponseObject> addRoom(
			@RequestParam(value ="room_no" , required=false)String roomNo ,
			@RequestParam(value ="date" , required=false)String date,
			@RequestParam(value ="to_time" , required=false)String toTime,
			@RequestParam(value ="from_time" , required=false)String fromTime,		
			@RequestParam(value ="agenda" , required=false)String agenda,
			@RequestParam(value ="status" , required=false)String status,
			@RequestParam(value ="user_name" , required=false)String username){
			
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date1 = LocalDate.parse(date, formatter);
		
		DateTimeFormatter timeformatter = DateTimeFormatter.ofPattern("HH.mm"); 
		LocalTime to = LocalTime.parse(toTime, timeformatter);
		LocalTime from = LocalTime.parse(fromTime, timeformatter);
		
		
		List<Meeting> meetingList= meetingService.getMeetingStatus(date1, from, roomNo);
		Meeting meeting = new Meeting();
		User user = userService.getUserByUsername(username);
		
		if(meetingList.isEmpty()) 
		{
			
		meeting.setRoomNo(roomNo);
		meeting.setDate(date1);
		meeting.setToTime(to);
		meeting.setFromTime(from);
		meeting.setAgenda(agenda);
		meeting.setStatus(status);
		
		
		 user.getMeetingList().add(meeting);
		 user = userService.save(user);
		user.getMeetingList().stream()  
        	.filter(m ->m.getStatus()=="booked");   // filtering price  
		
		responseObject.setData(user);
		responseObject.setError("0");
		responseObject.setMessage("Meeting Booked Successfuly");
		responseObject.setStatus("Success");
		}
		else {
			responseObject.setData(empty);
			responseObject.setError("1");
			responseObject.setMessage("Room does not available");
			responseObject.setStatus("Fail");
			
		}
		return ResponseEntity.ok(responseObject);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUser(
			@PathVariable(value = "userId", required=false) int userId){
		
		User user = userService.getOneById(userId);
		
		return ResponseEntity.ok(user);
	}
	
	
	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<String> deleteUserById(
			@PathVariable(value = "userId", required=false) int userId){
		
		userService.deleteById(userId);;
		
		return ResponseEntity.ok("USER DELETED SUCCESSFULLY");
	}
	@GetMapping
	public ResponseEntity<List<User>> getUserList(){
		
		List<User> userList = userService.getUserList();
		
		return ResponseEntity.ok(userList);
	}
}
