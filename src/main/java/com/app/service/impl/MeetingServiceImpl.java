package com.app.service.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Meeting;
import com.app.model.Room;
import com.app.repo.MeetingRepository;
import com.app.service.IMeetingService;


@Service
public class MeetingServiceImpl implements IMeetingService {

	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private MeetingRepository meetingRepository;


	@Override
	public Meeting save(Meeting meeting) {
		// TODO Auto-generated method stub
		return meetingRepository.save(meeting);
	}

	@Override
	public Meeting getOneById(int meetingId) {
		// TODO Auto-generated method stub
		return meetingRepository.getOne(meetingId);
	}

	@Override
	public void deleteById(int meetingId) {
		// TODO Auto-generated method stub
		 meetingRepository.deleteById(meetingId);
	}

	@Override
	public List<Meeting> getMeetingList() {
		// TODO Auto-generated method stub
		return meetingRepository.findAll();
	}

	
	@SuppressWarnings("unchecked")
	@Override   
	public List<Meeting> getMeetingStatus(LocalDate date, LocalTime time, String roomno) {
	
		return (List<Meeting>) entityManager.createQuery("from Meeting where date=:date and from_time=:fromtime and room_no=:roomno and status='booked'")
				.setParameter("date", date)
				.setParameter("fromtime",time)
				.setParameter("roomno", roomno)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Meeting> getMeetingByDate(LocalDate date) {
		return (List<Meeting>) entityManager.createQuery("from Meeting where date=:date")
				.setParameter("date", date)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Meeting> getMeetingByRoom(String roomNo) {
		return (List<Meeting>) entityManager.createQuery("from Meeting where room_no=:roomNo")
				.setParameter("roomNo", roomNo)
				.getResultList();
	}

	
}
