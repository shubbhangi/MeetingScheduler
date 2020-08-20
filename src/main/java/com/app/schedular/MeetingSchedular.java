package com.app.schedular;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class MeetingSchedular {
	@Autowired
	private EntityManager entityManager;

	@Transactional(rollbackOn=Exception.class)
	@Scheduled(cron = "0 * * * * *")
	public void getMeetingStatus() {
		
		String time= LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss"));
		
		entityManager.createQuery(
			  "UPDATE Meeting set status=:status WHERE date =:date and to_time >=:fromtime "
					  + "and from_time<=:fromtime and status =:status1")
	  
		  .setParameter("status", "IN_Use") 
		  .setParameter("date", LocalDate.now())
		  .setParameter("fromtime", time)  
		  .setParameter("status1", "booked") .executeUpdate();
	 
	}

	@Transactional(rollbackOn=Exception.class)
	@Scheduled(cron = "0 * * * * *")
	public void getMeetingStatusAvailable() {
		
		String time= LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss"));
		
		entityManager.createQuery(
			  "UPDATE Meeting set status=:status WHERE date =:date and to_time<=:fromtime "
					  + "and from_time<=:fromtime and status =:status1")
	  
		  .setParameter("status", "available") 
		  .setParameter("date", LocalDate.now())
		  .setParameter("fromtime", time)  
		  .setParameter("status1", "IN_Use") .executeUpdate();
	 
	}
	
}
